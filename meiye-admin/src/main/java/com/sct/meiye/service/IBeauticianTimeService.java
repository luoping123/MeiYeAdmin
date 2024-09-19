package com.sct.meiye.service;

import java.util.List;
import com.sct.meiye.domain.BeauticianTime;

/**
 * 美容师时间Service接口
 * 
 * @author sct
 * @date 2022-05-20
 */
public interface IBeauticianTimeService 
{
    /**
     * 查询美容师时间
     *
     * @param timeId 美容师时间主键
     * @return 美容师时间
     */
    public BeauticianTime selectBeauticianTimeById(Long timeId);

    /**
     * 查询美容师时间列表
     *
     * @param beauticianTime 美容师时间
     * @return 美容师时间集合
     */
    public List<BeauticianTime> selectBeauticianTimeList(BeauticianTime beauticianTime);

    /**
     * 新增美容师时间
     * 
     * @param beauticianTime 美容师时间
     * @return 结果
     */
    public int insertBeauticianTime(BeauticianTime beauticianTime);

    /**
     * 修改美容师时间
     * 
     * @param beauticianTime 美容师时间
     * @return 结果
     */
    public int updateBeauticianTime(BeauticianTime beauticianTime);

    /**
     * 批量删除美容师时间
     * 
     * @param timeIds 需要删除的美容师时间主键集合
     * @return 结果
     */
    public int deleteBeauticianTimeByIds(Long[] timeIds);

    /**
     * 删除美容师时间信息
     * 
     * @param timeId 美容师时间主键
     * @return 结果
     */
    public int deleteBeauticianTimeById(Long timeId);
}
