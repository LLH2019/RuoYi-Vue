package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.mq.KafkaMessage;
import com.ruoyi.common.mq.KafkaMsgProducer;
import com.ruoyi.system.domain.MdResourceMq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：LLH
 * @date ：Created in 2022/2/28 8:35
 * @description：制造排期Controller
 */

@RestController
@RequestMapping("/mq/send")
public class ProductScheduleController {


    @Autowired
    private KafkaMsgProducer kafkaMsgProducer;

    /**
     * 发送消息
     */
    @PreAuthorize("@ss.hasPermi('mq:send:add')")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping
    public void add(@RequestBody MdResourceMq mdResourceMq)
    {
        System.out.println("333333333333333" + mdResourceMq);
//        KafkaMessage msg = new KafkaMessage("cloud.test", "111", "222");
        KafkaMessage msg = new KafkaMessage();
        if ("start".equals(mdResourceMq.getState())) {
            msg.setTopic("cloud.re");
            msg.setKey(mdResourceMq.getResourceid());
            msg.setValue("制造开始");
        } else if ("suspend".equals(mdResourceMq.getState())) {
            msg.setTopic("cloud.re");
            msg.setKey(mdResourceMq.getResourceid());
            msg.setValue("制造挂起");
        } else if ("continue".equals(mdResourceMq.getState())) {
            msg.setTopic("cloud.re");
            msg.setKey(mdResourceMq.getResourceid());
            msg.setValue("制造继续");
        } else if ("end".equals(mdResourceMq.getState())) {
            msg.setTopic("cloud.re");
            msg.setKey(mdResourceMq.getResourceid());
            msg.setValue("制造结束");
        } else if (mdResourceMq.getConnect()){
            msg.setTopic("cloud.init.resource");
            msg.setKey("resource");
            msg.setValue(mdResourceMq.getResourceid());
        } else if (!mdResourceMq.getConnect()){
            msg.setTopic("cloud.dis.resource");
            msg.setKey("resource");
            msg.setValue(mdResourceMq.getResourceid());
        }
        System.out.println("00000000000 " + msg);
        kafkaMsgProducer.sendKafkaMsg(msg);
//        return toAjax(enterpriseService.insertEnterprise(enterprise));
    }
}
