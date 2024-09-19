package com.sct.meiye.domain;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品订单对象 goods_order
 * 
 * @author sct
 * @date 2022-05-18
 */
public class GoodsOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String goodsOrderId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 微信用户id */
    @Excel(name = "微信用户id")
    private String openId;

    /** 客户微信昵称  */
    @Excel(name = "客户微信昵称")
    private String  uName;

    /** 商品id;商品id; */
    @Excel(name = "商品id;商品id;")
    private String goodsIdList;

    /** 商品列表  */
    @Excel(name = "商品列表")
    private List<Goods>  goodsList;

    /** 订单总积分 */
    @Excel(name = "订单总积分")
    private Long intergralSum;

    /** 订单总金额 */
    @Excel(name = "订单总金额")
    private BigDecimal priceSum;

    /** 实际金额 */
    @Excel(name = "实际金额")
    private BigDecimal realPrice;

    /** 优惠券减少金额 */
    @Excel(name = "优惠券减少金额")
    private String useCoupon;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStatus;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payType;

    /** 付款时间 */
    @Excel(name = "付款时间")
    private String payTime;

    /** 付款截止时间，到这个时间后未付款，订单失效，用于倒计时 */
    @Excel(name = "付款截止时间，到这个时间后未付款，订单失效，用于倒计时")
    private String payDeadline;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDeleted;

    /** 是否超时未支付 */
    @Excel(name = "是否超时未支付")
    private Long isOutTime;

    /** 收件人姓名 */
    @Excel(name = "收件人姓名")
    private String receiverName;

    /** 收件人地址 */
    @Excel(name = "收件人地址")
    private String receiverAddress;

    /** 收件人电话 */
    @Excel(name = "收件人电话")
    private String receiverPhone;

    /** 快递单号 */
    @Excel(name = "快递单号")
    private String postalNumber;



    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodsOrderId(String goodsOrderId) 
    {
        this.goodsOrderId = goodsOrderId;
    }

    public String getGoodsOrderId() 
    {
        return goodsOrderId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setGoodsIdList(String goodsIdList) 
    {
        this.goodsIdList = goodsIdList;
    }

    public String getGoodsIdList() 
    {
        return goodsIdList;
    }
    public void setIntergralSum(Long intergralSum) 
    {
        this.intergralSum = intergralSum;
    }

    public Long getIntergralSum() 
    {
        return intergralSum;
    }
    public void setPriceSum(BigDecimal priceSum) 
    {
        this.priceSum = priceSum;
    }

    public BigDecimal getPriceSum() 
    {
        return priceSum;
    }
    public void setRealPrice(BigDecimal realPrice) 
    {
        this.realPrice = realPrice;
    }

    public BigDecimal getRealPrice() 
    {
        return realPrice;
    }
    public void setUseCoupon(String useCoupon) 
    {
        this.useCoupon = useCoupon;
    }

    public String getUseCoupon() 
    {
        return useCoupon;
    }
    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }
    public void setPayType(String payType) 
    {
        this.payType = payType;
    }

    public String getPayType() 
    {
        return payType;
    }
    public void setPayTime(String payTime) 
    {
        this.payTime = payTime;
    }

    public String getPayTime() 
    {
        return payTime;
    }
    public void setPayDeadline(String payDeadline) 
    {
        this.payDeadline = payDeadline;
    }

    public String getPayDeadline() 
    {
        return payDeadline;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }
    public void setIsOutTime(Long isOutTime) 
    {
        this.isOutTime = isOutTime;
    }

    public Long getIsOutTime() 
    {
        return isOutTime;
    }
    public void setReceiverName(String receiverName) 
    {
        this.receiverName = receiverName;
    }

    public String getReceiverName() 
    {
        return receiverName;
    }
    public void setReceiverAddress(String receiverAddress) 
    {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverAddress() 
    {
        return receiverAddress;
    }
    public void setReceiverPhone(String receiverPhone) 
    {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPhone() 
    {
        return receiverPhone;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPostalNumber() {
        return postalNumber;
    }

    public void setPostalNumber(String postalNumber) {
        this.postalNumber = postalNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsOrderId", getGoodsOrderId())
            .append("userId", getUserId())
            .append("openId", getOpenId())
            .append("goodsIdList", getGoodsIdList())
            .append("remark", getRemark())
            .append("intergralSum", getIntergralSum())
            .append("priceSum", getPriceSum())
            .append("realPrice", getRealPrice())
            .append("useCoupon", getUseCoupon())
            .append("orderStatus", getOrderStatus())
            .append("payType", getPayType())
            .append("payTime", getPayTime())
            .append("createTime", getCreateTime())
            .append("payDeadline", getPayDeadline())
            .append("isDeleted", getIsDeleted())
            .append("isOutTime", getIsOutTime())
            .append("receiverName", getReceiverName())
            .append("receiverAddress", getReceiverAddress())
            .append("receiverPhone", getReceiverPhone())
            .append("goodsList", getGoodsList())
            .append("uName", getuName())
            .append("postalNumber", getuName())
            .toString();
    }
}
