package com.example.share.demo.infrastructure.config;

import static java.util.Collections.singletonList;


import com.google.common.collect.Sets;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Japhy
 * @since 2021/1/10 09:35
 */
@Configuration
//@Profile("swagger")
public class SwaggerConfig {

    @Bean
    public Docket createUserApi() {
        return new Docket(DocumentationType.OAS_30)
            .groupName("user-api")
            .apiInfo(apiInfo())
            .produces(Sets.newHashSet("application/json"))
            .protocols(Sets.newHashSet("http"))
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Web Base API").description("this is the base api")
            .termsOfServiceUrl("www.web-base.com")
            .contact(new Contact("Japhy", "", "japhy.fan@gmail.ocm"))
            .license("Apache License Version 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
            .version("2.0")
            .build();
    }


    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
            = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(
            new SecurityReference("Authorization", authorizationScopes));
    }
}
