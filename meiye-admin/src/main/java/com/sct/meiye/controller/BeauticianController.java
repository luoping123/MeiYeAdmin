package com.sct.meiye.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.sct.meiye.domain.BeauticianAndTimeVo;
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
import com.sct.meiye.domain.Beautician;
import com.sct.meiye.service.IBeauticianService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 美容师Controller
 * 
 * @author sct
 * @date 2022-05-18
 */
@RestController
@RequestMapping("/meiye/Beautician")
public class BeauticianController extends BaseController
{
    @Autowired
    private IBeauticianService beauticianService;

    /**
     * 查询美容师列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:Beautician:list')")
    @GetMapping("/list")
    public TableDataInfo list(Beautician beautician)
    {
        startPage();
        List<Beautician> list = beauticianService.selectBeauticianList(beautician);
        return getDataTable(list);
    }


    /**
     * 查询美容师排班列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:Beautician:list')")
    @GetMapping("/timeList")
    public TableDataInfo timeList(Beautician beautician)
    {
        startPage();
        List<BeauticianAndTimeVo> list = beauticianService.selectBeauticianAndTimeList(beautician);
        return getDataTable(list);
    }


    /**
     * 导出美容师列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:Beautician:export')")
    @Log(title = "美容师排班", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Beautician beautician)
    {
        List<BeauticianAndTimeVo> list = beauticianService.selectBeauticianAndTimeList(beautician);
        ExcelUtil<BeauticianAndTimeVo> util = new ExcelUtil<BeauticianAndTimeVo>(BeauticianAndTimeVo.class);
        util.exportExcel(response, list, "美容师数据");
    }

    /**
     * 获取美容师详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:Beautician:query')")
    @GetMapping(value = "/beautician{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(beauticianService.selectBeauticianById(id));
    }

    /**
     * 获取美容师排班详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:Beautician:query')")
    @GetMapping(value = "/beauticianAndTime{timeId}")
    public AjaxResult getTimeInfo(@PathVariable("timeId") Long timeId)
    {
        return AjaxResult.success(beauticianService.selectBeauticianAndTimeByTimeId(timeId));
    }

    /**
     * 新增美容师
     */
    @PreAuthorize("@ss.hasPermi('meiye:Beautician:add')")
    @Log(title = "美容师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Beautician beautician)
    {
        return toAjax(beauticianService.insertBeautician(beautician));
    }

    /**
     * 修改美容师
     */
    @PreAuthorize("@ss.hasPermi('meiye:Beautician:edit')")
    @Log(title = "美容师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Beautician beautician)
    {
        return toAjax(beauticianService.updateBeautician(beautician));
    }



    /**
     * 删除美容师
     */
    @PreAuthorize("@ss.hasPermi('meiye:Beautician:remove')")
    @Log(title = "美容师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(beauticianService.deleteBeauticianByIds(ids));
    }
}
