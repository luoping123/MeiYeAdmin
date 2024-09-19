package com.sct.meiye.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 服务项目分类对象 service_item_cate
 * 
 * @author sct
 * @date 2022-05-18
 */
public class ServiceItemCate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 分类名 */
    @Excel(name = "分类名")
    private String cateName;

    /** 是否不启用，0启用，1不启用 */
    private Integer disabled;

    /** 是否热卖（小红点）,0否，1是 */
    private Integer isHot;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCateName(String cateName) 
    {
        this.cateName = cateName;
    }

    public String getCateName() 
    {
        return cateName;
    }
    public void setDisabled(Integer disabled) 
    {
        this.disabled = disabled;
    }

    public Integer getDisabled() 
    {
        return disabled;
    }
    public void setIsHot(Integer isHot) 
    {
        this.isHot = isHot;
    }

    public Integer getIsHot() 
    {
        return isHot;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cateName", getCateName())
            .append("disabled", getDisabled())
            .append("isHot", getIsHot())
            .toString();
    }
}
