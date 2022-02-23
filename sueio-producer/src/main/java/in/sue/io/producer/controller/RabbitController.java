package in.sue.io.producer.controller;

import in.sue.io.producer.model.Employee;
import in.sue.io.producer.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sueio")
public class RabbitController {

    @Autowired
    RabbitService rabbitService;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        rabbitService.send(emp);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
