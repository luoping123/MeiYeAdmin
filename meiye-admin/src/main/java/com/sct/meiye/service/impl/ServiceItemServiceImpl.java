package com.sct.meiye.service.impl;

import java.util.List;

import com.sct.meiye.domain.ServiceItemAndCate;
import com.sct.meiye.domain.ServiceItemAndDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.ServiceItemMapper;
import com.sct.meiye.domain.ServiceItem;
import com.sct.meiye.service.IServiceItemService;

/**
 * 服务项目Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class ServiceItemServiceImpl implements IServiceItemService 
{
    @Autowired
    private ServiceItemMapper serviceItemMapper;

    /**
     * 查询服务项目
     * 
     * @param id 服务项目主键
     * @return 服务项目
     */
    @Override
    public ServiceItemAndDetail selectServiceItemById(Long id)
    {
        return serviceItemMapper.selectServiceItemById(id);
    }

    /**
     * 查询服务项目列表
     * 
     * @param serviceItem 服务项目
     * @return 服务项目
     */
    @Override
    public List<ServiceItemAndCate> selectServiceItemList(ServiceItem serviceItem)
    {
        return serviceItemMapper.selectServiceItemList(serviceItem);
    }

    /**
     * 新增服务项目
     * 
     * @param serviceItem 服务项目
     * @return 结果
     */
    @Override
    public int insertServiceItem(ServiceItem serviceItem)
    {
        return serviceItemMapper.insertServiceItem(serviceItem);
    }

    /**
     * 修改服务项目
     * 
     * @param serviceItem 服务项目
     * @return 结果
     */
    @Override
    public int updateServiceItem(ServiceItem serviceItem)
    {
        return serviceItemMapper.updateServiceItem(serviceItem);
    }

    /**
     * 批量删除服务项目
     * 
     * @param ids 需要删除的服务项目主键
     * @return 结果
     */
    @Override
    public int deleteServiceItemByIds(Long[] ids)
    {
        return serviceItemMapper.deleteServiceItemByIds(ids);
    }

    /**
     * 删除服务项目信息
     * 
     * @param id 服务项目主键
     * @return 结果
     */
    @Override
    public int deleteServiceItemById(Long id)
    {
        return serviceItemMapper.deleteServiceItemById(id);
    }
}
