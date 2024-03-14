package com.pichincha.dragon.ball.services.service.impl;

import com.pichincha.dragon.ball.services.configuration.PropertiesConfiguration;
import com.pichincha.dragon.ball.services.domain.models.CharacterByIdResponse;
import com.pichincha.dragon.ball.services.domain.models.CharacterResponse;
import com.pichincha.dragon.ball.services.proxy.CharactersApiWebClient;
import com.pichincha.dragon.ball.services.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Log4j2
public class CharacterServiceImpl implements CharacterService {

    private final CharactersApiWebClient webClient;
    private final PropertiesConfiguration propertiesConfiguration;

    @Override
    public Mono<ResponseEntity<Flux<CharacterResponse>>> getCharacters(Integer page) {
        log.info("Get characters");
        return webClient.getCharacterResponseApiFlux(page, propertiesConfiguration.getClientBaseUrl())
                .map(characterResponseApi -> ResponseEntity.ok().body(Flux.fromIterable(characterResponseApi.getItems())))
                .doOnError(e -> log.error("Error when reception info from Api Characters: {}", e.getMessage()));
    }

    @Override
    public Mono<ResponseEntity<Mono<CharacterByIdResponse>>> getCharacterById(Integer id) {
        return webClient.getCharacterByIdResponseApiMono(id, propertiesConfiguration.getClientBaseUrl())
                .map(characterResponseApi -> {
                    CharacterByIdResponse characterResponse = new CharacterByIdResponse();
                    characterResponse.setId(characterResponseApi.getId());
                    characterResponse.setName(characterResponseApi.getName());
                    characterResponse.setGender(characterResponseApi.getGender());
                    characterResponse.setKi(characterResponseApi.getKi());
                    characterResponse.setImage(characterResponseApi.getImage());
                    characterResponse.setRace(characterResponseApi.getRace());
                    characterResponse.setDescription(characterResponseApi.getDescription());
                    characterResponse.setAffiliation(characterResponseApi.getAffiliation());
                    characterResponse.setOriginPlanet(characterResponseApi.getOriginPlanet().getName());
                    characterResponse.setMaxKi(characterResponseApi.getTransformations().get(characterResponseApi.getTransformations().size() - 1).getKi());
                    return ResponseEntity.ok().body(Mono.just(characterResponse));
                })
                .doOnError(e -> log.error("Error when reception info from Api Characters: {}", e.getMessage()));
    }
}
