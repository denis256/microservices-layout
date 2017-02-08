package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class TomatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomatoApplication.class, args);
	}

	@Controller
	public class TomatoController {

		@Autowired
		private HttpServletRequest httpRequest;

		@GetMapping("/tomatoes")
		@ResponseBody
		public List<String> listTomatoes() {
			System.out.println("headers : " + httpRequest.getHeaderNames());
			Enumeration<String> headerNames = httpRequest.getHeaderNames();
			while(headerNames.hasMoreElements()) {
				String element = headerNames.nextElement();
				System.out.println( element +" " +  httpRequest.getHeader(element));
			}

			return Arrays.asList("Red tomato", "Green tomato");
		}

	}

}


