import request from '@/utils/request'

// 发送消息
export function sendMsg(data) {
  return request({
    url: '/mq/send',
    method: 'post',
    data: data
  })
}

