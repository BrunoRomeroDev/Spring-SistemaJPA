package br.com.JPA.Swagger;


import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
	
	 private ApiInfo apiInfo() {
		 return new ApiInfo("Api Sistema de Processos",
				 			"Api sistema processos",
				 			"1.0",
				 			null, 
				 			new springfox.documentation.service.Contact("Sistemas", null, "teste@teste.sp.gov.br"), 
				 			"", 
				 			"", 
				 			Collections.emptyList());
				}
	 
	@Bean
	public Docket docket() {
		return new  Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/**"))
				.build();
	}
}