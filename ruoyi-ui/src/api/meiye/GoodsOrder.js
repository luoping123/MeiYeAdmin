import request from '@/utils/request'

// 查询商品订单列表
export function listGoodsOrder(query) {
  return request({
    url: '/meiye/GoodsOrder/list',
    method: 'get',
    params: query
  })
}

// 查询商品订单详细
export function getGoodsOrder(id) {
  return request({
    url: '/meiye/GoodsOrder/' + id,
    method: 'get'
  })
}

// 新增商品订单
export function addGoodsOrder(data) {
  return request({
    url: '/meiye/GoodsOrder',
    method: 'post',
    data: data
  })
}

// 修改商品订单
export function updateGoodsOrder(data) {
  return request({
    url: '/meiye/GoodsOrder',
    method: 'put',
    data: data
  })
}

// 删除商品订单
export function delGoodsOrder(id) {
  return request({
    url: '/meiye/GoodsOrder/' + id,
    method: 'delete'
  })
}
