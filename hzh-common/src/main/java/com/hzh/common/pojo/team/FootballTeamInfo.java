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
 * 球队信息表
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
@TableName("football_team_info")
@ApiModel(value="FootballTeamInfo对象", description="足球球队信息表")
public class FootballTeamInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "主键")
  @TableId(value = "team_id", type = IdType.AUTO)
  private Long teamId;

  @ApiModelProperty(value = "球队名")
  private String teamName;

  @ApiModelProperty(value = "球队所属国家")
  private String teamCountry;

  @ApiModelProperty(value = "球队成立日期")
  private String teamDate;

  @ApiModelProperty(value = "球队logo")
  private String teamLogo;

  @ApiModelProperty(value = "球队所在地")
  private String teamLocal;

  @ApiModelProperty(value = "球队主场")
  private String teamHome;

  @ApiModelProperty(value = "球队所属联赛")
  private String teamLeague;

  @ApiModelProperty(value = "联赛冠军次数")
  private String teamOverallChampion;

  @ApiModelProperty(value = "欧洲冠军联赛冠军")
  private String teamPartitionChampion;

  @ApiModelProperty(value = "英格兰足总杯冠军")
  private String teamPlayoffs;

  @ApiModelProperty(value = "球队管理员")
  private String teamAdministrator;

  @ApiModelProperty(value = "球队主教练")
  private String teamCoach;


}
