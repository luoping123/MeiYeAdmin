package com.sct.meiye.service;

import java.util.List;
import com.sct.meiye.domain.GoodsCate;

/**
 * 商品分类Service接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface IGoodsCateService 
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
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键集合
     * @return 结果
     */
    public int deleteGoodsCateByIds(Long[] ids);

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteGoodsCateById(Long id);
}
