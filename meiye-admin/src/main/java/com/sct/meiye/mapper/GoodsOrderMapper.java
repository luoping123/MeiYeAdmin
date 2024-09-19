package com.sct.meiye.mapper;

import java.util.List;
import com.sct.meiye.domain.GoodsOrder;

/**
 * 商品订单Mapper接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface GoodsOrderMapper 
{
    /**
     * 查询商品订单
     * 
     * @param id 商品订单主键
     * @return 商品订单
     */
    public GoodsOrder selectGoodsOrderById(Long id);

    /**
     * 查询商品订单列表
     * 
     * @param goodsOrder 商品订单
     * @return 商品订单集合
     */
    public List<GoodsOrder> selectGoodsOrderList(GoodsOrder goodsOrder);

    /**
     * 新增商品订单
     * 
     * @param goodsOrder 商品订单
     * @return 结果
     */
    public int insertGoodsOrder(GoodsOrder goodsOrder);

    /**
     * 修改商品订单
     * 
     * @param goodsOrder 商品订单
     * @return 结果
     */
    public int updateGoodsOrder(GoodsOrder goodsOrder);

    /**
     * 删除商品订单
     * 
     * @param id 商品订单主键
     * @return 结果
     */
    public int deleteGoodsOrderById(Long id);

    /**
     * 批量删除商品订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsOrderByIds(Long[] ids);
}
