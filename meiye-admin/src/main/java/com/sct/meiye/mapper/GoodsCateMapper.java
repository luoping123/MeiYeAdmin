package com.sct.meiye.mapper;

import java.util.List;
import com.sct.meiye.domain.GoodsCate;

/**
 * 商品分类Mapper接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface GoodsCateMapper 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    public GoodsCate selectGoodsCateById(Long id);

    /**
     * 查询商品分类列表
     * 
     * @param goodsCate 商品分类
     * @return 商品分类集合
     */
    public List<GoodsCate> selectGoodsCateList(GoodsCate goodsCate);

    /**
     * 新增商品分类
     * 
     * @param goodsCate 商品分类
     * @return 结果
     */
    public int insertGoodsCate(GoodsCate goodsCate);

    /**
     * 修改商品分类
     * 
     * @param goodsCate 商品分类
     * @return 结果
     */
    public int updateGoodsCate(GoodsCate goodsCate);

    /**
     * 删除商品分类
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteGoodsCateById(Long id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsCateByIds(Long[] ids);
}
