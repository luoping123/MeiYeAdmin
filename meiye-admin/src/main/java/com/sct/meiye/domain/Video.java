package com.sct.meiye.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频对象 video
 * 
 * @author sct
 * @date 2022-05-17
 */
public class Video extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 每个视频独有id，必须为字符串类型 */
    @Excel(name = "每个视频独有id，必须为字符串类型")
    private String videoId;

    /** 视频拥有者名称 */
    @Excel(name = "视频拥有者名称")
    private String username;

    /** 头像地址 */
    @Excel(name = "头像地址")
    private String href;

    /** 第一行标题 */
    @Excel(name = "第一行标题")
    private String title;

    /** 第二行内容 */
    @Excel(name = "第二行内容")
    private String msg;

    /** 初始状态标志（不改） */
    private String state;

    /** 是否是自己喜欢，0不喜欢，1喜欢。默认不喜欢(添加属性映射为like) */
    private Integer isLike;

    /** 喜欢数量 */
    private Long likeN;

    /** 评论数 */
    private Long smsN;

    /** 视频链接 */
    @Excel(name = "视频链接")
    private String src;

    /** 播放视频的数量 */
    private Long playnumber;

    /** 评论 */
    private String pinlun;

    /** 播放（默认这个即可） */
    private Integer playing;

    /** 是否显示封面（默认这个即可） */
    private Integer isshowimage;

    /** 是否显示进度条（默认这个即可） */
    private Integer isshowprogressbartime;

    /** 是否播放音频（默认这个即可） */
    private Integer isplay;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVideoId(String videoId) 
    {
        this.videoId = videoId;
    }

    public String getVideoId() 
    {
        return videoId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setHref(String href) 
    {
        this.href = href;
    }

    public String getHref() 
    {
        return href;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setMsg(String msg) 
    {
        this.msg = msg;
    }

    public String getMsg() 
    {
        return msg;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setIsLike(Integer isLike) 
    {
        this.isLike = isLike;
    }

    public Integer getIsLike() 
    {
        return isLike;
    }
    public void setLikeN(Long likeN) 
    {
        this.likeN = likeN;
    }

    public Long getLikeN() 
    {
        return likeN;
    }
    public void setSmsN(Long smsN) 
    {
        this.smsN = smsN;
    }

    public Long getSmsN() 
    {
        return smsN;
    }
    public void setSrc(String src) 
    {
        this.src = src;
    }

    public String getSrc() 
    {
        return src;
    }
    public void setPlaynumber(Long playnumber) 
    {
        this.playnumber = playnumber;
    }

    public Long getPlaynumber() 
    {
        return playnumber;
    }
    public void setPinlun(String pinlun) 
    {
        this.pinlun = pinlun;
    }

    public String getPinlun() 
    {
        return pinlun;
    }
    public void setPlaying(Integer playing) 
    {
        this.playing = playing;
    }

    public Integer getPlaying() 
    {
        return playing;
    }
    public void setIsshowimage(Integer isshowimage) 
    {
        this.isshowimage = isshowimage;
    }

    public Integer getIsshowimage() 
    {
        return isshowimage;
    }
    public void setIsshowprogressbartime(Integer isshowprogressbartime) 
    {
        this.isshowprogressbartime = isshowprogressbartime;
    }

    public Integer getIsshowprogressbartime() 
    {
        return isshowprogressbartime;
    }
    public void setIsplay(Integer isplay) 
    {
        this.isplay = isplay;
    }

    public Integer getIsplay() 
    {
        return isplay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("videoId", getVideoId())
            .append("username", getUsername())
            .append("href", getHref())
            .append("title", getTitle())
            .append("msg", getMsg())
            .append("state", getState())
            .append("isLike", getIsLike())
            .append("likeN", getLikeN())
            .append("smsN", getSmsN())
            .append("src", getSrc())
            .append("playnumber", getPlaynumber())
            .append("pinlun", getPinlun())
            .append("playing", getPlaying())
            .append("isshowimage", getIsshowimage())
            .append("isshowprogressbartime", getIsshowprogressbartime())
            .append("isplay", getIsplay())
            .toString();
    }
}
