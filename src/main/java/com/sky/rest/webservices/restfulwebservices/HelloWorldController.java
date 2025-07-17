package com.sky.rest.webservices.restfulwebservices;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @GetMapping(path = "/hello")
    public HelloWorldBean helloWorld(){
       //return "Hello World";
        return new HelloWorldBean("Good Morning");
    }
    @GetMapping(path="/hello/{name}")
    public String helloWorldPatVariable(@PathVariable String name){
        return "Good Morning "+name;
    }

    @GetMapping(path = "/hello-internalized")
    public HelloWorldBean helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        //return "Hello World";
        String msg= messageSource.getMessage("good.morning.message",null,"Defaul Message",locale);
        return new HelloWorldBean(msg);
    }
}
