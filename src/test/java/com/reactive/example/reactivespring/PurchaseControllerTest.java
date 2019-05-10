package com.reactive.example.reactivespring;

import com.reactive.example.reactivespring.model.Purchase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @author Ehtiram_Abdullayev on 10.05.2019
 * @project reactivespring
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PurchaseControllerTest {

    @Autowired
    ApplicationContext context;

    private WebTestClient webTestClient;

    @Before
    public void setUp() throws Exception {
        webTestClient = WebTestClient
                .bindToApplicationContext(this.context)
                .build();
    }


    @Test
    public void createPurchase(){
        webTestClient.get()
                .uri("/coin/purchase/v1/{id}",123)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Purchase.class);
    }


}
