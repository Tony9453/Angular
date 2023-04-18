package com.sunspring.asfclite;

import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.Collections;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // .groupName("DemoAAA")
                .select()
                // .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.sunspring.asfclite"))
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Asfclite API")
                .description("Asfclite Api Data")
                // .termsOfServiceUrl("http://localhost:8216/hello")
                .version("1.0").build();
    }

}

