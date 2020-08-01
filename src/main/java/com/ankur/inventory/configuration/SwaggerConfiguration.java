package com.ankur.inventory.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Inventory Management Microservice")
                .description("This service provides CRUD operations for Inventory Management.")
                .license("Ankur Israni")
                .termsOfServiceUrl("http://www.4algos.com")
                .version("0.0.1")
                .contact(new Contact("Ankur Israni","http://www.4algos.com", "onlyankur@gmail.com"))
                .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Inventory Management Microservice")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ankur"))
                .build()
                .apiInfo(apiInfo());
    }

}

