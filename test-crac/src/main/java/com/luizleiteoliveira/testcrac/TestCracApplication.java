package com.luizleiteoliveira.testcrac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class TestCracApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestCracApplication.class, args);
	}

}

@Service
class HelloService {

	static {
		System.out.println(".... This is a start from the service ...");
		try {
			Thread.sleep(2000);
			System.out.println(".... Finish the service start ...");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	String hello(String name) {
		return "Hello " + name;
	}

}


@Controller
@ResponseBody
class HttpController {

	private final HelloService service;

	HttpController(HelloService helloService) {
		this.service = helloService;
	}

	@GetMapping("/")
	String sayHelloToSomeone(@RequestParam String name) {
		return service.hello(name);
	}

}



