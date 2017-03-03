package io.naren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TodoListApplication extends SpringBootServletInitializer{
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(TodoListApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}
}
