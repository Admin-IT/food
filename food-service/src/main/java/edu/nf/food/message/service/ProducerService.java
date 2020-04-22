package edu.nf.food.message.service;

import edu.nf.food.label.entity.Technology;
import edu.nf.food.message.service.config.RabbitConfig;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author ljf
 * @date 2020/4/21
 * 发送消息
 */
@Service
public class ProducerService {


    /**
     * 注入RabbitTemplate
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送对象，使用自定义消息转换器转换为json
     *
     * @param
     */
    public void sendObject(Technology technology) {
        //创建消息的唯一ID
        CorrelationData correlationData = new CorrelationData();
        //这里使用订单ID作为消息的ID
        correlationData.setId(technology.getTechnologyId().toString());
        //发送消息
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "order.message", technology, correlationData);
    }

    /**
     * 发送文本消息
     *
     * @param message
     */
    public void sendMessage(String message) {
        //创建消息的唯一ID
        CorrelationData correlationData = new CorrelationData();
        //这里使用订单ID作为消息的ID
        correlationData.setId(UUID.randomUUID().toString());
        //发送消息
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "order.message", message, correlationData);
    }
}
