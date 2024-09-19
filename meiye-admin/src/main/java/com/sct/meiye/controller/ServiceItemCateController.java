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
import com.sct.meiye.domain.ServiceItemCate;
import com.sct.meiye.service.IServiceItemCateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务项目分类Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/ServiceItemCate")
public class ServiceItemCateController extends BaseController
{
    @Autowired
    private IServiceItemCateService serviceItemCateService;

    /**
     * 查询服务项目分类列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemCate:list')")
    @GetMapping("/list")
    public TableDataInfo list(ServiceItemCate serviceItemCate)
    {
        startPage();
        List<ServiceItemCate> list = serviceItemCateService.selectServiceItemCateList(serviceItemCate);
        return getDataTable(list);
    }

    /**
     * 导出服务项目分类列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemCate:export')")
    @Log(title = "服务项目分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ServiceItemCate serviceItemCate)
    {
        List<ServiceItemCate> list = serviceItemCateService.selectServiceItemCateList(serviceItemCate);
        ExcelUtil<ServiceItemCate> util = new ExcelUtil<ServiceItemCate>(ServiceItemCate.class);
        util.exportExcel(response, list, "服务项目分类数据");
    }

    /**
     * 获取服务项目分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemCate:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(serviceItemCateService.selectServiceItemCateById(id));
    }

    /**
     * 新增服务项目分类
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemCate:add')")
    @Log(title = "服务项目分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ServiceItemCate serviceItemCate)
    {
        return toAjax(serviceItemCateService.insertServiceItemCate(serviceItemCate));
    }

    /**
     * 修改服务项目分类
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemCate:edit')")
    @Log(title = "服务项目分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ServiceItemCate serviceItemCate)
    {
        return toAjax(serviceItemCateService.updateServiceItemCate(serviceItemCate));
    }

    /**
     * 删除服务项目分类
     */
    @PreAuthorize("@ss.hasPermi('meiye:ServiceItemCate:remove')")
    @Log(title = "服务项目分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(serviceItemCateService.deleteServiceItemCateByIds(ids));
    }
}
