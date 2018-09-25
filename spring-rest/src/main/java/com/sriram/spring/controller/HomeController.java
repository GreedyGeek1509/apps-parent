package com.sriram.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping
    public String index() {
        log.info("Inside HomeController");
        return "home";
    }
}
