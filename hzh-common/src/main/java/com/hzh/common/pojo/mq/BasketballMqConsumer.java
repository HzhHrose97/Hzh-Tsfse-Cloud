package com.hzh.common.pojo.mq;

import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableName("basketball_mq_consumer")
@ApiModel(value="BasketballMqConsumer对象", description="")
public class BasketballMqConsumer implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "消息ID")
        private String msgId;

      @ApiModelProperty(value = "消费者组名")
      private String groupName;

      @ApiModelProperty(value = "Tag")
      private String msgTag;

      @ApiModelProperty(value = "Key")
      private String msgKey;

      @ApiModelProperty(value = "消息体")
      private String msgBody;

      @ApiModelProperty(value = "0:正在处理;1:处理成功;2:处理失败")
      private Integer consumerStatus;

      @ApiModelProperty(value = "消费次数")
      private Integer consumerTimes;

      @ApiModelProperty(value = "消费时间")
      private LocalDateTime consumerTimestamp;

      @ApiModelProperty(value = "备注")
      private String remark;


}
