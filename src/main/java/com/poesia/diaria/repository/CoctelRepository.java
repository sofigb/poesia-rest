package com.poesia.diaria.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class CoctelRepository {


    private final WebClient webClient;

    public CoctelRepository(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.thecocktaildb.com").build();
    }

    public String obtenerCoctelRandom(){
        String  response  = webClient.get().uri("/api/json/v1/1/random.php").
                retrieve().bodyToMono(String.class).
                block();
        return response;
    }



}
