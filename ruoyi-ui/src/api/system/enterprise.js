import request from '@/utils/request'

// 查询企业列表
export function listEnterprise(query) {
  return request({
    url: '/enterprise/info/list',
    method: 'get',
    params: query
  })
}

// 查询企业详细
export function getEnterprise(id) {
  return request({
    url: '/enterprise/info/' + id,
    method: 'get'
  })
}

// 新增企业
export function addEnterprise(data) {
  return request({
    url: '/enterprise/info',
    method: 'post',
    data: data
  })
}

// 修改企业
export function updateEnterprise(data) {
  return request({
    url: '/enterprise/info',
    method: 'put',
    data: data
  })
}

// 删除企业
export function delEnterprise(id) {
  return request({
    url: '/enterprise/info/' + id,
    method: 'delete'
  })
}
