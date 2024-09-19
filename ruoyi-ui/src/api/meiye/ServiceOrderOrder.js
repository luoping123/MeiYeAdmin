import request from '@/utils/request'

// 查询服务项目订单列表
export function listServiceOrderOrder(query) {
  return request({
    url: '/meiye/ServiceOrderOrder/list',
    method: 'get',
    params: query
  })
}

// 查询服务项目订单详细
export function getServiceOrderOrder(orderId) {
  return request({
    url: '/meiye/ServiceOrderOrder/' + orderId,
    method: 'get'
  })
}

// 新增服务项目订单
export function addServiceOrderOrder(data) {
  return request({
    url: '/meiye/ServiceOrderOrder',
    method: 'post',
    data: data
  })
}

// 修改服务项目订单
export function updateServiceOrderOrder(data) {
  return request({
    url: '/meiye/ServiceOrderOrder',
    method: 'put',
    data: data
  })
}

// 删除服务项目订单
export function delServiceOrderOrder(orderId) {
  return request({
    url: '/meiye/ServiceOrderOrder/' + orderId,
    method: 'delete'
  })
}
