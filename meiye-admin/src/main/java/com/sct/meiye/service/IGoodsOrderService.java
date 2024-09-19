package com.sct.meiye.service;

import java.util.List;
import com.sct.meiye.domain.GoodsOrder;

/**
 * 商品订单Service接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface IGoodsOrderService 
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
     * 批量删除商品订单
     * 
     * @param ids 需要删除的商品订单主键集合
     * @return 结果
     */
    public int deleteGoodsOrderByIds(Long[] ids);

    /**
     * 删除商品订单信息
     * 
     * @param id 商品订单主键
     * @return 结果
     */
    public int deleteGoodsOrderById(Long id);
}
