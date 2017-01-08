package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TomatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomatoApplication.class, args);
	}

	@Controller
	public class TomatoController {

		@GetMapping("/tomatoes")
		@ResponseBody
		public List<String> listTomatoes() {
			return Arrays.asList("Red tomato", "Green tomato");
		}

	}

}


