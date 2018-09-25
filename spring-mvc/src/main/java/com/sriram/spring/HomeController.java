package com.sriram.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author guduri.sriram
 */
@Slf4j
@Controller
public class HomeController {

    /**
     * Simply selects the home view to render by returning its name.
     */
    @GetMapping(value = "/")
    public String home(Locale locale, Model model) {
        log.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );
        model.addAttribute("timestamp", String.valueOf(System.currentTimeMillis()) );

        return "home";
    }

    @GetMapping(value = "/login")
    public String loginPage(Locale locale, Model model) {
        return "login";
    }

    @PostMapping(value = "/home")
    public String login(@Validated User user, Model model) {
        log.info("Inside Home with User : {}", user);
        model.addAttribute("userName", user.getUserName());
        return "user";
    }
}

