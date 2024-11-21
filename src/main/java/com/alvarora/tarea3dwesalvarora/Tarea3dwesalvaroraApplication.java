package com.alvarora.tarea3dwesalvarora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Tarea3dwesalvaroraApplication {

	@Bean
	public Principal applicationStartupRunner(){
		return new Principal();
	}

	public static void main(String[] args) {
		SpringApplication.run(Tarea3dwesalvaroraApplication.class, args);
	}

}
