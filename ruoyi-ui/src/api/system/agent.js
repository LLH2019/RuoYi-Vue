import request from '@/utils/request'

// 查询制造资源Agent列表
export function listAgent(query) {
  return request({
    url: '/system/agent/list',
    method: 'get',
    params: query
  })
}

// 查询制造资源Agent详细
export function getAgent(id) {
  return request({
    url: '/system/agent/' + id,
    method: 'get'
  })
}

// 新增制造资源Agent
export function addAgent(data) {
  return request({
    url: '/system/agent',
    method: 'post',
    data: data
  })
}

// 修改制造资源Agent
export function updateAgent(data) {
  return request({
    url: '/system/agent',
    method: 'put',
    data: data
  })
}

// 删除制造资源Agent
export function delAgent(id) {
  return request({
    url: '/system/agent/' + id,
    method: 'delete'
  })
}
