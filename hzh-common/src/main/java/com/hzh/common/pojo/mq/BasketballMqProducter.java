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
    @TableName("basketball_mq_producter")
@ApiModel(value="BasketballMqProducter对象", description="")
public class BasketballMqProducter implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty(value = "主键")
        private String id;

      @ApiModelProperty(value = "生产者组名")
      private String groupName;

      @ApiModelProperty(value = "消息主题")
      private String msgTopic;

      @ApiModelProperty(value = "Tag")
      private String msgTag;

      @ApiModelProperty(value = "Key")
      private String msgKey;

      @ApiModelProperty(value = "消息内容")
      private String msgBody;

      @ApiModelProperty(value = "0:未处理;1:已经处理")
      private Integer msgStatus;

      @ApiModelProperty(value = "记录时间")
      private LocalDateTime createTime;


}
