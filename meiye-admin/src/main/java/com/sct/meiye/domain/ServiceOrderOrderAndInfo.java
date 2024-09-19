package com.sct.meiye.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 服务项目订单对象 service_order_order
 * 
 * @author sct
 * @date 2022-05-18
 */
public class ServiceOrderOrderAndInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键订单号 */
    private String orderId;

    /** 二维码号码 */
    @Excel(name = "二维码号码")
    private String qrcodeNumber;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 服务项目id */
    @Excel(name = "服务项目id")
    private Long serviceItemId;

    /** 服务项目名称  */
    @Excel(name = "服务项目名称")
    private String  sName;

    /** 日期id */
    private Long dateId;

    /** 时间id */
    private Long timeId;

    /** 美容师id */
    @Excel(name = "美容师id")
    private Long beauticianId;

    /** 美容师姓名  */
    @Excel(name = "美容师姓名")
    private String  bName;

    /** 其他用户id */
    private Long uid;

    /** 微信用户id */
    @Excel(name = "微信用户id")
    private String openId;

    /** 客户微信昵称  */
    @Excel(name = "客户微信昵称")
    private String  uName;

    /** 到期时间 */
    @Excel(name = "到期时间")
    private String endDate;

    /** 服务方式 */
    @Excel(name = "服务方式")
    private String serviceType;

    /** 预约时间(只用于显示) */
    @Excel(name = "预约时间(只用于显示)")
    private String orderTime;

    /** 预约时间（存储） */
    private String serviceOrderDatetime;

    /** 订单总价 */
    @Excel(name = "订单总价")
    private BigDecimal sumPrice;

    /** 实付款 */
    @Excel(name = "实付款")
    private BigDecimal realPay;

    /** 付款方式 */
    @Excel(name = "付款方式")
    private String payType;

    /** 付款时间 */
    @Excel(name = "付款时间")
    private String payTime;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String orderStatus;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isDeleted;

    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setQrcodeNumber(String qrcodeNumber) 
    {
        this.qrcodeNumber = qrcodeNumber;
    }

    public String getQrcodeNumber() 
    {
        return qrcodeNumber;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setServiceItemId(Long serviceItemId) 
    {
        this.serviceItemId = serviceItemId;
    }

    public Long getServiceItemId() 
    {
        return serviceItemId;
    }
    public void setDateId(Long dateId) 
    {
        this.dateId = dateId;
    }

    public Long getDateId() 
    {
        return dateId;
    }
    public void setTimeId(Long timeId) 
    {
        this.timeId = timeId;
    }

    public Long getTimeId() 
    {
        return timeId;
    }
    public void setBeauticianId(Long beauticianId) 
    {
        this.beauticianId = beauticianId;
    }

    public Long getBeauticianId() 
    {
        return beauticianId;
    }
    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setEndDate(String endDate) 
    {
        this.endDate = endDate;
    }

    public String getEndDate() 
    {
        return endDate;
    }
    public void setServiceType(String serviceType) 
    {
        this.serviceType = serviceType;
    }

    public String getServiceType() 
    {
        return serviceType;
    }
    public void setOrderTime(String orderTime) 
    {
        this.orderTime = orderTime;
    }

    public String getOrderTime() 
    {
        return orderTime;
    }
    public void setServiceOrderDatetime(String serviceOrderDatetime) 
    {
        this.serviceOrderDatetime = serviceOrderDatetime;
    }

    public String getServiceOrderDatetime() 
    {
        return serviceOrderDatetime;
    }
    public void setSumPrice(BigDecimal sumPrice) 
    {
        this.sumPrice = sumPrice;
    }

    public BigDecimal getSumPrice() 
    {
        return sumPrice;
    }
    public void setRealPay(BigDecimal realPay) 
    {
        this.realPay = realPay;
    }

    public BigDecimal getRealPay() 
    {
        return realPay;
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
    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }
    public void setIsDeleted(Long isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Long getIsDeleted() 
    {
        return isDeleted;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("qrcodeNumber", getQrcodeNumber())
            .append("remarks", getRemarks())
            .append("createTime", getCreateTime())
            .append("serviceItemId", getServiceItemId())
            .append("dateId", getDateId())
            .append("timeId", getTimeId())
            .append("beauticianId", getBeauticianId())
            .append("uid", getUid())
            .append("openId", getOpenId())
            .append("endDate", getEndDate())
            .append("serviceType", getServiceType())
            .append("orderTime", getOrderTime())
            .append("serviceOrderDatetime", getServiceOrderDatetime())
            .append("sumPrice", getSumPrice())
            .append("realPay", getRealPay())
            .append("payType", getPayType())
            .append("payTime", getPayTime())
            .append("orderStatus", getOrderStatus())
            .append("isDeleted", getIsDeleted())
                .append("sName", getsName())
                .append("bName", getbName())
                .append("uName", getuName())
            .toString();
    }
}
