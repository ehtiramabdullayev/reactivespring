package com.reactive.example.reactivespring.config;

import com.reactive.example.reactivespring.controller.PurchaseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.*;

/**
 * @author Ehtiram_Abdullayev on 09.05.2019
 * @project reactivespring
 */

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

    @Bean
    public PurchaseHandler purchaseHandler() {
        return new PurchaseHandler();
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunctionPurchase(final PurchaseHandler purchaseHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/coin/purchase/v1/{id}")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), purchaseHandler::listPurchases);
    }
}
