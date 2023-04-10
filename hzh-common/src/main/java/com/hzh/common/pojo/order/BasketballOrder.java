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
 * 订单
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
@TableName("basketball_order")
@ApiModel(value="BasketballOrder对象", description="篮球订单信息")
public class BasketballOrder implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "订单id")
  @TableId(value = "order_id", type = IdType.ID_WORKER_STR)
  private String orderId;

  @ApiModelProperty(value = "购票人id",required = true)
  private Long userId;

  @ApiModelProperty(value = "使用的优惠券")
  private Long couponId;

  @ApiModelProperty(value = "create_time")
  private String createTime;

  @ApiModelProperty(value = "用户名")
  private String memberUsername;

  @ApiModelProperty(value = "订单总额")
  private BigDecimal totalAmount;

  @ApiModelProperty(value = "应付总额")
  private BigDecimal payAmount;

  @ApiModelProperty(value = "促销优化金额（促销价、满减、阶梯价）")
  private BigDecimal promotionAmount;

  @ApiModelProperty(value = "积分抵扣金额")
  private BigDecimal integrationAmount;

  @ApiModelProperty(value = "优惠券抵扣金额")
  private BigDecimal couponAmount;

  @ApiModelProperty(value = "后台调整订单使用的折扣金额")
  private BigDecimal discountAmount;

  @ApiModelProperty(value = "支付方式【1->支付宝；2->微信；3->银联】")
  private String payType;

  @ApiModelProperty(value = "订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】")
  private String status;

  @ApiModelProperty(value = "可以获得的积分")
  private Integer integration;

  @ApiModelProperty(value = "发票类型[0->不开发票；1->电子发票；2->纸质发票]")
  private String billType;

  @ApiModelProperty(value = "发票抬头")
  private String billHeader;

  @ApiModelProperty(value = "发票内容")
  private String billContent;

  @ApiModelProperty(value = "收票人电话")
  private String billReceiverPhone;

  @ApiModelProperty(value = "收票人邮箱")
  private String billReceiverEmail;

  @ApiModelProperty(value = "订单备注")
  private String note;

  @ApiModelProperty(value = "下单时使用的积分")
  private Integer useIntegration;

  @ApiModelProperty(value = "支付时间")
  private String paymentTime;

  @ApiModelProperty(value = "逻辑删除")
  private String orderState;

  @ApiModelProperty(value = "订单数量")
  private String orderTotal;


}
