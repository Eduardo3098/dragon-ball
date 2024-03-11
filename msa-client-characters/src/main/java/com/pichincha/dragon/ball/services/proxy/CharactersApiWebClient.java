package com.pichincha.dragon.ball.services.proxy;

import com.pichincha.dragon.ball.services.domain.models.CharacterByIdResponseApi;
import com.pichincha.dragon.ball.services.domain.models.CharacterResponseApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Component
@Log4j2
@RequiredArgsConstructor
public class CharactersApiWebClient {

    public Mono<CharacterResponseApi> getCharacterResponseApiFlux(Integer page, String url) {
        log.info("Calling to API Characters");
        url = url + "?page="+page;
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
                .uriBuilderFactory(factory)
                .build();
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(CharacterResponseApi.class)
                .log();
    }

    public Mono<CharacterByIdResponseApi> getCharacterByIdResponseApiMono(Integer id, String url) {
        log.info("Calling to API Character by Id");
        url = url + "/"+id;
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
                .build();
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(CharacterByIdResponseApi.class)
                .log();
    }
}
