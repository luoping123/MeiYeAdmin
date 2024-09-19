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
import com.sct.meiye.domain.BeauticianTime;
import com.sct.meiye.service.IBeauticianTimeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 美容师时间Controller
 * 
 * @author sct
 * @date 2022-05-20
 */
@RestController
@RequestMapping("/meiye/BeauticianTime")
public class BeauticianTimeController extends BaseController
{
    @Autowired
    private IBeauticianTimeService beauticianTimeService;

    /**
     * 查询美容师时间列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:BeauticianTime:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeauticianTime beauticianTime)
    {
        startPage();
        List<BeauticianTime> list = beauticianTimeService.selectBeauticianTimeList(beauticianTime);
        return getDataTable(list);
    }

    /**
     * 导出美容师时间列表
     */
    @PreAuthorize("@ss.hasPermi('meiye:BeauticianTime:export')")
    @Log(title = "美容师时间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BeauticianTime beauticianTime)
    {
        List<BeauticianTime> list = beauticianTimeService.selectBeauticianTimeList(beauticianTime);
        ExcelUtil<BeauticianTime> util = new ExcelUtil<BeauticianTime>(BeauticianTime.class);
        util.exportExcel(response, list, "美容师时间数据");
    }

    /**
     * 获取美容师时间详细信息
     */
    @PreAuthorize("@ss.hasPermi('meiye:BeauticianTime:query')")
    @GetMapping(value = "/{timeId}")
    public AjaxResult getInfo(@PathVariable("timeId") Long timeId)
    {
        return AjaxResult.success(beauticianTimeService.selectBeauticianTimeById(timeId));
    }

    /**
     * 新增美容师时间
     */
    @PreAuthorize("@ss.hasPermi('meiye:BeauticianTime:add')")
    @Log(title = "美容师时间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeauticianTime beauticianTime)
    {
        return toAjax(beauticianTimeService.insertBeauticianTime(beauticianTime));
    }

    /**
     * 修改美容师时间
     */
    @PreAuthorize("@ss.hasPermi('meiye:BeauticianTime:edit')")
    @Log(title = "美容师时间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeauticianTime beauticianTime)
    {
        return toAjax(beauticianTimeService.updateBeauticianTime(beauticianTime));
    }

    /**
     * 删除美容师时间
     */
    @PreAuthorize("@ss.hasPermi('meiye:BeauticianTime:remove')")
    @Log(title = "美容师时间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{timeIds}")
    public AjaxResult remove(@PathVariable Long[] timeIds)
    {
        return toAjax(beauticianTimeService.deleteBeauticianTimeByIds(timeIds));
    }
}
