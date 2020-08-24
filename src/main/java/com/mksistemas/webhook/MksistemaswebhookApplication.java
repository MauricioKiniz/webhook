package com.mksistemas.webhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.mksistemas", "com.mksistemas.webhook"})
public class MksistemaswebhookApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MksistemaswebhookApplication.class, args);
//		IRegistrarEmpresa registrarEmpresa = context.getBean(IRegistrarEmpresa.class);
	}

}
