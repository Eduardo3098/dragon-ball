package com.pichincha.dragon.ball.services.controller;

import com.pichincha.dragon.ball.services.domain.models.CharacterByIdResponse;
import com.pichincha.dragon.ball.services.domain.models.CharacterResponse;
import com.pichincha.dragon.ball.services.service.CharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class CharactersController {

    private final CharacterService characterService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/characters",
            produces = { "application/json", "application/json;charset=UTF-8"})
    public Mono<ResponseEntity<Flux<CharacterResponse>>> getCharacters(@RequestParam(value = "page") Integer page) {
        return characterService.getCharacters(page);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/characters/{id}",
            produces = { "application/json", "application/json;charset=UTF-8"})
    public Mono<ResponseEntity<Mono<CharacterByIdResponse>>> getCharactersById(@PathVariable(value = "id") Integer id) {
        return characterService.getCharacterById(id);
    }
}
