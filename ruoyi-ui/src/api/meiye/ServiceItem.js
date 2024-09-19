import request from '@/utils/request'

// 查询服务项目列表
export function listServiceItem(query) {
  return request({
    url: '/meiye/ServiceItem/list',
    method: 'get',
    params: query
  })
}

// 查询服务项目详细
export function getServiceItem(id) {
  return request({
    url: '/meiye/ServiceItem/' + id,
    method: 'get'
  })
}

// 新增服务项目
export function addServiceItem(data) {
  return request({
    url: '/meiye/ServiceItem',
    method: 'post',
    data: data
  })
}

// 修改服务项目
export function updateServiceItem(data) {
  return request({
    url: '/meiye/ServiceItem',
    method: 'put',
    data: data
  })
}

// 删除服务项目
export function delServiceItem(id) {
  return request({
    url: '/meiye/ServiceItem/' + id,
    method: 'delete'
  })
}
