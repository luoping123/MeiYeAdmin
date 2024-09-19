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
import com.sct.meiye.domain.GoodsCate;
import com.sct.meiye.service.IGoodsCateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品分类Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/GoodsCate")
public class GoodsCateController extends BaseController
{
    @Autowired
    private IGoodsCateService goodsCateService;

    /**
     * 查询商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsCate:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsCate goodsCate)
    {
        startPage();
        List<GoodsCate> list = goodsCateService.selectGoodsCateList(goodsCate);
        return getDataTable(list);
    }

    /**
     * 导出商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsCate:export')")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsCate goodsCate)
    {
        List<GoodsCate> list = goodsCateService.selectGoodsCateList(goodsCate);
        ExcelUtil<GoodsCate> util = new ExcelUtil<GoodsCate>(GoodsCate.class);
        util.exportExcel(response, list, "商品分类数据");
    }

    /**
     * 获取商品分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsCate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(goodsCateService.selectGoodsCateById(id));
    }

    /**
     * 新增商品分类
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsCate:add')")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsCate goodsCate)
    {
        return toAjax(goodsCateService.insertGoodsCate(goodsCate));
    }

    /**
     * 修改商品分类
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsCate:edit')")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsCate goodsCate)
    {
        return toAjax(goodsCateService.updateGoodsCate(goodsCate));
    }

    /**
     * 删除商品分类
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsCate:remove')")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(goodsCateService.deleteGoodsCateByIds(ids));
    }
}
