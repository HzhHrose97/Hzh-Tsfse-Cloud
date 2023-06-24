package com.hzh.common.pojo.dto;

import com.hzh.common.pojo.user.HzhUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 用户注册请求类
 * @Author: FXS) Hzh
 * @Date: 2023/4/25 11:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO extends HzhUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "验证码" ,required = true)
    public  String mailCode;

}
