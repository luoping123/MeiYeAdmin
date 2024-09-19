package com.sct.meiye.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.ServiceItemCateMapper;
import com.sct.meiye.domain.ServiceItemCate;
import com.sct.meiye.service.IServiceItemCateService;

/**
 * 服务项目分类Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class ServiceItemCateServiceImpl implements IServiceItemCateService 
{
    @Autowired
    private ServiceItemCateMapper serviceItemCateMapper;

    /**
     * 查询服务项目分类
     * 
     * @param id 服务项目分类主键
     * @return 服务项目分类
     */
    @Override
    public ServiceItemCate selectServiceItemCateById(Long id)
    {
        return serviceItemCateMapper.selectServiceItemCateById(id);
    }

    /**
     * 查询服务项目分类列表
     * 
     * @param serviceItemCate 服务项目分类
     * @return 服务项目分类
     */
    @Override
    public List<ServiceItemCate> selectServiceItemCateList(ServiceItemCate serviceItemCate)
    {
        return serviceItemCateMapper.selectServiceItemCateList(serviceItemCate);
    }

    /**
     * 新增服务项目分类
     * 
     * @param serviceItemCate 服务项目分类
     * @return 结果
     */
    @Override
    public int insertServiceItemCate(ServiceItemCate serviceItemCate)
    {
        return serviceItemCateMapper.insertServiceItemCate(serviceItemCate);
    }

    /**
     * 修改服务项目分类
     * 
     * @param serviceItemCate 服务项目分类
     * @return 结果
     */
    @Override
    public int updateServiceItemCate(ServiceItemCate serviceItemCate)
    {
        return serviceItemCateMapper.updateServiceItemCate(serviceItemCate);
    }

    /**
     * 批量删除服务项目分类
     * 
     * @param ids 需要删除的服务项目分类主键
     * @return 结果
     */
    @Override
    public int deleteServiceItemCateByIds(Long[] ids)
    {
        return serviceItemCateMapper.deleteServiceItemCateByIds(ids);
    }

    /**
     * 删除服务项目分类信息
     * 
     * @param id 服务项目分类主键
     * @return 结果
     */
    @Override
    public int deleteServiceItemCateById(Long id)
    {
        return serviceItemCateMapper.deleteServiceItemCateById(id);
    }
}
