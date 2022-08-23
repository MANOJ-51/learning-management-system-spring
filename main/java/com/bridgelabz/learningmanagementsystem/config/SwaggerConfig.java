package com.bridgelabz.learningmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Purpose:Create Swagger Configuration
 * @author Manoj
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Purpose:Creating bean Method for Swagger Configuration
     * @author Manoj
     * @Param Docket
     */
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.learningmanagementsystem"))
                .build();
    }
}