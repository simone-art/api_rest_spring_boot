package com.produtos.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
//================ Swagger ====================//
//O Swagger funciona como o Postman
// só que ele mostra uma Api online navegable onde você
//Pode testar os métodos da Api
//================ Swagger ====================//


@Configuration //Esta anotação da a entender ao Spring que esta classe é uma configuração
@EnableSwagger2
public class SwaggerConfig {


    //Método tipo Docket, por isso foi usado o @Bean
    //O Dpcket é uma classe externa de aplicação que funciona ao adicionar as dependências swagger no pom
    //("com.produtos.apirest")) este é o pacote que tem todas as classes Java
    //Path regex é o caminho pra accesar a Api
    //.apiInfo(metaInfo()) é o método criado embaixo e ele é apenas pra dar informações sobre quem criou a Api
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.produtos.apirest"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    //Produtos ApiRest é o nome da Api
    //"Api Rest de cadastro de produtos" é a descricão da Api
    //Versão da Api
    //New Contact: informações pessoais de quem criou A Api

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Produtos ApiRest",
                "Api Rest de cadastro de produtos",
                "1.0",
                "Terms of Service",
                new Contact("Simone Santos", "https://www.google.com",
                        "simoneperiodista3@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html", new ArrayList<VendorExtension>()


        );
        return apiInfo;

    }
}
