package com.luongdinh.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import feign.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.luongdinh.tinylazada.common.sdk" })
@ComponentScan(basePackages = { "com.luongdinh.tinylazada.common.configuration", "com.luongdinh.cartservice" })
public class CartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
	}

	@Bean
	public Logger.Level feignLogerLover() {
		return Logger.Level.FULL;
	}

}
