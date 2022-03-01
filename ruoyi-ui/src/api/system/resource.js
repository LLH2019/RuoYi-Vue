import request from '@/utils/request'

// 查询制造资源列表
export function listResource(query) {
  return request({
    url: '/system/resource/list',
    method: 'get',
    params: query
  })
}

// 查询制造资源详细
export function getResource(id) {
  return request({
    url: '/system/resource/' + id,
    method: 'get'
  })
}

// 新增制造资源
export function addResource(data) {
  return request({
    url: '/system/resource',
    method: 'post',
    data: data
  })
}

// 修改制造资源
export function updateResource(data) {
  return request({
    url: '/system/resource',
    method: 'put',
    data: data
  })
}

// 删除制造资源
export function delResource(id) {
  return request({
    url: '/system/resource/' + id,
    method: 'delete'
  })
}
