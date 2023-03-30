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
 * 支付信息表
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
@TableName("basketball_payment_info")
@ApiModel(value="BasketballPaymentInfo对象", description="篮球订单支付信息表")
public class BasketballPaymentInfo implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "id")
  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  @ApiModelProperty(value = "订单号（对外业务号）")
  private String orderSn;

  @ApiModelProperty(value = "订单id")
  private Long orderId;

  @ApiModelProperty(value = "支付宝交易流水号")
  private String alipayTradeNo;

  @ApiModelProperty(value = "支付总金额")
  private BigDecimal totalAmount;

  @ApiModelProperty(value = "交易内容")
  private String subject;

  @ApiModelProperty(value = "支付状态； 1支付成功")
  private String paymentStatus;

  @ApiModelProperty(value = "创建时间")
  private String createTime;

  @ApiModelProperty(value = "确认时间")
  private String confirmTime;

  @ApiModelProperty(value = "回调内容")
  private String callbackContent;

  @ApiModelProperty(value = "回调时间")
  private String callbackTime;


}
