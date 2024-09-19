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
import com.sct.meiye.domain.ServiceItemDetails;
import com.sct.meiye.service.IServiceItemDetailsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务项目详情Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/ServiceItemDetails")
public class ServiceItemDetailsController extends BaseController
{
    @Autowired
    private IServiceItemDetailsService serviceItemDetailsService;

    /**
     * 查询服务项目详情列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(ServiceItemDetails serviceItemDetails)
    {
        startPage();
        List<ServiceItemDetails> list = serviceItemDetailsService.selectServiceItemDetailsList(serviceItemDetails);
        return getDataTable(list);
    }

    /**
     * 导出服务项目详情列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemDetails:export')")
    @Log(title = "服务项目详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ServiceItemDetails serviceItemDetails)
    {
        List<ServiceItemDetails> list = serviceItemDetailsService.selectServiceItemDetailsList(serviceItemDetails);
        ExcelUtil<ServiceItemDetails> util = new ExcelUtil<ServiceItemDetails>(ServiceItemDetails.class);
        util.exportExcel(response, list, "服务项目详情数据");
    }

    /**
     * 获取服务项目详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemDetails:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(serviceItemDetailsService.selectServiceItemDetailsById(id));
    }

    /**
     * 新增服务项目详情
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemDetails:add')")
    @Log(title = "服务项目详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ServiceItemDetails serviceItemDetails)
    {
        return toAjax(serviceItemDetailsService.insertServiceItemDetails(serviceItemDetails));
    }

    /**
     * 修改服务项目详情
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemDetails:edit')")
    @Log(title = "服务项目详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ServiceItemDetails serviceItemDetails)
    {
        return toAjax(serviceItemDetailsService.updateServiceItemDetails(serviceItemDetails));
    }

    /**
     * 删除服务项目详情
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemDetails:remove')")
    @Log(title = "服务项目详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(serviceItemDetailsService.deleteServiceItemDetailsByIds(ids));
    }
}
