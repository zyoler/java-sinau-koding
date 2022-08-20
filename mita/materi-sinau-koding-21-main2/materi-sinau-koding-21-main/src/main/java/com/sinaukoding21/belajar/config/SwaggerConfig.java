package com.sinaukoding21.belajar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.sinaukoding21.belajar"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Sinau Koding",
                "Api Documentation Sinau Koding 21 Tugas-8",
                "1.8",
                "Term of Service",
                new Contact("Sinau Koding", "https://sinaukoding.com","sinaukoding@org.id"),
                "",
                "",
                new ArrayList<>()
        );
    }
}
