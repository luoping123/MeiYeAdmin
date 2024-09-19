package com.sct.meiye.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.BeauticianTimeMapper;
import com.sct.meiye.domain.BeauticianTime;
import com.sct.meiye.service.IBeauticianTimeService;

/**
 * 美容师时间Service业务层处理
 * 
 * @author sct
 * @date 2022-05-20
 */
@Service
public class BeauticianTimeServiceImpl implements IBeauticianTimeService 
{
    @Autowired
    private BeauticianTimeMapper beauticianTimeMapper;

    /**
     * 查询美容师时间
     * 
     * @param timeId 美容师时间主键
     * @return 美容师时间
     */
    @Override
    public BeauticianTime selectBeauticianTimeById(Long timeId)
    {
        return beauticianTimeMapper.selectBeauticianTimeById(timeId);
    }

    /**
     * 查询美容师时间列表
     * 
     * @param beauticianTime 美容师时间
     * @return 美容师时间
     */
    @Override
    public List<BeauticianTime> selectBeauticianTimeList(BeauticianTime beauticianTime)
    {
        return beauticianTimeMapper.selectBeauticianTimeList(beauticianTime);
    }

    /**
     * 新增美容师时间
     * 
     * @param beauticianTime 美容师时间
     * @return 结果
     */
    @Override
    public int insertBeauticianTime(BeauticianTime beauticianTime)
    {
        return beauticianTimeMapper.insertBeauticianTime(beauticianTime);
    }

    /**
     * 修改美容师时间
     * 
     * @param beauticianTime 美容师时间
     * @return 结果
     */
    @Override
    public int updateBeauticianTime(BeauticianTime beauticianTime)
    {
        return beauticianTimeMapper.updateBeauticianTime(beauticianTime);
    }

    /**
     * 批量删除美容师时间
     * 
     * @param timeIds 需要删除的美容师时间主键
     * @return 结果
     */
    @Override
    public int deleteBeauticianTimeByIds(Long[] timeIds)
    {
        return beauticianTimeMapper.deleteBeauticianTimeByIds(timeIds);
    }

    /**
     * 删除美容师时间信息
     * 
     * @param timeId 美容师时间主键
     * @return 结果
     */
    @Override
    public int deleteBeauticianTimeById(Long timeId)
    {
        return beauticianTimeMapper.deleteBeauticianTimeById(timeId);
    }
}
