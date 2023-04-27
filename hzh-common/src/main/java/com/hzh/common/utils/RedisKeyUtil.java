package com.hzh.common.utils;
import org.springframework.stereotype.Component;

@SuppressWarnings(value = { "unchecked", "rawtypes" })
@Component
public class RedisKeyUtil {

    /**
     * 生成用户注册ip相关键名
     * @param
     * @return
     */
    public String mkRegisterIPRedisKey(String  remoteAddr) throws Exception{
        StringBuffer stringBuffer = new StringBuffer("User");
        stringBuffer.append(":")
                .append("Register")
                .append(":")
                .append(remoteAddr);
        return stringBuffer.toString().trim();
    }


    /**
     * 生成用户注册邮箱相关键名
     * @param
     * @return
     */
    public String mkRegisterEmailRedisKey(String  emailAddress) throws Exception{
        StringBuffer stringBuffer = new StringBuffer("User");
        stringBuffer.append(":")
                .append("Register")
                .append(":")
                .append(emailAddress)
                .append(":")
                .append("H");
        return stringBuffer.toString().trim();
    }


    /**
     * 生成用户注册验证码键名
     * @param
     * @return
     */
    public String mkRegisterCodeRedisKey(String emailAddress) throws Exception{
        StringBuffer stringBuffer = new StringBuffer("User");
        stringBuffer.append(":")
                .append("Register")
                .append(":")
                .append(emailAddress);
        return stringBuffer.toString().trim();
    }

    /**
     * 生成用户注册验证码键名
     * @param
     * @return
     */
    public String mkForgotCodeRedisKey(String emailAddress) throws Exception{
        StringBuffer stringBuffer = new StringBuffer("User");
        stringBuffer.append(":")
                .append("forgot")
                .append(":")
                .append(emailAddress);
        return stringBuffer.toString().trim();
    }

    public String mkUserTokenSaltKey(String tokenkey) {
        StringBuffer stringBuffer = new StringBuffer("User");
        stringBuffer.append(":")
                .append("Salt")
                .append(":")
                .append(tokenkey);
        return stringBuffer.toString().trim();
    }

    //篮球订单key
    public String mkBasketBallOrderInfo(String orderId, Long userId, String data) {
        StringBuffer stringBuffer = new StringBuffer("Order");
        stringBuffer.append(":")
                .append("Basketball")
                .append(":")
                .append(orderId)
                .append(":")
                .append(userId)
                .append(":")
                .append(data);
        return stringBuffer.toString().trim();
    }

    public String mkUpdatePasswordIPRedisKey(String remoteAddr) {
        StringBuffer stringBuffer = new StringBuffer("User");
        stringBuffer.append(":")
                .append("UpdatePassword")
                .append(":")
                .append(remoteAddr);
        return stringBuffer.toString().trim();
    }
}