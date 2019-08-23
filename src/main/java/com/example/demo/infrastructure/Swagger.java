package com.example.demo.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger {
    private List<VendorExtension> vendorExtensions = new ArrayList<>();
    private Contact contact = new Contact("Name comes here", "www.java.com", "noreply@java.com");
    private ApiInfo apiInfo = new ApiInfo("Java demo", "This page documents a set of demo endpoints", "0.0.0.1", "", contact, "", "", vendorExtensions);

    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tyme"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }
}
