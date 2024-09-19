import request from '@/utils/request'

// 查询商品分类列表
export function listGoodsCate(query) {
  return request({
    url: '/meiye/GoodsCate/list',
    method: 'get',
    params: query
  })
}

// 查询商品分类详细
export function getGoodsCate(id) {
  return request({
    url: '/meiye/GoodsCate/' + id,
    method: 'get'
  })
}

// 新增商品分类
export function addGoodsCate(data) {
  return request({
    url: '/meiye/GoodsCate',
    method: 'post',
    data: data
  })
}

// 修改商品分类
export function updateGoodsCate(data) {
  return request({
    url: '/meiye/GoodsCate',
    method: 'put',
    data: data
  })
}

// 删除商品分类
export function delGoodsCate(id) {
  return request({
    url: '/meiye/GoodsCate/' + id,
    method: 'delete'
  })
}
