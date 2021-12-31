package com.lyess.network_device_inventory.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-31 10:37 a.m.
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(@Value("${application.title}") String appTitle,
                                 @Value("${application.description}") String appDescription,
                                 @Value("${application.version}") String appVersion) {

        return new OpenAPI()
                .info(new Info()//
                        .title(appTitle)//
                        .description(appDescription)//
                        .version(appVersion)//
                        .license(new License()//
                                .name("MIT")//
                                .url("https://github.com/lyes-s/network-device-inventory/blob/master/LICENSE.md"))
                        .contact(new Contact()//
                                .name("Lyes S.")//
                                .url("https://github.com/lyes-s")//
                                .email("lyes-s@gmail.com")))
                .externalDocs(new ExternalDocumentation()//
                        .description("GitHub Wiki")//
                        .url("https://github.com/lyes-s/network-device-inventory/wiki"));

    }

}
