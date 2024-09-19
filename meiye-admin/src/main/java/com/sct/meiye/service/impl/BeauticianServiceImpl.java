package com.sct.meiye.service.impl;

import java.util.List;

import com.sct.meiye.domain.BeauticianAndTimeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.BeauticianMapper;
import com.sct.meiye.domain.Beautician;
import com.sct.meiye.service.IBeauticianService;

/**
 * 美容师Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class BeauticianServiceImpl implements IBeauticianService 
{
    @Autowired
    private BeauticianMapper beauticianMapper;

    /**
     * 查询美容师
     *
     * @param id 美容师主键
     * @return 美容师
     */
    @Override
    public Beautician selectBeauticianById(Long id)
    {
        return beauticianMapper.selectBeauticianById(id);
    }

    /**
     * 查询美容师列表
     *
     * @param beautician 美容师
     * @return 美容师集合
     */
    @Override
    public List<Beautician> selectBeauticianList(Beautician beautician)
    {
        return beauticianMapper.selectBeauticianList(beautician);
    }

    /**
     * 查询美容师和时间安排
     *
     * @param id 美容师主键
     * @return 美容师和时间安排
     */
    @Override
    public BeauticianAndTimeVo selectBeauticianAndTimeByTimeId(Long id)
    {
        return beauticianMapper.selectBeauticianAndTimeByTimeId(id);
    }

    /**
     * 查询美容师和时间安排列表
     *
     * @param beautician 美容师
     * @return 美容师和时间安排集合
     */
    @Override
    public List<BeauticianAndTimeVo> selectBeauticianAndTimeList(Beautician beautician)
    {
        return beauticianMapper.selectBeauticianAndTimeList(beautician);
    }

    /**
     * 新增美容师
     * 
     * @param beautician 美容师
     * @return 结果
     */
    @Override
    public int insertBeautician(Beautician beautician)
    {
        return beauticianMapper.insertBeautician(beautician);
    }

    /**
     * 修改美容师
     * 
     * @param beautician 美容师
     * @return 结果
     */
    @Override
    public int updateBeautician(Beautician beautician)
    {
        return beauticianMapper.updateBeautician(beautician);
    }

    /**
     * 批量删除美容师
     * 
     * @param ids 需要删除的美容师主键
     * @return 结果
     */
    @Override
    public int deleteBeauticianByIds(Long[] ids)
    {
        return beauticianMapper.deleteBeauticianByIds(ids);
    }

    /**
     * 删除美容师信息
     * 
     * @param id 美容师主键
     * @return 结果
     */
    @Override
    public int deleteBeauticianById(Long id)
    {
        return beauticianMapper.deleteBeauticianById(id);
    }
}
