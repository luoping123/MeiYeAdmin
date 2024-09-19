package com.sct.meiye.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 服务项目详情对象 service_item_details
 * 
 * @author sct
 * @date 2022-05-18
 */
public class ServiceItemDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 服务项目id */
    @Excel(name = "服务项目id")
    private Long serviceId;

    /** 轮播图图片或视频地址，‘;’分割 */
    @Excel(name = "轮播图图片或视频地址，‘;’分割")
    private String swiperUrl;

    /** 轮播图对应的类型（image、video）‘;’分割 */
    @Excel(name = "轮播图对应的类型", readConverterExp = "i=mage、video")
    private String swiperType;

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
    public void setServiceId(Long serviceId) 
    {
        this.serviceId = serviceId;
    }

    public Long getServiceId() 
    {
        return serviceId;
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
            .append("serviceId", getServiceId())
            .append("swiperUrl", getSwiperUrl())
            .append("swiperType", getSwiperType())
            .append("content", getContent())
            .toString();
    }
}
