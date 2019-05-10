package com.reactive.example.reactivespring.service;

import com.reactive.example.reactivespring.model.CoinBaseResponse;
import com.reactive.example.reactivespring.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author Ehtiram_Abdullayev on 10.05.2019
 * @project reactivespring
 */
public class CoinbaseServiceImpl implements CoinbaseService{

    @Autowired
    private WebClient webClient;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<CoinBaseResponse> getCryptoPrice(String priceName) {
        return webClient.get()
                .uri("htttps://api.coinbase.com/v2/prices/{crypto/buy}",priceName)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CoinBaseResponse.class));
    }


    @Override
    public Mono<Purchase> createPurchase(String priceName) {
        //Get crypto price from the coinbase API
        return getCryptoPrice(priceName).flatMap(coinBaseResponse -> reactiveMongoTemplate.save(
                new Purchase(priceName,coinBaseResponse.getData().getAmount(), LocalDateTime.now())
        ));
    }
}
