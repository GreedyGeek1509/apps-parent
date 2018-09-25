package com.sriram.spring.controller;

import com.sriram.spring.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Employee getEmployeeJson(@PathVariable("name") String name) {
        Employee employee = new Employee();
        employee.setId(ThreadLocalRandom.current().nextInt());
        employee.setName(name);
        employee.setEmail(name+"@gmail.com");
        log.info("Inside getEmployeeJson with Employee : {}", employee);
        return employee;
    }


    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Employee getEmployeeXml(@PathVariable("name") String name) {
        Employee employee = new Employee();
        employee.setId(ThreadLocalRandom.current().nextInt());
        employee.setName(name);
        employee.setEmail(name+"@gmail.com");
        log.info("Inside getEmployeeXml with Employee : {}", employee);
        return employee;
    }
}
