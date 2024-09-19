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
import com.sct.meiye.domain.GoodsDetails;
import com.sct.meiye.service.IGoodsDetailsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品详情Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/GoodsDetails")
public class GoodsDetailsController extends BaseController
{
    @Autowired
    private IGoodsDetailsService goodsDetailsService;

    /**
     * 查询商品详情列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsDetails goodsDetails)
    {
        startPage();
        List<GoodsDetails> list = goodsDetailsService.selectGoodsDetailsList(goodsDetails);
        return getDataTable(list);
    }

    /**
     * 导出商品详情列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsDetails:export')")
    @Log(title = "商品详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsDetails goodsDetails)
    {
        List<GoodsDetails> list = goodsDetailsService.selectGoodsDetailsList(goodsDetails);
        ExcelUtil<GoodsDetails> util = new ExcelUtil<GoodsDetails>(GoodsDetails.class);
        util.exportExcel(response, list, "商品详情数据");
    }

    /**
     * 获取商品详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsDetails:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(goodsDetailsService.selectGoodsDetailsById(id));
    }

    /**
     * 新增商品详情
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsDetails:add')")
    @Log(title = "商品详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsDetails goodsDetails)
    {
        return toAjax(goodsDetailsService.insertGoodsDetails(goodsDetails));
    }

    /**
     * 修改商品详情
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsDetails:edit')")
    @Log(title = "商品详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsDetails goodsDetails)
    {
        return toAjax(goodsDetailsService.updateGoodsDetails(goodsDetails));
    }

    /**
     * 删除商品详情
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsDetails:remove')")
    @Log(title = "商品详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(goodsDetailsService.deleteGoodsDetailsByIds(ids));
    }
}
