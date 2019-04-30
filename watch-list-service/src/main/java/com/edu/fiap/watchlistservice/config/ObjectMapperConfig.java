/*
 * Copyright 2019 Rede S.A.
 *************************************************************
 * Nome     : ObjectMapperConfig.java
 * Descrição: ObjectMapperConfig.java
 * Autor    : Fábio Pereira <fabio.fpereira@userede.com.br>
 * Data     : Mar 8, 2019
 * Empresa  : Rede
 *********************** MODIFICAÇÕES ************************
 */
package com.edu.fiap.watchlistservice.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * The Class ObjectMapperConfig.
 */
@Configuration
public class ObjectMapperConfig {
	
	/**
	 * Object mapper.
	 *
	 * @param builder the builder
	 * @return the object mapper
	 */
	@Bean
	@Autowired
	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
		ObjectMapper mapper = builder.createXmlMapper(false).build();

		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, false);
		mapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, false);
		mapper.configure(MapperFeature.IGNORE_DUPLICATE_MODULE_REGISTRATIONS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, false);
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

		return mapper;
	}
}
