package br.com.usuarios.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Usuários")
                        .version("1.0.0")
                        .description("Documentação da API de Usuários com Spring Boot + MongoDB")
                        .termsOfService("http://localhost:8080/termos")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
