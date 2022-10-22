package com.relationship.example.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Neeraj Techie").apiInfo(apiInfo()).select()
                .paths(regex("/order/api/v1.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Order Service")
                .description("Here we have added One to Many JPA Example")
                .termsOfServiceUrl("https://www.youtube.com/watch?v=8qhaDBCJh6I&t=6s&ab_channel=JavaTechie")
                .license("Neeraj JPA License")
                .licenseUrl("https://github.com/neerajrajak/Spring-Boot").version("1.0").build();
    }
}
