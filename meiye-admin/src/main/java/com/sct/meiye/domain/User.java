package com.sct.meiye.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户对象 user
 * 
 * @author sct
 * @date 2022-05-18
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 微信登录openId */
    @Excel(name = "微信登录openId")
    private String openId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 用户类型 */
    private Integer type;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 用户头像url */
    @Excel(name = "用户头像url")
    private String avatarUrl;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 账号 */
    private String username;

    /** 密码 */
    private String password;

    /** 会员卡id */
    @Excel(name = "会员卡id")
    private Long vipId;

    /** 余额 */
    @Excel(name = "余额")
    private BigDecimal balance;

    /** 积分 */
    @Excel(name = "积分")
    private Long integral;

    /** 优惠券id;优惠券id; */
    private String couponId;

    /** 最后登录时间 */
    private Date lastLoginTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setAvatarUrl(String avatarUrl) 
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() 
    {
        return avatarUrl;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setVipId(Long vipId) 
    {
        this.vipId = vipId;
    }

    public Long getVipId() 
    {
        return vipId;
    }
    public void setBalance(BigDecimal balance) 
    {
        this.balance = balance;
    }

    public BigDecimal getBalance() 
    {
        return balance;
    }
    public void setIntegral(Long integral) 
    {
        this.integral = integral;
    }

    public Long getIntegral() 
    {
        return integral;
    }
    public void setCouponId(String couponId) 
    {
        this.couponId = couponId;
    }

    public String getCouponId() 
    {
        return couponId;
    }
    public void setLastLoginTime(Date lastLoginTime) 
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastLoginTime() 
    {
        return lastLoginTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("openId", getOpenId())
            .append("name", getName())
            .append("gender", getGender())
            .append("age", getAge())
            .append("type", getType())
            .append("address", getAddress())
            .append("avatarUrl", getAvatarUrl())
            .append("phone", getPhone())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("vipId", getVipId())
            .append("balance", getBalance())
            .append("integral", getIntegral())
            .append("couponId", getCouponId())
            .append("createTime", getCreateTime())
            .append("lastLoginTime", getLastLoginTime())
            .append("remark", getRemark())
            .toString();
    }
}
