package com.sct.meiye.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.sct.meiye.domain.GoodsDetails;
import com.sct.meiye.service.IGoodsDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
import com.sct.meiye.domain.Goods;
import com.sct.meiye.service.IGoodsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/Goods")
public class GoodsController extends BaseController
{
    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IGoodsDetailsService goodsDetailsService;

    /**
     * 查询商品列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:Goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:Goods:export')")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Goods goods)
    {
        List<Goods> list = goodsService.selectGoodsList(goods);
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        util.exportExcel(response, list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:Goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(goodsService.selectGoodsById(id));
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('meiye:Goods:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    @Transactional(rollbackFor=Exception.class)
    public AjaxResult add(@RequestBody Goods goods)
    {
        GoodsDetails goodsDetails=new GoodsDetails();
        BeanUtils.copyProperties(goods,goodsDetails);
        goodsService.insertGoods(goods);
        goodsDetails.setGoodsId(goods.getId());
        goodsDetailsService.insertGoodsDetails(goodsDetails);
        return toAjax(1);
    }

    /**
     * 修改商品
     */
    @PreAuthorize("@ss.hasPermi('meiye:Goods:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    @Transactional(rollbackFor=Exception.class)
    public AjaxResult edit(@RequestBody Goods goods)
    {
        GoodsDetails goodsDetails=new GoodsDetails();
        BeanUtils.copyProperties(goods,goodsDetails);
        goodsService.updateGoods(goods);
        goodsDetails.setGoodsId(goods.getId());
        goodsDetails.setId(goods.getDetailId());
        goodsDetailsService.updateGoodsDetails(goodsDetails);
        return toAjax(1);
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('meiye:Goods:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(goodsService.deleteGoodsByIds(ids));
    }
}
