// package com.example.MsProxy;

// import org.springframework.cloud.gateway.filter.GatewayFilterChain;
// import org.springframework.cloud.gateway.filter.GlobalFilter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsUtils;
// import org.springframework.web.cors.reactive.CorsConfigurationSource;
// import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
// import org.springframework.web.server.ServerWebExchange;

// import com.google.common.net.HttpHeaders;

// import reactor.core.publisher.Mono;

// import java.util.Arrays;
// import java.util.Collections;

// @Configuration
// public class GatewayConfig implements GlobalFilter {

//     private final CorsConfiguration corsConfiguration;

//     public GatewayConfig(CorsConfigurationSource corsConfigurationSource) {
//         this.corsConfiguration = corsConfigurationSource.getCorsConfiguration(null); // Consider passing exchange object
//                                                                                      // for dynamic configuration
//     }

//     @Override
//     public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//         ServerWebExchange mutatedExchange = exchange.mutate()
//                 .request(exchange.getRequest().mutate()
//                         .headers(httpHeaders -> {
//                             httpHeaders.setAccessControlAllowOrigin(corsConfiguration.getAllowedOrigins().get(0)); // Assuming
//                                                                                                                    // single
//                                                                                                                    // origin
//                                                                                                                    // for
//                                                                                                                    // this
//                                                                                                                    // example
//                             httpHeaders.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
//                                     corsConfiguration.getAllowedMethods());
//                             // Add other headers (allowCredentials, allowedHeaders) as needed
//                         })
//                         .build())
//                 .build();
//         return chain.filter(mutatedExchange);
//     }
// }
