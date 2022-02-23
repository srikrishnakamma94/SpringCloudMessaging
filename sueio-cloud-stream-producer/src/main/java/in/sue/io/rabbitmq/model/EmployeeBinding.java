package in.sue.io.rabbitmq.model;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeBinding {

    @Output("empChanel")
    MessageChannel publishMessage();

}
