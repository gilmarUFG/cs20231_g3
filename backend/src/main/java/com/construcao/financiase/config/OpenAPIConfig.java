package com.construcao.financiase.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@RequiredArgsConstructor
public class OpenAPIConfig {

    private static final String BASE_PACKAGE = "com.construcao.financiase";
    private static final String API_TITLE = "Financia.se - Plataforma de Financiamento Coletivo";
    private static final String API_DESCRIPTION = "Financia.se API";
    private static final String API_VERSION = "1.0.0";
    private static final String CONTACT_NAME = "Grupo 3 - Construção de Software";
    private static final String CONTACT_URL = "https://github.com/gilmarUFG/cs20231_g3";

    @Bean
    public OpenAPI myOpenAPI() {
        /*//@Value()
        String devUrl = "${bezkoder.openapi.dev-url}";

        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");*/

        return new OpenAPI()
                .info(buildAppInfo());
    }

    private Info buildAppInfo() {

        Contact contact = new Contact();
        contact.setEmail("");
        contact.setName(CONTACT_NAME);
        contact.setUrl(CONTACT_URL);

        return new Info()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .contact(contact);
    }

}


