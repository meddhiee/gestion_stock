package com.dhia.gestiondestock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {//C'est une méthode publique qui retourne un objet de type Docket.
        // Docket est une classe fournie par Swagger pour configurer la génération de la documentation de l'API.
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Gestion de stock API documentation")
                                .title("Gestion de stock REST API")
                                .build()
                )
                .groupName("REST API V1")
                //commence la configuration des règles de sélection des endpoints à documenter.
                .select()
                //Cela spécifie que seuls les endpoints situés dans le package "com.dhia.gestiondestock" seront documentés.
                .apis(RequestHandlerSelectors.basePackage("com.dhia.gestiondestock"))
                //Cela spécifie que tous les endpoints seront inclus dans la documentation sans filtre.
                .paths(PathSelectors.any())
                .build();
    }

}
