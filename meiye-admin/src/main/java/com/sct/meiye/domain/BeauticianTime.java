package com.sct.meiye.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 美容师时间对象 beautician_time
 * 
 * @author sct
 * @date 2022-05-20
 */
public class BeauticianTime extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long timeId;

    /** 美容师id */
    @Excel(name = "美容师id")
    private Long beauticianId;

    /** 可预约时间 */
    @Excel(name = "可预约时间")
    private String beauticianTime;

    /** 当前美容师当前时间可预约数量 */
    @Excel(name = "当前美容师当前时间可预约数量")
    private Long number;



    public Long getBeauticianId() 
    {
        return beauticianId;
    }
    public void setBeauticianTime(String beauticianTime) 
    {
        this.beauticianTime = beauticianTime;
    }

    public String getBeauticianTime() 
    {
        return beauticianTime;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }

    public Long getTimeId() {
        return timeId;
    }

    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    public void setBeauticianId(Long beauticianId) {
        this.beauticianId = beauticianId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("timeId", getTimeId())
            .append("beauticianId", getBeauticianId())
            .append("beauticianTime", getBeauticianTime())
            .append("number", getNumber())
            .toString();
    }
}
