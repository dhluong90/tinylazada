package com.luongdinh.identityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.luongdinh.tinylazada.common.configuration", "com.luongdinh.identityserver" })
public class IdentityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityServerApplication.class, args);
	}

}
