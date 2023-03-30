package com.hzh.common.pojo.event;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 体育赛事举办信息表
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
@TableName("football_event_info")
@ApiModel(value="FootballEventInfo对象", description="体育赛事举办信息表")
public class FootballEventInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "体育类型ID")
  @TableId(value = "physical_id", type = IdType.ID_WORKER_STR)
  private Integer physicalId;

  @ApiModelProperty(value = "体育类型名称")
  private String physicalName;

  @ApiModelProperty(value = "举办国")
  private String heldCountry;

  @ApiModelProperty(value = "举办地")
  private String heldLocation;

  @ApiModelProperty(value = "举办主场方")
  private String heldHome;

  @ApiModelProperty(value = "场地最大容纳人数")
  private String maximumCapacity;

  @ApiModelProperty(value = "客场方")
  private String awayGround;

  @ApiModelProperty(value = "举办主场方logo URL")
  private String physicalHeldLogo;

  @ApiModelProperty(value = "体育描述")
  private String physicalDesc;

  @ApiModelProperty(value = "体育状态,0禁用,1启用")
  private Integer physicalStatus;

  @ApiModelProperty(value = "开赛时间")
  private String matchTime;

  @ApiModelProperty(value = "举办场馆")
  private String heldVenues;


}
