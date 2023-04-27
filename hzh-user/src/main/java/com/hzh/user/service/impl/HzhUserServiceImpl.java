package com.hzh.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzh.common.mapper.user.HzhUserTokenMapper;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.dto.RegisterDTO;
import com.hzh.common.pojo.user.HzhUser;
import com.hzh.common.mapper.user.HzhUserMapper;
import com.hzh.common.pojo.user.HzhUserToken;
import com.hzh.common.respone.Result;
import com.hzh.common.utils.BaseService;
import com.hzh.common.utils.*;
import com.hzh.user.service.HzhUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Slf4j
@Service
public class HzhUserServiceImpl extends ServiceImpl<HzhUserMapper,HzhUser> implements HzhUserService {

    @Resource
    private HzhUserMapper hzhUserMapper;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private RedisKeyUtil redisKeyUtil;

    @Resource
    private PasswordEncoder bCryptPasswordEncoder;

    @Override
    public Result registerUser(RegisterDTO registerDTO)  {
        try {
            String currentdate = DateUtils.getCurrent(DateUtils.dateFullPattern);

            //判断邮箱是否以已经注册 是否为空
            if (registerDTO.getEmail().isEmpty()){
                return Result.FAILED("注册邮箱不可以为空");
            }
            //根据用户名、手机号、邮箱进行查询
            QueryWrapper<HzhUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_name", registerDTO.getUserName())
                    .or().eq("email",registerDTO.getEmail())
                    .or().eq("phonenumber",registerDTO.getPhonenumber());
            HzhUser hasHzhUser = hzhUserMapper.selectOne(queryWrapper);
            if (hasHzhUser != null && hasHzhUser.getEmail().equals(registerDTO.getEmail())){
                return Result.FAILED("该邮箱已注册");
            }
            // 判断用户名是否被使用
            if (hasHzhUser != null && hasHzhUser.getUserName().equals(registerDTO.getUserName())){
                return Result.FAILED("用户名已存在");
            }
            //对手机号进行判断
            boolean isPhone = FormatCheckUtils.isMobile(registerDTO.getPhonenumber());
            if (!isPhone ){
                return Result.FAILED("手机号格式错误");
            }
            if (hasHzhUser != null){
                return Result.FAILED("该手机号已注册");
            }
            //判断验证码是否正确
            String codeRedisKey = redisKeyUtil.mkRegisterCodeRedisKey(registerDTO.getEmail());
            String redisCode = redisUtils.get(codeRedisKey);
            if ( redisCode == null || !redisCode.substring(26,32).equals(registerDTO.getMailCode())){
                return Result.FAILED("验证码错误");
            }

            //对密码进行校验
            // TODO
//            if (registerDTO.getPassword().length() != 32){
//                return Result.FAILED("请使用MD5摘要算法进行转换");
//            }

            HzhUser hzhUserInsert = new HzhUser();
            hzhUserInsert.setUserName(registerDTO.getUserName());
            //密码加密
            hzhUserInsert.setPassword(bCryptPasswordEncoder.encode(registerDTO.getPassword()));
            hzhUserInsert.setUserDescription(Constants.UserDescription.MEMEBR_USER);
            hzhUserInsert.setStatus(Constants.User.UNFORBIDDENT_STATE);
            hzhUserInsert.setEmail(registerDTO.getEmail());
            hzhUserInsert.setPhonenumber(registerDTO.getPhonenumber());
            if(registerDTO.getSex().equals("1") || registerDTO.getSex().equals("2")){
                hzhUserInsert.setSex(registerDTO.getSex());
            }else {
                hzhUserInsert.setSex("1");
            }
            //设置默认头像
            hzhUserInsert.setAvatar("https://cdn.sunofbeaches.com/images/default_avatar.png");
            hzhUserInsert.setUserType(Constants.UserType.MEMEBR_USER);
            hzhUserInsert.setCreateTime(currentdate);
            hzhUserInsert.setUpdateBy(registerDTO.getUpdateBy());
            hzhUserInsert.setSalt(IdWorker.getIdStr());
            hzhUserInsert.setUpdateTime(currentdate);
            hzhUserInsert.setDelFlag(Constants.User.UNFORBIDDENT_STATE);

            int add = hzhUserMapper.insert(hzhUserInsert);
            if(add == 1){
                return Result.SUCCESS("用户注册成功");
            }else {
                return Result.FAILED("用户注册失败");
            }
        } catch (Exception e) {
            log.error("registerUser error ", e);
            throw new RuntimeException("registerUser error");
        }
    }

    @Override
    public IPage<HzhUser> selectPage(Page<HzhUser> page) {
        try {
            IPage<HzhUser> hzhUserIPage = hzhUserMapper.selectPage(page, null);
            return hzhUserIPage;

        } catch (Exception e) {
            log.error("HzhUser selectPage error ", e);
            throw new RuntimeException("HzhUser  selectPage error");
        }
    }

