package com.db.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.db.demo.props.MainApplicationProperties;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Autowired
    private MainApplicationProperties mainApplicationProperties;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(mainApplicationProperties.getApplicationName())
                        .version(getVersion()));
    }

    public String getVersion(){
        return String.format("%s", mainApplicationProperties.getApplicationVersion());
    }
}