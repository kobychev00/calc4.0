package com.example.calculator40;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping(path="/start")
    public String welcome() {
        return "welcome to calculator";
    }

}
