package com.promauto.wes.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.spring3.view.ThymeleafView;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Belyaev Alexei (lebllex) on 29.11.18.
 */
@Slf4j
@RestController
@RequestMapping("/")
public class CHomeController {
    @GetMapping
    public ThymeleafView emitHelloHome(){
        log.info("emitting view");
        ThymeleafView view = new ThymeleafView("templates/maintemplate");
        log.info("view created");
        view.setStaticVariables(Collections.singletonMap("planets", Arrays.asList("neptun","pluton")));
        return view;
    }
}
