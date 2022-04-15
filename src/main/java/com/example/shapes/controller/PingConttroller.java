package com.example.shapes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PingConttroller {
    @RequestMapping(value = "/ping")
    public static String welcome() {
        return "ok";
    }

}
