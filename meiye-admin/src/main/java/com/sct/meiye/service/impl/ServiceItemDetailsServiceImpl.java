package com.sct.meiye.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.ServiceItemDetailsMapper;
import com.sct.meiye.domain.ServiceItemDetails;
import com.sct.meiye.service.IServiceItemDetailsService;

/**
 * 服务项目详情Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class ServiceItemDetailsServiceImpl implements IServiceItemDetailsService 
{
    @Autowired
    private ServiceItemDetailsMapper serviceItemDetailsMapper;

    /**
     * 查询服务项目详情
     * 
     * @param id 服务项目详情主键
     * @return 服务项目详情
     */
    @Override
    public ServiceItemDetails selectServiceItemDetailsById(Long id)
    {
        return serviceItemDetailsMapper.selectServiceItemDetailsById(id);
    }

    /**
     * 查询服务项目详情列表
     * 
     * @param serviceItemDetails 服务项目详情
     * @return 服务项目详情
     */
    @Override
    public List<ServiceItemDetails> selectServiceItemDetailsList(ServiceItemDetails serviceItemDetails)
    {
        return serviceItemDetailsMapper.selectServiceItemDetailsList(serviceItemDetails);
    }

    /**
     * 新增服务项目详情
     * 
     * @param serviceItemDetails 服务项目详情
     * @return 结果
     */
    @Override
    public int insertServiceItemDetails(ServiceItemDetails serviceItemDetails)
    {
        return serviceItemDetailsMapper.insertServiceItemDetails(serviceItemDetails);
    }

    /**
     * 修改服务项目详情
     * 
     * @param serviceItemDetails 服务项目详情
     * @return 结果
     */
    @Override
    public int updateServiceItemDetails(ServiceItemDetails serviceItemDetails)
    {
        return serviceItemDetailsMapper.updateServiceItemDetails(serviceItemDetails);
    }

    /**
     * 批量删除服务项目详情
     * 
     * @param ids 需要删除的服务项目详情主键
     * @return 结果
     */
    @Override
    public int deleteServiceItemDetailsByIds(Long[] ids)
    {
        return serviceItemDetailsMapper.deleteServiceItemDetailsByIds(ids);
    }

    /**
     * 删除服务项目详情信息
     * 
     * @param id 服务项目详情主键
     * @return 结果
     */
    @Override
    public int deleteServiceItemDetailsById(Long id)
    {
        return serviceItemDetailsMapper.deleteServiceItemDetailsById(id);
    }
}
