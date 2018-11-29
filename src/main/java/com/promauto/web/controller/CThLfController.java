package com.promauto.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Belyaev Alexei (lebllex) on 29.11.18.
 */
@Controller
public class CThLfController {
    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
}
