package com.hzh.common.respone;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 统一结果返回类
 *
 * 数据有：
 *      - 是否成功：success[true/false] 类型 boolean
 *      - 状态码： code[20000/40000]  类型int
 *      - 消息： msg对code进行说明，比如说： 操作成功；操作失败；登录成功... 类型 Strin
 *      - 返回的数据： data 类型Object
 *
 * @author Hou Zhonghu
 * @since 2022/8/11 14:25
 */
@Data
@Component
public class MyResult {

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_FAILED = 400;
    public static final int CODE_NOT_LOGIN = 403;

    //是否成功
    private boolean success;
    //状态码
    private int code;
    //描述
    private String msg;
    //数据
    private Object data;


    //提供一些静态的方法，可以快速的创建返回对象
    public static MyResult SUCCESS(String msg){
        MyResult r = new MyResult();
        r.code = CODE_SUCCESS;
        r.msg = msg;
        r.success = true;
        return r;
    }

    public static MyResult SUCCESS(String msg, Object data){
        MyResult success = SUCCESS(msg);
        success.data = data;
        return success;
    }

    public static MyResult NOT_LOGIN(){
        MyResult filed = FAILED("账号未登录");
        filed.code = CODE_NOT_LOGIN;
        return filed;
    }

    public static MyResult FAILED(String msg){
        MyResult r = new MyResult();
        r.code = CODE_FAILED;
        r.msg = msg;
        r.success = false;
        return r;
    }


    public static MyResult FAILED(String msg, Object data){
        MyResult success = SUCCESS(msg);
        success.data = data;
        return success;
    }

}
