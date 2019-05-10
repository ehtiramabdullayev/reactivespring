package com.reactive.example.reactivespring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Ehtiram_Abdullayev on 09.05.2019
 * @project reactivespring
 */
@Document
public class Purchase {
    private final String name;
    private final String price;
    private final LocalDateTime createdAt;

    @Id
    private String id;

    public Purchase(String name, String price, LocalDateTime createdAt) {
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
    }


    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
