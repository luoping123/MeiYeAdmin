import request from '@/utils/request'

// 查询商品详情列表
export function listGoodsDetails(query) {
  return request({
    url: '/meiye/GoodsDetails/list',
    method: 'get',
    params: query
  })
}

// 查询商品详情详细
export function getGoodsDetails(id) {
  return request({
    url: '/meiye/GoodsDetails/' + id,
    method: 'get'
  })
}

// 新增商品详情
export function addGoodsDetails(data) {
  return request({
    url: '/meiye/GoodsDetails',
    method: 'post',
    data: data
  })
}

// 修改商品详情
export function updateGoodsDetails(data) {
  return request({
    url: '/meiye/GoodsDetails',
    method: 'put',
    data: data
  })
}

// 删除商品详情
export function delGoodsDetails(id) {
  return request({
    url: '/meiye/GoodsDetails/' + id,
    method: 'delete'
  })
}
