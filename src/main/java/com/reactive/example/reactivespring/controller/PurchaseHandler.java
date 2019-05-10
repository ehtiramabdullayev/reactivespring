package com.reactive.example.reactivespring.controller;

import com.reactive.example.reactivespring.model.Purchase;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author Ehtiram_Abdullayev on 09.05.2019
 * @project reactivespring
 */
public class PurchaseHandler {

    public Mono<ServerResponse> listPurchases(ServerRequest serverRequest) {
        final Mono<Purchase> purchase = Mono.fromSupplier(() -> new Purchase("From Functional Endpoint", "123", LocalDateTime.now()));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchase, Purchase.class);
    }
}
