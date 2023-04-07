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
@TableName("basketball_coach_info")
@ApiModel(value="BasketballCoachInfo对象", description="篮球教练信息表")
public class BasketballCoachInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "教练团队编号")
  @TableId(value = "coach_team_id", type = IdType.AUTO)
  private Integer coachTeamId;

  @ApiModelProperty(value = "教练编号")
  private Integer coachId;

  @ApiModelProperty(value = "教练名称")
  private String coachName;

  @ApiModelProperty(value = "入队时间")
  private String coachTime;

  @ApiModelProperty(value = "教练身高")
  private Integer coachHeight;

  @ApiModelProperty(value = "执教胜场")
  private Integer coachWonNum;

  @ApiModelProperty(value = "执教总场次")
  private Integer coachTotal;

  @ApiModelProperty(value = "教练体重")
  private Integer coachWeight;

  @ApiModelProperty(value = "教练国籍")
  private Integer coachCountry;

  @ApiModelProperty(value = "教练年龄")
  private Integer coachAge;

  @ApiModelProperty(value = "队服号码")
  private Integer coachUniformNumber;

  @ApiModelProperty(value = "教练位置  1-主教练  2-助理教练  3-其他教练")
  private Integer coachLocation;

  @ApiModelProperty(value = "从业时长")
  private Integer coachPractitionersAge;


}
