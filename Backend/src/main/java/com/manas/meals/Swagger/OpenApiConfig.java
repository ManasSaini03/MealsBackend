package com.manas.meals.Swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI mealExplorerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Manas Meals Explorer API")
                        .description("Backend API for TheMealDB Explorer")
                        .version("1.0"));
    }
}
