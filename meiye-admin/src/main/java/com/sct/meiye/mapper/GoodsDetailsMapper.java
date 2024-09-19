package com.sct.meiye.mapper;

import java.util.List;
import com.sct.meiye.domain.GoodsDetails;

/**
 * 商品详情Mapper接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface GoodsDetailsMapper 
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
     * 删除商品详情
     * 
     * @param id 商品详情主键
     * @return 结果
     */
    public int deleteGoodsDetailsById(Long id);

    /**
     * 批量删除商品详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsDetailsByIds(Long[] ids);
}
