import request from '@/utils/request'

// 查询通知列表
export function listNotice(query) {
  return request({
    url: '/system/notice/list',
    method: 'get',
    params: query
  })
}

// 查询通知详细
export function getNotice(id) {
  return request({
    url: '/system/notice/' + id,
    method: 'get'
  })
}

// 新增通知
export function addNotice(data) {
  return request({
    url: '/system/notice',
    method: 'post',
    data: data
  })
}

// 修改通知
export function updateNotice(data) {
  return request({
    url: '/system/notice',
    method: 'put',
    data: data
  })
}

// 删除通知
export function delNotice(id) {
  return request({
    url: '/system/notice/' + id,
    method: 'delete'
  })
}
