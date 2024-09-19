package com.sct.meiye.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.sct.meiye.domain.ServiceItemAndCate;
import com.sct.meiye.domain.ServiceItemAndDetail;
import com.sct.meiye.domain.ServiceItemDetails;
import com.sct.meiye.service.IServiceItemDetailsService;
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
import com.sct.meiye.domain.ServiceItem;
import com.sct.meiye.service.IServiceItemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务项目Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/ServiceItem")
public class ServiceItemController extends BaseController
{
    @Autowired
    private IServiceItemService serviceItemService;
    @Autowired
    private IServiceItemDetailsService serviceItemDetailsService;

    /**
     * 查询服务项目列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItem:list')")
    @GetMapping("/list")
    public TableDataInfo list(ServiceItem serviceItem)
    {
        startPage();
        List<ServiceItemAndCate> list = serviceItemService.selectServiceItemList(serviceItem);
        return getDataTable(list);
    }

    /**
     * 导出服务项目列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItem:export')")
    @Log(title = "服务项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ServiceItem serviceItem)
    {
        List<ServiceItemAndCate> list = serviceItemService.selectServiceItemList(serviceItem);
        ExcelUtil<ServiceItemAndCate> util = new ExcelUtil<ServiceItemAndCate>(ServiceItemAndCate.class);
        util.exportExcel(response, list, "服务项目数据");
    }

    /**
     * 获取服务项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItem:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(serviceItemService.selectServiceItemById(id));
    }

    /**
     * 新增服务项目
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItem:add')")
    @Log(title = "服务项目", businessType = BusinessType.INSERT)
    @PostMapping
    @Transactional(rollbackFor=Exception.class)
    public AjaxResult add(@RequestBody ServiceItemAndDetail serviceItemAndDetail)
    {
        ServiceItem serviceItem=new ServiceItem();
        BeanUtils.copyProperties(serviceItemAndDetail,serviceItem);//新的在后
        //插入服务项目
        serviceItemService.insertServiceItem(serviceItem);
        ServiceItemDetails serviceItemDetails=new ServiceItemDetails();
        BeanUtils.copyProperties(serviceItemAndDetail,serviceItemDetails);//新的在后
        serviceItemDetails.setServiceId(serviceItem.getId());
        serviceItemDetails.setId(serviceItemAndDetail.getDetailId());
        //插入详情
        serviceItemDetailsService.insertServiceItemDetails(serviceItemDetails);
        return toAjax(1);
    }

    /**
     * 修改服务项目
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItem:edit')")
    @Log(title = "服务项目", businessType = BusinessType.UPDATE)
    @PutMapping
    @Transactional(rollbackFor=Exception.class)
    public AjaxResult edit(@RequestBody ServiceItemAndDetail serviceItemAndDetail)
    {
        ServiceItem serviceItem=new ServiceItem();
        BeanUtils.copyProperties(serviceItemAndDetail,serviceItem);//新的在后
        //修改服务项目
        serviceItemService.updateServiceItem(serviceItem);
        ServiceItemDetails serviceItemDetails=new ServiceItemDetails();
        BeanUtils.copyProperties(serviceItemAndDetail,serviceItemDetails);//新的在后
        serviceItemDetails.setServiceId(serviceItem.getId());
        serviceItemDetails.setId(serviceItemAndDetail.getDetailId());
        //修改服务详情
        serviceItemDetailsService.updateServiceItemDetails(serviceItemDetails);
        return toAjax(1);
    }

    /**
     * 删除服务项目
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItem:remove')")
    @Log(title = "服务项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @Transactional
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(serviceItemService.deleteServiceItemByIds(ids));
    }
}
