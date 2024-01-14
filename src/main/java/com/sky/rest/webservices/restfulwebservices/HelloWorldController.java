package com.sky.rest.webservices.restfulwebservices;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public HelloWorldBean helloWorld(){

        return new HelloWorldBean("message");
    }
    @GetMapping(path="hello/pathVariable/{name}")
    public String helloWorldPatVariable(@PathVariable String name){
        return name+" "+"Kumar "+"Yadav";
    }
}
