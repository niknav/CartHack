package com.management.cartMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2

public class CartApplication {
	public static void main(String[] args) {
		SpringApplication.run(CartApplication.class, args);
	}
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
	@Bean
    public Docket CustomerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
               .select()

               .apis(RequestHandlerSelectors.basePackage("com.management.cartMS"))
               .build().apiInfo(apiDetails());
    }
 
 private ApiInfo apiDetails() {
        ApiInfo apiInfo = new ApiInfo(
                "Cart API",
                "This API will provide information about Cart details",
                "1.0.0",
                "Free to use",
                "cart@org.com",
                "API license: Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0.html");

        return apiInfo;
    }
}

