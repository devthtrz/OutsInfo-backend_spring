package com.promauto.wes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Belyaev Alexei (lebllex) on 29.11.18.
 */
@Slf4j
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        log.info("App starting","App");
        SpringApplication.run(App.class,args);
    }
}
