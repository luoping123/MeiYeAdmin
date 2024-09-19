import request from '@/utils/request'

// 查询服务项目详情列表
export function listServiceItemDetails(query) {
  return request({
    url: '/meiye/ServiceItemDetails/list',
    method: 'get',
    params: query
  })
}

// 查询服务项目详情详细
export function getServiceItemDetails(id) {
  return request({
    url: '/meiye/ServiceItemDetails/' + id,
    method: 'get'
  })
}

// 新增服务项目详情
export function addServiceItemDetails(data) {
  return request({
    url: '/meiye/ServiceItemDetails',
    method: 'post',
    data: data
  })
}

// 修改服务项目详情
export function updateServiceItemDetails(data) {
  return request({
    url: '/meiye/ServiceItemDetails',
    method: 'put',
    data: data
  })
}

// 删除服务项目详情
export function delServiceItemDetails(id) {
  return request({
    url: '/meiye/ServiceItemDetails/' + id,
    method: 'delete'
  })
}
