package com.luizleiteoliveira.nativespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class NativeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NativeSpringApplication.class, args);
	}

}

@Controller
@ResponseBody
class SimpleHttpController {

	@GetMapping("conference")
	String hello() {
		return "Hello";
	}
}
