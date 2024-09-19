package com.sct.meiye.service;

import java.util.List;
import com.sct.meiye.domain.GridCate;

/**
 * 九宫格导航Service接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface IGridCateService 
{
    /**
     * 查询九宫格导航
     * 
     * @param id 九宫格导航主键
     * @return 九宫格导航
     */
    public GridCate selectGridCateById(Long id);

    /**
     * 查询九宫格导航列表
     * 
     * @param gridCate 九宫格导航
     * @return 九宫格导航集合
     */
    public List<GridCate> selectGridCateList(GridCate gridCate);

    /**
     * 新增九宫格导航
     * 
     * @param gridCate 九宫格导航
     * @return 结果
     */
    public int insertGridCate(GridCate gridCate);

    /**
     * 修改九宫格导航
     * 
     * @param gridCate 九宫格导航
     * @return 结果
     */
    public int updateGridCate(GridCate gridCate);

    /**
     * 批量删除九宫格导航
     * 
     * @param ids 需要删除的九宫格导航主键集合
     * @return 结果
     */
    public int deleteGridCateByIds(Long[] ids);

    /**
     * 删除九宫格导航信息
     * 
     * @param id 九宫格导航主键
     * @return 结果
     */
    public int deleteGridCateById(Long id);
}
