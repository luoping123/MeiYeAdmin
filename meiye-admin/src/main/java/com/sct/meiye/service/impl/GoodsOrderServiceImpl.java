package com.sct.meiye.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.GoodsOrderMapper;
import com.sct.meiye.domain.GoodsOrder;
import com.sct.meiye.service.IGoodsOrderService;

/**
 * 商品订单Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class GoodsOrderServiceImpl implements IGoodsOrderService 
{
    @Autowired
    private GoodsOrderMapper goodsOrderMapper;

    /**
     * 查询商品订单
     * 
     * @param id 商品订单主键
     * @return 商品订单
     */
    @Override
    public GoodsOrder selectGoodsOrderById(Long id)
    {
        return goodsOrderMapper.selectGoodsOrderById(id);
    }

    /**
     * 查询商品订单列表
     * 
     * @param goodsOrder 商品订单
     * @return 商品订单
     */
    @Override
    public List<GoodsOrder> selectGoodsOrderList(GoodsOrder goodsOrder)
    {
        return goodsOrderMapper.selectGoodsOrderList(goodsOrder);
    }

    /**
     * 新增商品订单
     * 
     * @param goodsOrder 商品订单
     * @return 结果
     */
    @Override
    public int insertGoodsOrder(GoodsOrder goodsOrder)
    {
        goodsOrder.setCreateTime(DateUtils.getNowDate());
        return goodsOrderMapper.insertGoodsOrder(goodsOrder);
    }

    /**
     * 修改商品订单
     * 
     * @param goodsOrder 商品订单
     * @return 结果
     */
    @Override
    public int updateGoodsOrder(GoodsOrder goodsOrder)
    {
        return goodsOrderMapper.updateGoodsOrder(goodsOrder);
    }

    /**
     * 批量删除商品订单
     * 
     * @param ids 需要删除的商品订单主键
     * @return 结果
     */
    @Override
    public int deleteGoodsOrderByIds(Long[] ids)
    {
        return goodsOrderMapper.deleteGoodsOrderByIds(ids);
    }

    /**
     * 删除商品订单信息
     * 
     * @param id 商品订单主键
     * @return 结果
     */
    @Override
    public int deleteGoodsOrderById(Long id)
    {
        return goodsOrderMapper.deleteGoodsOrderById(id);
    }
}