    @Override
    public Result sendEmailCode(String email) {
        try {
            String date = DateUtils.getCurrent(DateUtils.ticketPattern);

            //对邮箱地址校验
            boolean isEmailTrue = FormatCheckUtils.isEmail(email);
            if (!isEmailTrue){
                //邮箱格式不正确
                return Result.FAILED("邮箱格式不正确，请检查邮箱格式");
            }

            QueryWrapper<HzhUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("email",email);
            queryWrapper.select("id");
            HzhUser selectOne = hzhUserMapper.selectOne(queryWrapper);
            if (selectOne != null){
                return Result.FAILED("该邮箱已经注册");
            }

            //ip地址 直接使用工具类
            String remoteAddr = BaseService.getRequest().getRemoteAddr();
            remoteAddr = remoteAddr.replaceAll(":", "-");
            log.info("客户端Ip地址为 ...{}",remoteAddr);

            //预防恶意攻击
            //通过ip地址判断是否频繁发送
            String registerIpRedisKey = redisKeyUtil.mkRegisterIPRedisKey(remoteAddr);
            String ipKeyTimes = redisUtils.get(registerIpRedisKey);
            if (!StringUtils.isEmpty(ipKeyTimes)){
                int i = Integer.parseInt(ipKeyTimes);
                log.info("当前ip{}调用了{}次",remoteAddr,i);
                if (i > 100){
                    return Result.FAILED("请不要通过此ip"+remoteAddr+"频繁发送");
                }else {
                    i++;
                    //2  时间数量   TimeUnit.HOURS 时间单位
                    redisUtils.set(registerIpRedisKey,String.valueOf(i), 2, TimeUnit.HOURS);
                }
            }else {
                //俩小时内有校
                redisUtils.set(registerIpRedisKey,"1",2,TimeUnit.HOURS);
            }

            //预防恶意攻击
            //通过邮箱账号判断是否频繁发送
            String registerEmailRedisKey = redisKeyUtil.mkRegisterEmailRedisKey(email);
            String emailKeyTimes = redisUtils.get(registerEmailRedisKey);
            if (!StringUtils.isEmpty(emailKeyTimes)){
                int i = Integer.parseInt(emailKeyTimes);
                log.info("当前邮箱{}已经调用了{}次",email , i);
                //TODO 次数是属于配置项 一般都不是写死得 需要抽取出来到可配置得地方
                if (i > 100){
                    return Result.FAILED("请不要通过此邮箱账号"+ email + "频繁发送");
                }else {
                    i++;
                    //2  时间数量   TimeUnit.HOURS 时间单位
                    redisUtils.set(registerEmailRedisKey,String.valueOf(i), 2, TimeUnit.HOURS);
                }
            }else {
                //俩小时内有校
                redisUtils.set(registerEmailRedisKey,"1",2, TimeUnit.HOURS);
            }

            //产生验证码，记录验证码
            Random random = new Random();
            //产生6位数  取值范围（0，999999） 有可能只有1位  可以通过+100000的方式得到俩位数的验证码
            int mailCode = random.nextInt(999999);
            if (mailCode < 100000){
                mailCode += 100000;
            }
            log.info("六位数的验证码为：{}",mailCode);
            //保存到redis中  验证码5min有效
            String codeRedisKey = redisKeyUtil.mkRegisterCodeRedisKey(email);
            redisUtils.set(codeRedisKey, date +"的注册验证码："+mailCode,5,TimeUnit.MINUTES);
            //TODO  实际注册时放开  发送验证码
            //EmailSender.sendEmailSendCode(emailAddress, "注册验证码："+ mailCode +",5分钟内有效！");
            return Result.SUCCESS("邮箱验证发送成功");
        }catch (Exception e){
            log.error(" error",e);
            throw new RuntimeException(" error");
        }
    }

    @Override
    public Result updatePasswordByuserSelf(RegisterDTO registerDTO) {
        try {
            String date = DateUtils.getCurrent(DateUtils.ticketPattern);
            //判断验证码是否正确
            String codeRedisKey = redisKeyUtil.mkRegisterCodeRedisKey(registerDTO.getEmail());
            String redisCode = redisUtils.get(codeRedisKey);
            if ( redisCode == null || !redisCode.substring(26,32).equals(registerDTO.getMailCode())){
                return Result.FAILED("验证码错误");
            }

            //对邮箱地址校验
            boolean isEmailTrue = FormatCheckUtils.isEmail(registerDTO.getEmail());
            if (!isEmailTrue){
                //邮箱格式不正确
                return Result.FAILED("邮箱格式不正确");
            }
            //对手机号进行判断
            boolean isPhone = FormatCheckUtils.isMobile(registerDTO.getPhonenumber());
            if (!isPhone ){
                return Result.FAILED("手机号码格式不正确");
            }

            //根据用户名、手机号、邮箱进行查询
            QueryWrapper<HzhUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_name", registerDTO.getUserName())
                    .or().eq("email",registerDTO.getEmail())
                    .or().eq("phonenumber",registerDTO.getPhonenumber());
            HzhUser hasHzhUser = hzhUserMapper.selectOne(queryWrapper);

            if (hasHzhUser != null){
                UpdateWrapper<HzhUser> updateWrapper = new UpdateWrapper<>();
                updateWrapper.lambda()
                        .eq(HzhUser::getEmail, registerDTO.getEmail())
                        .eq(HzhUser::getPhonenumber, registerDTO.getPhonenumber())
                        .set(HzhUser::getPassword, bCryptPasswordEncoder.encode(registerDTO.getPassword()))
                        .set(HzhUser::getUpdateTime, date);
                int uodateRow = hzhUserMapper.update(null, updateWrapper);

                if (uodateRow == 1 ){
                    return Result.SUCCESS("密码修改成功");
                } else {
                return Result.FAILED("密码修改失败");
            }
            }else {
                return Result.FAILED("该用户未注册");
            }

        }catch (Exception e){
            log.error(" error",e);
            throw new RuntimeException(" error");
        }
    }

