package com.example.blogapplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Blog Application",
                version = "1.0",
                description = "Spring Boot Blog Application Rest Api Documentation",
                contact = @Contact(
                        name = "Nirosha",
                        email = "niroshar14@gmail.com"
        )

) ,
//http://localhost:8080/v3/api-docs
// http://localhost:8080/swagger-ui/index.html to see the swagger ui

        externalDocs = @ExternalDocumentation(
                description = "Spring Boot Blog Application",
                url = "https://github.com/Nirosha-Rayee/BlogApplication"
        )
)
public class BlogApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
