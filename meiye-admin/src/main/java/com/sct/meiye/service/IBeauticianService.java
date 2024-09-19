package com.sct.meiye.service;

import java.util.List;
import com.sct.meiye.domain.Beautician;
import com.sct.meiye.domain.BeauticianAndTimeVo;

/**
 * 美容师Service接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface IBeauticianService 
{
    /**
     * 查询美容师
     *
     * @param id 美容师主键
     * @return 美容师
     */
    public Beautician selectBeauticianById(Long id);

    /**
     * 查询美容师列表
     *
     * @param beautician 美容师
     * @return 美容师集合
     */
    public List<Beautician> selectBeauticianList(Beautician beautician);

    /**
     * 查询美容师和时间安排
     *
     * @param id 美容师主键
     * @return 美容师和时间安排
     */
    public BeauticianAndTimeVo selectBeauticianAndTimeByTimeId(Long id);

    /**
     * 查询美容师和时间安排列表
     *
     * @param beautician 美容师
     * @return 美容师和时间安排集合
     */
    public List<BeauticianAndTimeVo> selectBeauticianAndTimeList(Beautician beautician);


    /**
     * 新增美容师
     * 
     * @param beautician 美容师
     * @return 结果
     */
    public int insertBeautician(Beautician beautician);

    /**
     * 修改美容师
     * 
     * @param beautician 美容师
     * @return 结果
     */
    public int updateBeautician(Beautician beautician);

    /**
     * 批量删除美容师
     * 
     * @param ids 需要删除的美容师主键集合
     * @return 结果
     */
    public int deleteBeauticianByIds(Long[] ids);

    /**
     * 删除美容师信息
     * 
     * @param id 美容师主键
     * @return 结果
     */
    public int deleteBeauticianById(Long id);
}
