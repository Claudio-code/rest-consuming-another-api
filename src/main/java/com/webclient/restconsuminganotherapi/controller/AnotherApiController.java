package com.webclient.restconsuminganotherapi.controller;

import com.webclient.restconsuminganotherapi.dto.MockoonDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class AnotherApiController {
    private final WebClient webClient;

    public AnotherApiController() {
        this.webClient = WebClient.create("http://mockoon-api:3000/users");
    }

    @GetMapping(path = "/test")
    public String getUserInfo() {
        var response = webClient.get()
                .retrieve()
                .bodyToFlux(MockoonDTO.class)
                .collectList()
                .block()
                .stream().findFirst()
                .get();

        return response.getField();
    }
}
