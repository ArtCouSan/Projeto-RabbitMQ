package br.com.microservice_b.endpoint.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigRabbitMQ {

    public static final String EXCHANGE_NAME = "drone-exchange";
    public static final String QUEUE_LIST = "drone-list";
    public static final String QUEUE_DATA = "drone-data";

    @Bean
    Queue createQueueList() {
        return new Queue(QUEUE_LIST, false);
    }

    @Bean
    Queue createQueueData() {
        return new Queue(QUEUE_DATA, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding bindingDroneList() {
        return BindingBuilder.bind(createQueueList()).to(exchange()).with("drone.list");
    }

    @Bean
    Binding bindingDroneData() {
        return BindingBuilder.bind(createQueueData()).to(exchange()).with("drone.data");
    }

}
