import request from '@/utils/request'

// 查询制造资源Agent配置列表
export function listConfig(query) {
  return request({
    url: '/agent/config/list',
    method: 'get',
    params: query
  })
}

// 查询制造资源Agent配置详细
export function getConfig(id) {
  return request({
    url: '/agent/config/' + id,
    method: 'get'
  })
}

// 新增制造资源Agent配置
export function addConfig(data) {
  return request({  
    url: '/agent/config',
    method: 'post',
    data: data
  })
}

// 修改制造资源Agent配置
export function updateConfig(data) {
  return request({
    url: '/agent/config',
    method: 'put',
    data: data
  })
}

// 删除制造资源Agent配置
export function delConfig(id) {
  return request({
    url: '/agent/config/' + id,
    method: 'delete'
  })
}
