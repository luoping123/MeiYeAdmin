import request from '@/utils/request'

// 查询九宫格导航列表
export function listGridCate(query) {
  return request({
    url: '/meiye/GridCate/list',
    method: 'get',
    params: query
  })
}

// 查询九宫格导航详细
export function getGridCate(id) {
  return request({
    url: '/meiye/GridCate/' + id,
    method: 'get'
  })
}

// 新增九宫格导航
export function addGridCate(data) {
  return request({
    url: '/meiye/GridCate',
    method: 'post',
    data: data
  })
}

// 修改九宫格导航
export function updateGridCate(data) {
  return request({
    url: '/meiye/GridCate',
    method: 'put',
    data: data
  })
}

// 删除九宫格导航
export function delGridCate(id) {
  return request({
    url: '/meiye/GridCate/' + id,
    method: 'delete'
  })
}
