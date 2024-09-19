package com.sct.meiye.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.sct.meiye.domain.GridCate;
import com.sct.meiye.service.IGridCateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 九宫格导航Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/GridCate")
public class GridCateController extends BaseController
{
    @Autowired
    private IGridCateService gridCateService;

    /**
     * 查询九宫格导航列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:GridCate:list')")
    @GetMapping("/list")
    public TableDataInfo list(GridCate gridCate)
    {
        startPage();
        List<GridCate> list = gridCateService.selectGridCateList(gridCate);
        return getDataTable(list);
    }

    /**
     * 导出九宫格导航列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:GridCate:export')")
    @Log(title = "九宫格导航", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GridCate gridCate)
    {
        List<GridCate> list = gridCateService.selectGridCateList(gridCate);
        ExcelUtil<GridCate> util = new ExcelUtil<GridCate>(GridCate.class);
        util.exportExcel(response, list, "九宫格导航数据");
    }

    /**
     * 获取九宫格导航详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:GridCate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(gridCateService.selectGridCateById(id));
    }

    /**
     * 新增九宫格导航
     */
    @PreAuthorize("@ss.hasPermi('meiye:GridCate:add')")
    @Log(title = "九宫格导航", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GridCate gridCate)
    {
        return toAjax(gridCateService.insertGridCate(gridCate));
    }

    /**
     * 修改九宫格导航
     */
    @PreAuthorize("@ss.hasPermi('meiye:GridCate:edit')")
    @Log(title = "九宫格导航", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GridCate gridCate)
    {
        return toAjax(gridCateService.updateGridCate(gridCate));
    }

    /**
     * 删除九宫格导航
     */
    @PreAuthorize("@ss.hasPermi('meiye:GridCate:remove')")
    @Log(title = "九宫格导航", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(gridCateService.deleteGridCateByIds(ids));
    }
}
