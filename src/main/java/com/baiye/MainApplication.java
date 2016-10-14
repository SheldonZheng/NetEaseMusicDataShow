package com.baiye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Baiye on 2016/10/14.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MainApplication{

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}

