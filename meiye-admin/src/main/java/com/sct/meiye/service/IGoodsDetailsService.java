package com.sct.meiye.service;

import java.util.List;
import com.sct.meiye.domain.GoodsDetails;

/**
 * 商品详情Service接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface IGoodsDetailsService 
{
    /**
     * 查询商品详情
     * 
     * @param id 商品详情主键
     * @return 商品详情
     */
    public GoodsDetails selectGoodsDetailsById(Long id);

    /**
     * 查询商品详情列表
     * 
     * @param goodsDetails 商品详情
     * @return 商品详情集合
     */
    public List<GoodsDetails> selectGoodsDetailsList(GoodsDetails goodsDetails);

    /**
     * 新增商品详情
     * 
     * @param goodsDetails 商品详情
     * @return 结果
     */
    public int insertGoodsDetails(GoodsDetails goodsDetails);

    /**
     * 修改商品详情
     * 
     * @param goodsDetails 商品详情
     * @return 结果
     */
    public int updateGoodsDetails(GoodsDetails goodsDetails);

    /**
     * 批量删除商品详情
     * 
     * @param ids 需要删除的商品详情主键集合
     * @return 结果
     */
    public int deleteGoodsDetailsByIds(Long[] ids);

    /**
     * 删除商品详情信息
     * 
     * @param id 商品详情主键
     * @return 结果
     */
    public int deleteGoodsDetailsById(Long id);
}
