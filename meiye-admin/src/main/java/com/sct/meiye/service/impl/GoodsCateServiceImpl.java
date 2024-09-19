package com.sct.meiye.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.GoodsCateMapper;
import com.sct.meiye.domain.GoodsCate;
import com.sct.meiye.service.IGoodsCateService;

/**
 * 商品分类Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class GoodsCateServiceImpl implements IGoodsCateService 
{
    @Autowired
    private GoodsCateMapper goodsCateMapper;

    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public GoodsCate selectGoodsCateById(Long id)
    {
        return goodsCateMapper.selectGoodsCateById(id);
    }

    /**
     * 查询商品分类列表
     * 
     * @param goodsCate 商品分类
     * @return 商品分类
     */
    @Override
    public List<GoodsCate> selectGoodsCateList(GoodsCate goodsCate)
    {
        return goodsCateMapper.selectGoodsCateList(goodsCate);
    }

    /**
     * 新增商品分类
     * 
     * @param goodsCate 商品分类
     * @return 结果
     */
    @Override
    public int insertGoodsCate(GoodsCate goodsCate)
    {
        goodsCate.setCreateTime(DateUtils.getNowDate());
        return goodsCateMapper.insertGoodsCate(goodsCate);
    }

    /**
     * 修改商品分类
     * 
     * @param goodsCate 商品分类
     * @return 结果
     */
    @Override
    public int updateGoodsCate(GoodsCate goodsCate)
    {
        goodsCate.setUpdateTime(DateUtils.getNowDate());
        return goodsCateMapper.updateGoodsCate(goodsCate);
    }

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteGoodsCateByIds(Long[] ids)
    {
        return goodsCateMapper.deleteGoodsCateByIds(ids);
    }

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteGoodsCateById(Long id)
    {
        return goodsCateMapper.deleteGoodsCateById(id);
    }
}
