import request from '@/utils/request'

// 查询美容师列表
export function listBeautician(query) {
  return request({
    url: '/order/beautician/list',
    method: 'get',
    params: query
  })
}

// 查询美容师详细
export function getBeautician(id) {
  return request({
    url: '/order/beautician/' + id,
    method: 'get'
  })
}

// 新增美容师
export function addBeautician(data) {
  return request({
    url: '/order/beautician',
    method: 'post',
    data: data
  })
}

// 修改美容师
export function updateBeautician(data) {
  return request({
    url: '/order/beautician',
    method: 'put',
    data: data
  })
}

// 删除美容师
export function delBeautician(id) {
  return request({
    url: '/order/beautician/' + id,
    method: 'delete'
  })
}
