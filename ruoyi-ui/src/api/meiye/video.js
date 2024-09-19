import request from '@/utils/request'

// 查询视频列表
export function listVideo(query) {
  return request({
    url: '/meiye/video/list',
    method: 'get',
    params: query
  })
}

// 查询视频详细
export function getVideo(id) {
  return request({
    url: '/meiye/video/' + id,
    method: 'get'
  })
}

// 新增视频
export function addVideo(data) {
  return request({
    url: '/meiye/video',
    method: 'post',
    data: data
  })
}

// 修改视频
export function updateVideo(data) {
  return request({
    url: '/meiye/video',
    method: 'put',
    data: data
  })
}

// 删除视频
export function delVideo(id) {
  return request({
    url: '/meiye/video/' + id,
    method: 'delete'
  })
}
