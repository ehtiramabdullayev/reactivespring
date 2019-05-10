package com.reactive.example.reactivespring.service;

import com.reactive.example.reactivespring.model.CoinBaseResponse;
import com.reactive.example.reactivespring.model.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ehtiram_Abdullayev on 10.05.2019
 * @project reactivespring
 */
public interface CoinbaseService {

    Mono<CoinBaseResponse> getCryptoPrice(String priceName);

    Mono<Purchase>createPurchase(String priceName);

    Mono<Purchase>getPurchaseById(String id);

    Flux<Purchase> listAllPurchases();
}
