package com.clarivate.foodapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.clarivate.foodapp.repository.UserRepository;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FoodappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodappApplication.class, args);
	}

	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
	
	Contact contact = new Contact("Clarivate","https://foodordering.com","clarivate@gmail.com");
	
	ApiInfo apiInfo = new ApiInfo("Food Ordering", "Order From your Home", "snapshot-0.0.1", "https://foodordering.com", contact, "www.foodordering.com", "terms and conditions", vendorExtensions);
	
	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.clarivate.foodapp")).build().apiInfo(apiInfo);
	}
}
