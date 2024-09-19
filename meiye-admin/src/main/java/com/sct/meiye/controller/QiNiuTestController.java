package com.sct.meiye.controller;


import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.sct.meiye.service.impl.QiniuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/my")
public class QiNiuTestController {

    @Autowired
    private QiniuService qiniuService;

    @PostMapping("/upload")
    @ResponseBody
    public AjaxResult uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception{
        try
        {
            String fileUrl=qiniuService.saveImage(file);
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", fileUrl);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }


    }
}
