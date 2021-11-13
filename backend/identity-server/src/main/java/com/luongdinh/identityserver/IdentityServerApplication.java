package com.luongdinh.identityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = { "com.luongdinh.tinylazada.common.configuration", "com.luongdinh.identityserver" })
@EnableJpaAuditing
public class IdentityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityServerApplication.class, args);
	}

}
