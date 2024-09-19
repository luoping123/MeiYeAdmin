package com.sct.meiye.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 美容师对象 beautician
 * 
 * @author sct
 * @date 2022-05-18
 */
public class Beautician extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 美容师姓名 */
    @Excel(name = "美容师姓名")
    private String name;

    /** 美容师性别 */
    @Excel(name = "美容师性别")
    private String sex;

    /** 美容师年龄 */
    @Excel(name = "美容师年龄")
    private Long age;

    /** 美容师家庭地址 */
    @Excel(name = "美容师家庭地址")
    private String address;

    /** 美容师电话 */
    @Excel(name = "美容师电话")
    private String tel;

    /** 美容师照片 */
    @Excel(name = "美容师照片")
    private String img;

    /** 评分总星级 */
    private BigDecimal starSum;

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
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setStarSum(BigDecimal starSum) 
    {
        this.starSum = starSum;
    }

    public BigDecimal getStarSum() 
    {
        return starSum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("address", getAddress())
            .append("tel", getTel())
            .append("img", getImg())
            .append("starSum", getStarSum())
            .toString();
    }
}
