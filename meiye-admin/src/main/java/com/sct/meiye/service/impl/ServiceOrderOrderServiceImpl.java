package com.sct.meiye.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.sct.meiye.domain.ServiceOrderOrderAndInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sct.meiye.mapper.ServiceOrderOrderMapper;
import com.sct.meiye.domain.ServiceOrderOrder;
import com.sct.meiye.service.IServiceOrderOrderService;

/**
 * 服务项目订单Service业务层处理
 * 
 * @author sct
 * @date 2022-05-18
 */
@Service
public class ServiceOrderOrderServiceImpl implements IServiceOrderOrderService 
{
    @Autowired
    private ServiceOrderOrderMapper serviceOrderOrderMapper;

    /**
     * 查询服务项目订单
     * 
     * @param orderId 服务项目订单主键
     * @return 服务项目订单
     */
    @Override
    public ServiceOrderOrder selectServiceOrderOrderByOrderId(String orderId)
    {
        return serviceOrderOrderMapper.selectServiceOrderOrderByOrderId(orderId);
    }

    /**
     * 查询服务项目订单列表
     * 
     * @param serviceOrderOrder 服务项目订单
     * @return 服务项目订单
     */
    @Override
    public List<ServiceOrderOrderAndInfo> selectServiceOrderOrderList(ServiceOrderOrder serviceOrderOrder)
    {
        return serviceOrderOrderMapper.selectServiceOrderOrderList(serviceOrderOrder);
    }

    /**
     * 新增服务项目订单
     * 
     * @param serviceOrderOrder 服务项目订单
     * @return 结果
     */
    @Override
    public int insertServiceOrderOrder(ServiceOrderOrder serviceOrderOrder)
    {
        serviceOrderOrder.setCreateTime(DateUtils.getNowDate());
        return serviceOrderOrderMapper.insertServiceOrderOrder(serviceOrderOrder);
    }

    /**
     * 修改服务项目订单
     * 
     * @param serviceOrderOrder 服务项目订单
     * @return 结果
     */
    @Override
    public int updateServiceOrderOrder(ServiceOrderOrder serviceOrderOrder)
    {
        return serviceOrderOrderMapper.updateServiceOrderOrder(serviceOrderOrder);
    }

    /**
     * 批量删除服务项目订单
     * 
     * @param orderIds 需要删除的服务项目订单主键
     * @return 结果
     */
    @Override
    public int deleteServiceOrderOrderByOrderIds(String[] orderIds)
    {
        return serviceOrderOrderMapper.deleteServiceOrderOrderByOrderIds(orderIds);
    }

    /**
     * 删除服务项目订单信息
     * 
     * @param orderId 服务项目订单主键
     * @return 结果
     */
    @Override
    public int deleteServiceOrderOrderByOrderId(String orderId)
    {
        return serviceOrderOrderMapper.deleteServiceOrderOrderByOrderId(orderId);
    }
}
