package com.hzh.common.pojo.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 角色表
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
@TableName("hzh_role")
@ApiModel(value="HzhRole对象", description="角色表")
public class HzhRole implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String name;

      @ApiModelProperty(value = "角色权限字符串")
      private String roleKey;

      @ApiModelProperty(value = "角色状态（0停用 1正常）")
      private String status;

      @ApiModelProperty(value = "del_flag")
      private Integer delFlag;


}
