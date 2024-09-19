import request from '@/utils/request'

// 查询美容师时间列表
export function listBeauticianTime(query) {
  return request({
    url: '/meiye/BeauticianTime/list',
    method: 'get',
    params: query
  })
}

// 查询美容师时间详细
export function getBeauticianTime(id) {
  return request({
    url: '/meiye/BeauticianTime/' + id,
    method: 'get'
  })
}

// 新增美容师时间
export function addBeauticianTime(data) {
  return request({
    url: '/meiye/BeauticianTime',
    method: 'post',
    data: data
  })
}

// 修改美容师时间
export function updateBeauticianTime(data) {
  return request({
    url: '/meiye/BeauticianTime',
    method: 'put',
    data: data
  })
}

// 删除美容师时间
export function delBeauticianTime(id) {
  return request({
    url: '/meiye/BeauticianTime/' + id,
    method: 'delete'
  })
}
