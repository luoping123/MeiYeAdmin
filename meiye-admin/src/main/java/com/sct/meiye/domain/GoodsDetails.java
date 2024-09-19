package com.sct.meiye.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品详情对象 goods_details
 * 
 * @author sct
 * @date 2022-05-18
 */
public class GoodsDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long goodsId;

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
    public void setGoodsId(Long goodsId) 
    {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() 
    {
        return goodsId;
    }
    public void setSwiperUrl(String swiperUrl) 
    {
        this.swiperUrl = swiperUrl;
    }

    public String getSwiperUrl() 
    {
        return swiperUrl;
    }
    public void setSwiperType(String swiperType) 
    {
        this.swiperType = swiperType;
    }

    public String getSwiperType() 
    {
        return swiperType;
    }
    public void setPriceType(Integer priceType) 
    {
        this.priceType = priceType;
    }

    public Integer getPriceType() 
    {
        return priceType;
    }
    public void setFreight(Long freight) 
    {
        this.freight = freight;
    }

    public Long getFreight() 
    {
        return freight;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goodsId", getGoodsId())
            .append("swiperUrl", getSwiperUrl())
            .append("swiperType", getSwiperType())
            .append("priceType", getPriceType())
            .append("freight", getFreight())
            .append("content", getContent())
            .toString();
    }
}
