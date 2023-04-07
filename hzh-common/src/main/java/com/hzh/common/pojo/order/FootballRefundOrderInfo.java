package com.hzh.common.pojo.order;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>
 * 退款信息
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
@TableName("football_refund_order_info")
@ApiModel(value="FootballRefundOrderInfo对象", description="足球订单退款信息")
public class FootballRefundOrderInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id")
  @TableId(value = "refund_id", type = IdType.AUTO)
  private Long refundId;

  @ApiModelProperty(value = "退款的订单")
  private Long orderReturnId;

  @ApiModelProperty(value = "退款金额")
  private BigDecimal refund;

  @ApiModelProperty(value = "退款交易流水号")
  private String refundSn;

  @ApiModelProperty(value = "退款状态")
  private Boolean refundStatus;

  @ApiModelProperty(value = "退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
  private Integer refundChannel;

  private String refundContent;


}
