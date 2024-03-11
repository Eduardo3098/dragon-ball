package com.pichincha.dragon.ball.services.service;

import com.pichincha.dragon.ball.services.domain.models.CharacterByIdResponse;
import com.pichincha.dragon.ball.services.domain.models.CharacterResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CharacterService {
    Mono<ResponseEntity<Flux<CharacterResponse>>> getCharacters(Integer page);

    Mono<ResponseEntity<Mono<CharacterByIdResponse>>> getCharacterById(Integer id);
}
