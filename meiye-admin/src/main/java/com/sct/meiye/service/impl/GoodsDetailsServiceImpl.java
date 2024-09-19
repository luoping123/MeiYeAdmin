package com.sct.meiye.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.GoodsDetailsMapper;
import com.sct.meiye.domain.GoodsDetails;
import com.sct.meiye.service.IGoodsDetailsService;

/**
 * 商品详情Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class GoodsDetailsServiceImpl implements IGoodsDetailsService 
{
    @Autowired
    private GoodsDetailsMapper goodsDetailsMapper;

    /**
     * 查询商品详情
     * 
     * @param id 商品详情主键
     * @return 商品详情
     */
    @Override
    public GoodsDetails selectGoodsDetailsById(Long id)
    {
        return goodsDetailsMapper.selectGoodsDetailsById(id);
    }

    /**
     * 查询商品详情列表
     * 
     * @param goodsDetails 商品详情
     * @return 商品详情
     */
    @Override
    public List<GoodsDetails> selectGoodsDetailsList(GoodsDetails goodsDetails)
    {
        return goodsDetailsMapper.selectGoodsDetailsList(goodsDetails);
    }

    /**
     * 新增商品详情
     * 
     * @param goodsDetails 商品详情
     * @return 结果
     */
    @Override
    public int insertGoodsDetails(GoodsDetails goodsDetails)
    {
        return goodsDetailsMapper.insertGoodsDetails(goodsDetails);
    }

    /**
     * 修改商品详情
     * 
     * @param goodsDetails 商品详情
     * @return 结果
     */
    @Override
    public int updateGoodsDetails(GoodsDetails goodsDetails)
    {
        return goodsDetailsMapper.updateGoodsDetails(goodsDetails);
    }

    /**
     * 批量删除商品详情
     * 
     * @param ids 需要删除的商品详情主键
     * @return 结果
     */
    @Override
    public int deleteGoodsDetailsByIds(Long[] ids)
    {
        return goodsDetailsMapper.deleteGoodsDetailsByIds(ids);
    }

    /**
     * 删除商品详情信息
     * 
     * @param id 商品详情主键
     * @return 结果
     */
    @Override
    public int deleteGoodsDetailsById(Long id)
    {
        return goodsDetailsMapper.deleteGoodsDetailsById(id);
    }
}
