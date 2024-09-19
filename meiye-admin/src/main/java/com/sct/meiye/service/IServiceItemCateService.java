package com.sct.meiye.service;

import java.util.List;
import com.sct.meiye.domain.ServiceItemCate;

/**
 * 服务项目分类Service接口
 * 
 * @author sct
 * @date 2022-05-18
 */
public interface IServiceItemCateService 
{
    /**
     * 查询服务项目分类
     * 
     * @param id 服务项目分类主键
     * @return 服务项目分类
     */
    public ServiceItemCate selectServiceItemCateById(Long id);

    /**
     * 查询服务项目分类列表
     * 
     * @param serviceItemCate 服务项目分类
     * @return 服务项目分类集合
     */
    public List<ServiceItemCate> selectServiceItemCateList(ServiceItemCate serviceItemCate);

    /**
     * 新增服务项目分类
     * 
     * @param serviceItemCate 服务项目分类
     * @return 结果
     */
    public int insertServiceItemCate(ServiceItemCate serviceItemCate);

    /**
     * 修改服务项目分类
     * 
     * @param serviceItemCate 服务项目分类
     * @return 结果
     */
    public int updateServiceItemCate(ServiceItemCate serviceItemCate);

    /**
     * 批量删除服务项目分类
     * 
     * @param ids 需要删除的服务项目分类主键集合
     * @return 结果
     */
    public int deleteServiceItemCateByIds(Long[] ids);

    /**
     * 删除服务项目分类信息
     * 
     * @param id 服务项目分类主键
     * @return 结果
     */
    public int deleteServiceItemCateById(Long id);
}
