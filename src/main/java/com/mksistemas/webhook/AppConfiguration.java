package com.mksistemas.webhook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.mksistemas.webhook.mapeamento.dozer.DozerMapperImpl;

import br.com.mksistemas.base.mapeamento.IMapper;

@Configuration
public class AppConfiguration {

	@Bean
	@Scope("singleton")
	public IMapper getMapper() {
		return new DozerMapperImpl();
	}
}
