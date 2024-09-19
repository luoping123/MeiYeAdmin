package com.sct.meiye.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 轮播图对象 swiper
 * 
 * @author sct
 * @date 2022-05-17
 */
public class Swiper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String imageSrc;

    /** 跳转类型 */
    @Excel(name = "跳转类型")
    private String openType;

    /** 链接地址 */
    @Excel(name = "链接地址")
    private String navigatorUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setImageSrc(String imageSrc) 
    {
        this.imageSrc = imageSrc;
    }

    public String getImageSrc() 
    {
        return imageSrc;
    }
    public void setOpenType(String openType) 
    {
        this.openType = openType;
    }

    public String getOpenType() 
    {
        return openType;
    }
    public void setNavigatorUrl(String navigatorUrl) 
    {
        this.navigatorUrl = navigatorUrl;
    }

    public String getNavigatorUrl() 
    {
        return navigatorUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imageSrc", getImageSrc())
            .append("openType", getOpenType())
            .append("navigatorUrl", getNavigatorUrl())
            .toString();
    }
}
