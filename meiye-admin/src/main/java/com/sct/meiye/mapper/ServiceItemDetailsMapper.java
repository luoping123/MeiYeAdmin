package com.sct.meiye.mapper;

import java.util.List;
import com.sct.meiye.domain.ServiceItemDetails;

/**
 * 服务项目详情Mapper接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface ServiceItemDetailsMapper 
{
    /**
     * 查询服务项目详情
     * 
     * @param id 服务项目详情主键
     * @return 服务项目详情
     */
    public ServiceItemDetails selectServiceItemDetailsById(Long id);

    /**
     * 查询服务项目详情列表
     * 
     * @param serviceItemDetails 服务项目详情
     * @return 服务项目详情集合
     */
    public List<ServiceItemDetails> selectServiceItemDetailsList(ServiceItemDetails serviceItemDetails);

    /**
     * 新增服务项目详情
     * 
     * @param serviceItemDetails 服务项目详情
     * @return 结果
     */
    public int insertServiceItemDetails(ServiceItemDetails serviceItemDetails);

    /**
     * 修改服务项目详情
     * 
     * @param serviceItemDetails 服务项目详情
     * @return 结果
     */
    public int updateServiceItemDetails(ServiceItemDetails serviceItemDetails);

    /**
     * 删除服务项目详情
     * 
     * @param id 服务项目详情主键
     * @return 结果
     */
    public int deleteServiceItemDetailsById(Long id);

    /**
     * 批量删除服务项目详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteServiceItemDetailsByIds(Long[] ids);
}
