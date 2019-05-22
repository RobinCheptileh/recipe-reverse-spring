package com.cognition.recipereverse.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/recipes.*"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("Recipe Reverse Spring API")
                .description("Recipe Reverse allows you to find a popular recipe by specifying the ingredients you have.")
                .contact(new Contact(
                        "Robin Cheptileh",
                        "https://github.com/RobinCheptileh",
                        "robincheptileh@cognition.co.ke"
                ))
                .license("MIT")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .version("1.0.0")
                .build();
    }
}
