package com.luizleiteoliveira.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {



    public String sayHelloForSomeone(String name) {
        return "Hello " + name;
    }

    public String sayByeForSomeone(String name) {
        return "Bye "+ name;
    }

}
