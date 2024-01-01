package com.ken.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm() {

        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {

        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest httpServletRequest, Model model) {
        String name = httpServletRequest.getParameter("studentName");
        name = name.toUpperCase(Locale.ROOT);
        name = "Yo " + name;

        model.addAttribute("message", name);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
        theName = theName.toUpperCase(Locale.ROOT);
        theName = "Yo V3 " + theName;

        model.addAttribute("message", theName);

        return "helloworld";
    }
}
