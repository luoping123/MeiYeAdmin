import request from '@/utils/request'

// 查询服务项目分类列表
export function listServiceItemCate(query) {
  return request({
    url: '/meiye/ServiceItemCate/list',
    method: 'get',
    params: query
  })
}

// 查询服务项目分类详细
export function getServiceItemCate(id) {
  return request({
    url: '/meiye/ServiceItemCate/' + id,
    method: 'get'
  })
}

// 新增服务项目分类
export function addServiceItemCate(data) {
  return request({
    url: '/meiye/ServiceItemCate',
    method: 'post',
    data: data
  })
}

// 修改服务项目分类
export function updateServiceItemCate(data) {
  return request({
    url: '/meiye/ServiceItemCate',
    method: 'put',
    data: data
  })
}

// 删除服务项目分类
export function delServiceItemCate(id) {
  return request({
    url: '/meiye/ServiceItemCate/' + id,
    method: 'delete'
  })
}
