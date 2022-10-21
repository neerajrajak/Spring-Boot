package com.mongo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class MongoJpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoJpaExampleApplication.class, args);
	}
	
	/* .pathMapping("/") can resolve the conflict between actuator and springfox */
	 @Bean
	 public Docket api() {
	     return new Docket(DocumentationType.SWAGGER_2)
	         .select()
	         .apis(RequestHandlerSelectors.any())
	         .paths(PathSelectors.any())
	         .build()
	         .pathMapping("/");
	 }
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("User Orders")
				.description("Sample Documentation Generateed Using SWAGGER2 for our User Product API")
				.termsOfServiceUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
				.license("Java_Gyan_Mantra License")
				.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.0").build();
	}

}
