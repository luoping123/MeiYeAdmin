import request from '@/utils/request'

// 查询轮播图列表
export function listSwiper(query) {
  return request({
    url: '/meiye/swiper/list',
    method: 'get',
    params: query
  })
}

// 查询轮播图详细
export function getSwiper(id) {
  return request({
    url: '/meiye/swiper/' + id,
    method: 'get'
  })
}

// 新增轮播图
export function addSwiper(data) {
  return request({
    url: '/meiye/swiper',
    method: 'post',
    data: data
  })
}

// 修改轮播图
export function updateSwiper(data) {
  return request({
    url: '/meiye/swiper',
    method: 'put',
    data: data
  })
}

// 删除轮播图
export function delSwiper(id) {
  return request({
    url: '/meiye/swiper/' + id,
    method: 'delete'
  })
}
