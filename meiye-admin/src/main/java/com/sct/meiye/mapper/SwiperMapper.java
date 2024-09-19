package com.sct.meiye.mapper;

import java.util.List;
import com.sct.meiye.domain.Swiper;

/**
 * 轮播图Mapper接口
 * 
 * @author sct
 * @date 2022-05-17
 */
public interface SwiperMapper 
{
    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    public Swiper selectSwiperById(Long id);

    /**
     * 查询轮播图列表
     * 
     * @param swiper 轮播图
     * @return 轮播图集合
     */
    public List<Swiper> selectSwiperList(Swiper swiper);

    /**
     * 新增轮播图
     * 
     * @param swiper 轮播图
     * @return 结果
     */
    public int insertSwiper(Swiper swiper);

    /**
     * 修改轮播图
     * 
     * @param swiper 轮播图
     * @return 结果
     */
    public int updateSwiper(Swiper swiper);

    /**
     * 删除轮播图
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    public int deleteSwiperById(Long id);

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSwiperByIds(Long[] ids);
}
