import request from '@/utils/request'

// 查询美容师列表
export function listBeautician(query) {
  return request({
    url: '/meiye/Beautician/list',
    method: 'get',
    params: query
  })
}

// 查询美容师详细
export function getBeautician(id) {
  return request({
    url: '/meiye/Beautician/beautician' + id,
    method: 'get'
  })
}

// 查询美容师排班列表
export function listBeauticianAndTime(query) {
  return request({
    url: '/meiye/Beautician/timeList',
    method: 'get',
    params: query
  })
}


// 查询美容师排班详细    
export function getBeauticianAndTime(timeId) {
  return request({
    url: '/meiye/Beautician/beauticianAndTime' + timeId,
    method: 'get'
  })
}

// 新增美容师
export function addBeautician(data) {
  return request({
    url: '/meiye/Beautician',
    method: 'post',
    data: data
  })
}

// 修改美容师
export function updateBeautician(data) {
  return request({
    url: '/meiye/Beautician',
    method: 'put',
    data: data
  })
}

// 删除美容师
export function delBeautician(id) {
  return request({
    url: '/meiye/Beautician/' + id,
    method: 'delete'
  })
}
