package com.sct.meiye.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.GridCateMapper;
import com.sct.meiye.domain.GridCate;
import com.sct.meiye.service.IGridCateService;

/**
 * 九宫格导航Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class GridCateServiceImpl implements IGridCateService 
{
    @Autowired
    private GridCateMapper gridCateMapper;

    /**
     * 查询九宫格导航
     * 
     * @param id 九宫格导航主键
     * @return 九宫格导航
     */
    @Override
    public GridCate selectGridCateById(Long id)
    {
        return gridCateMapper.selectGridCateById(id);
    }

    /**
     * 查询九宫格导航列表
     * 
     * @param gridCate 九宫格导航
     * @return 九宫格导航
     */
    @Override
    public List<GridCate> selectGridCateList(GridCate gridCate)
    {
        return gridCateMapper.selectGridCateList(gridCate);
    }

    /**
     * 新增九宫格导航
     * 
     * @param gridCate 九宫格导航
     * @return 结果
     */
    @Override
    public int insertGridCate(GridCate gridCate)
    {
        return gridCateMapper.insertGridCate(gridCate);
    }

    /**
     * 修改九宫格导航
     * 
     * @param gridCate 九宫格导航
     * @return 结果
     */
    @Override
    public int updateGridCate(GridCate gridCate)
    {
        return gridCateMapper.updateGridCate(gridCate);
    }

    /**
     * 批量删除九宫格导航
     * 
     * @param ids 需要删除的九宫格导航主键
     * @return 结果
     */
    @Override
    public int deleteGridCateByIds(Long[] ids)
    {
        return gridCateMapper.deleteGridCateByIds(ids);
    }

    /**
     * 删除九宫格导航信息
     * 
     * @param id 九宫格导航主键
     * @return 结果
     */
    @Override
    public int deleteGridCateById(Long id)
    {
        return gridCateMapper.deleteGridCateById(id);
    }
}
