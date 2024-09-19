import request from '@/utils/request'

// 查询滚动通知列表
export function listNotice(query) {
  return request({
    url: '/meiye/notice/list',
    method: 'get',
    params: query
  })
}

// 查询滚动通知详细
export function getNotice(id) {
  return request({
    url: '/meiye/notice/' + id,
    method: 'get'
  })
}

// 新增滚动通知
export function addNotice(data) {
  return request({
    url: '/meiye/notice',
    method: 'post',
    data: data
  })
}

// 修改滚动通知
export function updateNotice(data) {
  return request({
    url: '/meiye/notice',
    method: 'put',
    data: data
  })
}

// 删除滚动通知
export function delNotice(id) {
  return request({
    url: '/meiye/notice/' + id,
    method: 'delete'
  })
}
