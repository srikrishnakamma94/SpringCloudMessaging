package in.sue.io.rabbitmq.listner;

import in.sue.io.rabbitmq.model.EmployeeBinding;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(EmployeeBinding.class)
public class EmployeeListener {

    @StreamListener(target = EmployeeBinding.inputChanel)
    public void processEmpNameChanel(String msg) {
        System.out.println(msg);
    }
}
