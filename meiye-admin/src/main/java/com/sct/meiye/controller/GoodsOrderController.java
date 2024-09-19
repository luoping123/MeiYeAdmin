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
import com.sct.meiye.domain.GoodsOrder;
import com.sct.meiye.service.IGoodsOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品订单Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/GoodsOrder")
public class GoodsOrderController extends BaseController
{
    @Autowired
    private IGoodsOrderService goodsOrderService;

    /**
     * 查询商品订单列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(GoodsOrder goodsOrder)
    {
        startPage();
        List<GoodsOrder> list = goodsOrderService.selectGoodsOrderList(goodsOrder);
        return getDataTable(list);
    }

    /**
     * 导出商品订单列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsOrder:export')")
    @Log(title = "商品订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GoodsOrder goodsOrder)
    {
        List<GoodsOrder> list = goodsOrderService.selectGoodsOrderList(goodsOrder);
        ExcelUtil<GoodsOrder> util = new ExcelUtil<GoodsOrder>(GoodsOrder.class);
        util.exportExcel(response, list, "商品订单数据");
    }

    /**
     * 获取商品订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(goodsOrderService.selectGoodsOrderById(id));
    }

    /**
     * 新增商品订单
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsOrder:add')")
    @Log(title = "商品订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GoodsOrder goodsOrder)
    {
        return toAjax(goodsOrderService.insertGoodsOrder(goodsOrder));
    }

    /**
     * 修改商品订单
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsOrder:edit')")
    @Log(title = "商品订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GoodsOrder goodsOrder)
    {
        return toAjax(goodsOrderService.updateGoodsOrder(goodsOrder));
    }

    /**
     * 删除商品订单
     */
    @PreAuthorize("@ss.hasPermi('meiye:GoodsOrder:remove')")
    @Log(title = "商品订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(goodsOrderService.deleteGoodsOrderByIds(ids));
    }
}
