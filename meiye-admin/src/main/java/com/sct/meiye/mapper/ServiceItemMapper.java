package com.sct.meiye.mapper;

import java.util.List;
import com.sct.meiye.domain.ServiceItem;
import com.sct.meiye.domain.ServiceItemAndCate;
import com.sct.meiye.domain.ServiceItemAndDetail;

/**
 * 服务项目Mapper接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface ServiceItemMapper 
{
    /**
     * 查询服务项目
     * 
     * @param id 服务项目主键
     * @return 服务项目
     */
    public ServiceItemAndDetail selectServiceItemById(Long id);

    /**
     * 查询服务项目列表
     * 
     * @param serviceItem 服务项目
     * @return 服务项目集合
     */
    public List<ServiceItemAndCate> selectServiceItemList(ServiceItem serviceItem);

    /**
     * 新增服务项目
     * 
     * @param serviceItem 服务项目
     * @return 结果
     */
    public int insertServiceItem(ServiceItem serviceItem);

    /**
     * 修改服务项目
     * 
     * @param serviceItem 服务项目
     * @return 结果
     */
    public int updateServiceItem(ServiceItem serviceItem);

    /**
     * 删除服务项目
     * 
     * @param id 服务项目主键
     * @return 结果
     */
    public int deleteServiceItemById(Long id);

    /**
     * 批量删除服务项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteServiceItemByIds(Long[] ids);
}
