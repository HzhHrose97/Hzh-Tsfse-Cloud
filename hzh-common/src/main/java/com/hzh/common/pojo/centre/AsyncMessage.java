package com.hzh.common.pojo.centre;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hzh
 * @since 2023-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("async_message")
@ApiModel(value="AsyncMessage对象", description="")
public class AsyncMessage implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "消息唯一标识，自增的整数类型")
        @TableId(value = "message_id", type = IdType.AUTO)
      private Integer messageId;

      @ApiModelProperty(value = "消息主题，用于标识消息的类型或分类")
      private String topic;

      @ApiModelProperty(value = "消息内容，使用 TEXT 类型存储")
      private String messageBody;

      @ApiModelProperty(value = "消息创建时间，默认为当前时间戳")
      private LocalDateTime createdAt;

      @ApiModelProperty(value = "消息状态，用数字表示状态，例如：0-等待发送，1-已发送，2-发送失败等")
      private Integer status;

      @ApiModelProperty(value = "是否被消费，0-未消费，1-已消费")
      private Integer consumed;

      @ApiModelProperty(value = "消息生产者，用于标识消息的产生者")
      private String producer;

      @ApiModelProperty(value = "发布者ID，用于标识消息的发布者")
      private Integer publisherId;

      @ApiModelProperty(value = "备注字段，用于添加额外的注释或说明")
      private String remark;


}
