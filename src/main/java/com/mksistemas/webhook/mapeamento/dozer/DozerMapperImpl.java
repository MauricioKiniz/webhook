package com.mksistemas.webhook.mapeamento.dozer;

import java.util.UUID;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;

import br.com.mksistemas.base.mapeamento.IMapper;

public class DozerMapperImpl implements IMapper {

	private DozerBeanMapper mapper;
	
	public DozerMapperImpl() {
		mapper = new DozerBeanMapper();
		
		BeanMappingBuilder builder = new BeanMappingBuilder() {
            protected void configure() {
                mapping(UUID.class, UUID.class, TypeMappingOptions.oneWay(), 
                		TypeMappingOptions.beanFactory(UuidBeanFactory.class.getName()));
                	
            }
        };
        mapper.addMapping(builder);
	}
	
	@Override
	public <T> T map(Object source, Class<T> dest) {
		return mapper.map(source, dest);
	}

	@Override
	public void map(Object source, Object dest) {
		mapper.map(source, dest);
	}
}
