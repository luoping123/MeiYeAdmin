package com.sct.meiye.service;

import java.util.List;
import com.sct.meiye.domain.ServiceOrderOrder;
import com.sct.meiye.domain.ServiceOrderOrderAndInfo;

/**
 * 服务项目订单Service接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface IServiceOrderOrderService 
{
    /**
     * 查询服务项目订单
     * 
     * @param orderId 服务项目订单主键
     * @return 服务项目订单
     */
    public ServiceOrderOrder selectServiceOrderOrderByOrderId(String orderId);

    /**
     * 查询服务项目订单列表
     * 
     * @param serviceOrderOrder 服务项目订单
     * @return 服务项目订单集合
     */
    public List<ServiceOrderOrderAndInfo> selectServiceOrderOrderList(ServiceOrderOrder serviceOrderOrder);

    /**
     * 新增服务项目订单
     * 
     * @param serviceOrderOrder 服务项目订单
     * @return 结果
     */
    public int insertServiceOrderOrder(ServiceOrderOrder serviceOrderOrder);

    /**
     * 修改服务项目订单
     * 
     * @param serviceOrderOrder 服务项目订单
     * @return 结果
     */
    public int updateServiceOrderOrder(ServiceOrderOrder serviceOrderOrder);

    /**
     * 批量删除服务项目订单
     * 
     * @param orderIds 需要删除的服务项目订单主键集合
     * @return 结果
     */
    public int deleteServiceOrderOrderByOrderIds(String[] orderIds);

    /**
     * 删除服务项目订单信息
     * 
     * @param orderId 服务项目订单主键
     * @return 结果
     */
    public int deleteServiceOrderOrderByOrderId(String orderId);
}
