package in.sue.io.rabbitmq.model;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface EmployeeBinding {

    String inputChanel = "empChanel";

    @Input(inputChanel)
    MessageChannel publishMessage();

}
