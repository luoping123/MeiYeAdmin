package com.sct.meiye.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 goods
 * 
 * @author sct
 * @date 2022-05-18
 */
public class Goods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 商品分类id */
    @Excel(name = "商品分类id")
    private Long goodsCateId;

    /** 商品名 */
    @Excel(name = "商品名")
    private String name;

    /** 图片 */
    @Excel(name = "图片")
    private String imageSrc;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 原价 */
    @Excel(name = "原价")
    private BigDecimal olderPrice;

    /** 购买获得积分 */
    private Long intergralValue;

    /** 库存 */
    private Long storeNumber;

    /** 热度 */
    private Long hotNumber;

    /** 商品规格——颜色, 颜色1;颜色2; */
    private String goodsColor;

    /** 商品规格——尺码, 尺码1;尺码2; */
    private String goodsSize;

    /** 商品规格——数量 */
    private Long goodsNum;

    /** 是否为秒杀，0否，1是，自动转换为false或true */
    @Excel(name = "是否为秒杀，0否，1是，自动转换为false或true")
    private Integer isLimitKill;

    /** 商品分类名称 */
    @Excel(name = "商品分类名称")
    private String cateName;

    /** 详情id */
    @Excel(name = "详情id")
    private Long detailId;

    /** 轮播图图片或视频地址，‘;’分割 */
    @Excel(name = "轮播图图片或视频地址，‘;’分割")
    private String swiperUrl;

    /** 轮播图对应的类型（image、video）‘;’分割 */
    @Excel(name = "轮播图对应的类型", readConverterExp = "i=mage、video")
    private String swiperType;

    /** 商品价格栏目 类型，0：原价栏目，1：限时抢购栏目 */
    private Integer priceType;

    /** 运费 */
    private Long freight;

    /** 详情富文本 */
    @Excel(name = "详情富文本")
    private String content;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGoodsCateId(Long goodsCateId) 
    {
        this.goodsCateId = goodsCateId;
    }

    public Long getGoodsCateId() 
    {
        return goodsCateId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImageSrc(String imageSrc) 
    {
        this.imageSrc = imageSrc;
    }

    public String getImageSrc() 
    {
        return imageSrc;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setOlderPrice(BigDecimal olderPrice) 
    {
        this.olderPrice = olderPrice;
    }

    public BigDecimal getOlderPrice() 
    {
        return olderPrice;
    }
    public void setIntergralValue(Long intergralValue) 
    {
        this.intergralValue = intergralValue;
    }

    public Long getIntergralValue() 
    {
        return intergralValue;
    }
    public void setStoreNumber(Long storeNumber) 
    {
        this.storeNumber = storeNumber;
    }

    public Long getStoreNumber() 
    {
        return storeNumber;
    }
    public void setHotNumber(Long hotNumber) 
    {
        this.hotNumber = hotNumber;
    }

    public Long getHotNumber() 
    {
        return hotNumber;
    }
    public void setGoodsColor(String goodsColor) 
    {
        this.goodsColor = goodsColor;
    }

    public String getGoodsColor() 
    {
        return goodsColor;
    }
    public void setGoodsSize(String goodsSize) 
    {
        this.goodsSize = goodsSize;
    }

    public String getGoodsSize() 
    {
        return goodsSize;
    }
    public void setGoodsNum(Long goodsNum) 
    {
        this.goodsNum = goodsNum;
    }

    public Long getGoodsNum() 
    {
        return goodsNum;
    }
    public void setIsLimitKill(Integer isLimitKill) 
    {
        this.isLimitKill = isLimitKill;
    }

    public Integer getIsLimitKill() 
    {
        return isLimitKill;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getSwiperUrl() {
        return swiperUrl;
    }

    public void setSwiperUrl(String swiperUrl) {
        this.swiperUrl = swiperUrl;
    }

    public String getSwiperType() {
        return swiperType;
    }

    public void setSwiperType(String swiperType) {
        this.swiperType = swiperType;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public Long getFreight() {
        return freight;
    }

    public void setFreight(Long freight) {
        this.freight = freight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsCateId", getGoodsCateId())
            .append("name", getName())
            .append("imageSrc", getImageSrc())
            .append("price", getPrice())
            .append("olderPrice", getOlderPrice())
            .append("intergralValue", getIntergralValue())
            .append("storeNumber", getStoreNumber())
            .append("hotNumber", getHotNumber())
            .append("goodsColor", getGoodsColor())
            .append("goodsSize", getGoodsSize())
            .append("goodsNum", getGoodsNum())
            .append("isLimitKill", getIsLimitKill())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
                .append("cateName", getCateName())
                .append("detailId", getDetailId())
                .append("swiperUrl", getSwiperUrl())
                .append("swiperType", getSwiperType())
                .append("priceType", getPriceType())
                .append("freight", getFreight())
                .append("content", getContent())
            .toString();
    }
}
