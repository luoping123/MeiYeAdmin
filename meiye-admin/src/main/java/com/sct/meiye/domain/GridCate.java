package com.sct.meiye.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 九宫格导航对象 grid_cate
 * 
 * @author sct
 * @date 2022-05-18
 */
public class GridCate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 图标地址 */
    @Excel(name = "图标地址")
    private String icon;

    /** 宫格名字 */
    @Excel(name = "宫格名字")
    private String name;

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
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
            .append("icon", getIcon())
            .append("name", getName())
            .append("openType", getOpenType())
            .append("navigatorUrl", getNavigatorUrl())
            .toString();
    }
}
