package com.mastersystem.mcmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
public class McmanagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(McmanagerApplication.class, args);
		System.out.println("Projeto Rodando");
	}

}
