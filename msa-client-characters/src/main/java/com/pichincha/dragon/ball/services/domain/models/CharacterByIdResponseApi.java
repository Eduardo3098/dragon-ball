package com.pichincha.dragon.ball.services.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterByIdResponseApi extends CharacterResponse {
    String race;
    OriginPlanet originPlanet;
    List<Transformations> transformations;
    String description;
    String affiliation;
}

