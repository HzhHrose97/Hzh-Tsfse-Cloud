package com.hzh.common.pojo.centre;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2023-08-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sync_message")
public class SyncMessage implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "消息ID")
      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty(value = "消息发布日期")
      private String publishDate;

      @ApiModelProperty(value = "消息类型")
      private String messageType;

      @ApiModelProperty(value = "发布者ID")
      private String publisherId;

      @ApiModelProperty(value = "消息生效起始时间")
      private String startTime;

      @ApiModelProperty(value = "消息生效结束时间")
      private String endTime;

      @ApiModelProperty(value = "备注")
      private String remarks;

  @ApiModelProperty(value = "消息体")
  private String messageBody ;

  @ApiModelProperty(value = "0 已消费， 1 未消费")
  private String status ;

}
