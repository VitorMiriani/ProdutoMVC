package br.com.fiap.appproduto.produto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
@Configuration
public class SpringConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
}
