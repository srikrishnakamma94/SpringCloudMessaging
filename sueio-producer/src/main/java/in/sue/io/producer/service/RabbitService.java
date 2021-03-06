package in.sue.io.producer.service;

import in.sue.io.producer.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitService {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    String kafkaTopic = "java_in_use_topic";

    public void send(Employee company) {
        amqpTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);
    }
}
