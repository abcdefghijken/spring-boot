package com.ken.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! -- xoxo";
    }

    @GetMapping("/math")
    public int random() {
        Random rand = new Random();

        return rand.nextInt(10);
    }
}
