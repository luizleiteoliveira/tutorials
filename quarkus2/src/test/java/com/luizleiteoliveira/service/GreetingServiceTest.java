package com.luizleiteoliveira.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    public void testSayHello() {
        String name = "Luiz";
        assertEquals("Hello Luiz", greetingService.sayHelloForSomeone(name));
    }

    @Test
    public void testSayBye() {
        String name = "Luiz";
        assertEquals(greetingService.sayByeForSomeone(name),"Bye Luiz");
    }

}