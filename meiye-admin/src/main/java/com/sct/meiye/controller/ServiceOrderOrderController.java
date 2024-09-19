package com.sct.meiye.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.sct.meiye.domain.ServiceOrderOrderAndInfo;
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
import com.sct.meiye.domain.ServiceOrderOrder;
import com.sct.meiye.service.IServiceOrderOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务项目订单Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/ServiceOrderOrder")
public class ServiceOrderOrderController extends BaseController
{
    @Autowired
    private IServiceOrderOrderService serviceOrderOrderService;

    /**
     * 查询服务项目订单列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceOrderOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(ServiceOrderOrder serviceOrderOrder)
    {
        startPage();
        List<ServiceOrderOrderAndInfo> list = serviceOrderOrderService.selectServiceOrderOrderList(serviceOrderOrder);
        return getDataTable(list);

    }

    /**
     * 导出服务项目订单列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceOrderOrder:export')")
    @Log(title = "服务项目订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ServiceOrderOrder serviceOrderOrder)
    {
        List<ServiceOrderOrderAndInfo> list = serviceOrderOrderService.selectServiceOrderOrderList(serviceOrderOrder);
        ExcelUtil<ServiceOrderOrderAndInfo> util = new ExcelUtil<ServiceOrderOrderAndInfo>(ServiceOrderOrderAndInfo.class);
        util.exportExcel(response, list, "服务项目订单数据");
    }

    /**
     * 获取服务项目订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceOrderOrder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") String orderId)
    {
        return AjaxResult.success(serviceOrderOrderService.selectServiceOrderOrderByOrderId(orderId));
    }

    /**
     * 新增服务项目订单
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceOrderOrder:add')")
    @Log(title = "服务项目订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ServiceOrderOrder serviceOrderOrder)
    {
        return toAjax(serviceOrderOrderService.insertServiceOrderOrder(serviceOrderOrder));
    }

    /**
     * 修改服务项目订单
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceOrderOrder:edit')")
    @Log(title = "服务项目订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ServiceOrderOrder serviceOrderOrder)
    {
        return toAjax(serviceOrderOrderService.updateServiceOrderOrder(serviceOrderOrder));
    }

    /**
     * 删除服务项目订单
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceOrderOrder:remove')")
    @Log(title = "服务项目订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable String[] orderIds)
    {
        return toAjax(serviceOrderOrderService.deleteServiceOrderOrderByOrderIds(orderIds));
    }
}
