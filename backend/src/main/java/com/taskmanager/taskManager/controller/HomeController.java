package com.taskmanager.taskManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @RequestMapping("/")
    public String greet()
    {
        return "welcome ";
    }

    @RequestMapping("/about")
    public String about()
    {
        return "We learn..";
    }
}