    @Override
    public Result sendEmailCodeWhenUpdatePassword(String email) {
        try {
            String date = DateUtils.getCurrent(DateUtils.ticketPattern);

            //对邮箱地址校验
            boolean isEmailTrue = FormatCheckUtils.isEmail(email);
            if (!isEmailTrue){
                //邮箱格式不正确
                return Result.FAILED("邮箱格式不正确，请检查邮箱格式");
            }

            QueryWrapper<HzhUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("email",email);
            HzhUser selectOne = hzhUserMapper.selectOne(queryWrapper);
            if (selectOne == null){
                return Result.FAILED("该邮箱未注册");
            }

            //ip地址 直接使用工具类
            String remoteAddr = BaseService.getRequest().getRemoteAddr();
            remoteAddr = remoteAddr.replaceAll(":", "-");
            log.info("客户端Ip地址为 ...{}",remoteAddr);

            //预防恶意攻击
            //通过ip地址判断是否频繁发送
            String updatePasswordIpRedisKey = redisKeyUtil.mkUpdatePasswordIPRedisKey(remoteAddr);
            String ipKeyTimes = redisUtils.get(updatePasswordIpRedisKey);
            if (!StringUtils.isEmpty(ipKeyTimes)){
                int i = Integer.parseInt(ipKeyTimes);
                log.info("当前ip{}调用了{}次",remoteAddr,i);
                if (i > 100){
                    return Result.FAILED("请不要通过此ip"+remoteAddr+"频繁发送");
                }else {
                    i++;
                    //2  时间数量   TimeUnit.HOURS 时间单位
                    redisUtils.set(updatePasswordIpRedisKey,String.valueOf(i), 2, TimeUnit.HOURS);
                }
            }else {
                //俩小时内有校
                redisUtils.set(updatePasswordIpRedisKey,"1",2,TimeUnit.HOURS);
            }

            //预防恶意攻击
            //通过邮箱账号判断是否频繁发送
            String registerEmailRedisKey = redisKeyUtil.mkRegisterEmailRedisKey(email);
            String emailKeyTimes = redisUtils.get(registerEmailRedisKey);
            if (!StringUtils.isEmpty(emailKeyTimes)){
                int i = Integer.parseInt(emailKeyTimes);
                log.info("当前邮箱{}已经调用了{}次",email , i);
                //TODO 次数是属于配置项 一般都不是写死得 需要抽取出来到可配置得地方
                if (i > 100){
                    return Result.FAILED("请不要通过此邮箱账号"+ email + "频繁发送");
                }else {
                    i++;
                    //2  时间数量   TimeUnit.HOURS 时间单位
                    redisUtils.set(registerEmailRedisKey,String.valueOf(i), 2, TimeUnit.HOURS);
                }
            }else {
                //俩小时内有校
                redisUtils.set(registerEmailRedisKey,"1",2, TimeUnit.HOURS);
            }

            //产生验证码，记录验证码
            Random random = new Random();
            //产生6位数  取值范围（0，999999） 有可能只有1位  可以通过+100000的方式得到俩位数的验证码
            int mailCode = random.nextInt(999999);
            if (mailCode < 100000){
                mailCode += 100000;
            }
            log.info("六位数的验证码为：{}",mailCode);
            //保存到redis中  验证码5min有效
            String codeRedisKey = redisKeyUtil.mkRegisterCodeRedisKey(email);
            redisUtils.set(codeRedisKey, date +"的注册验证码："+mailCode,5,TimeUnit.MINUTES);
            //TODO  实际注册时放开  发送验证码
            //EmailSender.sendEmailSendCode(emailAddress, "注册验证码："+ mailCode +",5分钟内有效！");
            return Result.SUCCESS("邮箱验证发送成功");
        }catch (Exception e){
            log.error(" error",e);
            throw new RuntimeException(" error");
        }
    }


}
