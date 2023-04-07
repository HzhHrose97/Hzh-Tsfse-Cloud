package com.hzh.common.pojo.team;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 球员表
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
@TableName("football_palyer_info")
@ApiModel(value="FootballPalyerInfo对象", description="足球球员表")
public class FootballPalyerInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "主键")
  @TableId(value = "palyer_id", type = IdType.AUTO)
  private Long palyerId;

  @ApiModelProperty(value = "球员所属球队id")
  private Long teamId;

  @ApiModelProperty(value = "球员名称")
  private String palyerName;

  @ApiModelProperty(value = "球员年龄")
  private String playerAge;

  @ApiModelProperty(value = "球员性别")
  private String playerSex;

  @ApiModelProperty(value = "球员身高")
  private String palyerHeight;

  @ApiModelProperty(value = "球员体重")
  private String playerWeight;

  @ApiModelProperty(value = "球员队服号码")
  private String playerNum;

  @ApiModelProperty(value = "球员国籍")
  private String playerNationality;

  @ApiModelProperty(value = "球员位置")
  private String playerLocation;


}
