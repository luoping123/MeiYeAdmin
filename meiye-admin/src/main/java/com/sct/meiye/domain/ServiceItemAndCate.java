package com.sct.meiye.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 服务项目对象 service_item
 * 
 * @author sct
 * @date 2022-05-18
 */
public class ServiceItemAndCate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 服务名 */
    @Excel(name = "服务名")
    private String name;

    /** 二级服务名 */
    @Excel(name = "二级服务名")
    private String subName;

    /** 图片 */
    @Excel(name = "图片")
    private String imageSrc;

    /** 原价 */
    @Excel(name = "原价")
    private BigDecimal olderPrice;

    /** 现价 */
    @Excel(name = "现价")
    private BigDecimal nowPrice;

    /** 类别id */
    @Excel(name = "类别id")
    private Long cateId;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String cateName;

    /** 是否为秒杀，0否，1是，自动转换为false或true */
    @Excel(name = "是否为秒杀，0否，1是，自动转换为false或true")
    private Integer isLimitKill;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSubName(String subName) 
    {
        this.subName = subName;
    }

    public String getSubName() 
    {
        return subName;
    }
    public void setImageSrc(String imageSrc) 
    {
        this.imageSrc = imageSrc;
    }

    public String getImageSrc() 
    {
        return imageSrc;
    }
    public void setOlderPrice(BigDecimal olderPrice) 
    {
        this.olderPrice = olderPrice;
    }

    public BigDecimal getOlderPrice() 
    {
        return olderPrice;
    }
    public void setNowPrice(BigDecimal nowPrice) 
    {
        this.nowPrice = nowPrice;
    }

    public BigDecimal getNowPrice() 
    {
        return nowPrice;
    }
    public void setCateId(Long cateId) 
    {
        this.cateId = cateId;
    }

    public Long getCateId() 
    {
        return cateId;
    }
    public void setIsLimitKill(Integer isLimitKill) 
    {
        this.isLimitKill = isLimitKill;
    }

    public Integer getIsLimitKill() 
    {
        return isLimitKill;
    }

    public String getCateName() {return cateName; }

    public void setCateName(String cateName) {this.cateName = cateName; }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("subName", getSubName())
            .append("imageSrc", getImageSrc())
            .append("olderPrice", getOlderPrice())
            .append("nowPrice", getNowPrice())
            .append("cateId", getCateId())
            .append("cateName", getCateName())
            .append("isLimitKill", getIsLimitKill())
            .toString();
    }


}
