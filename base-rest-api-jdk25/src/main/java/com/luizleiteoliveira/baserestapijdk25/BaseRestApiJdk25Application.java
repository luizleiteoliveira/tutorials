package com.luizleiteoliveira.baserestapijdk25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BaseRestApiJdk25Application {

    public static void main(String[] args) {
        SpringApplication.run(BaseRestApiJdk25Application.class, args);
    }

}
