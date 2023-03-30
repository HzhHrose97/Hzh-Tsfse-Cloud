package com.hzh.common.pojo.user;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 *
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("hzh_user_token")
@ApiModel(value="HzhUserToken对象", description="用户登录信息表")
public class HzhUserToken implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "ID")
  private String id;

  @ApiModelProperty(value = "用户ID")
  private String userId;

  @ApiModelProperty(value = "token的")
  private String tokenKey;

  @ApiModelProperty(value = "刷新token")
  private String refreshToken;

  @ApiModelProperty(value = "登录来源")
  private String loginFrom;

  @ApiModelProperty(value = "应用ID")
  private String appId;

  @ApiModelProperty(value = "创建时间")
  private String createTime;

  @ApiModelProperty(value = "更新时间")
  private String updateTime;


}
