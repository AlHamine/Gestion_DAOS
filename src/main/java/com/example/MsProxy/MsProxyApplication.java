package com.example.MsProxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class MsProxyApplication {



	public static void main(String[] args) {
		SpringApplication.run(MsProxyApplication.class, args);
	}

	@Bean
	public RouteLocator routeBuilder(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route("maquette-service", r -> r.path("/maquette/**")
						.uri("http://localhost:8081/"))
				.route("repartition-service", r -> r.path("/repartition/**")
						.uri("http://localhost:8082/"))
				.route("emploiDuTemps-service", r -> r.path("/emploiDuTemps/**")
						.uri("http://localhost:8083/"))
				.build();

	}

}
