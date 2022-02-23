package in.sue.io.rabbitmq;

import in.sue.io.rabbitmq.model.EmployeeBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    MessageChannel messageChannel;

    public EmployeeController(EmployeeBinding employeeBinding) {
        messageChannel = employeeBinding.publishMessage();
    }

    @GetMapping("/publish/{msg}")
    public void publish(@PathVariable String msg) {
        this.messageChannel.send(MessageBuilder.withPayload(msg).build());
    }

}
