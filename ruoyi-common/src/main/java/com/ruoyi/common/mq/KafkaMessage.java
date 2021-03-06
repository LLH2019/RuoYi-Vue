package com.ruoyi.common.mq;

/**
 * @author ：LLH
 * @date ：Created in 2022/2/28 10:19
 * @description：kafka消息
 */
public class KafkaMessage {
    private String topic;
    private String key;
    private String value;

    public KafkaMessage(){

    }

    public KafkaMessage(String topic, String key, String value) {
        this.topic = topic;
        this.key = key;
        this.value = value;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "topic='" + topic + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
