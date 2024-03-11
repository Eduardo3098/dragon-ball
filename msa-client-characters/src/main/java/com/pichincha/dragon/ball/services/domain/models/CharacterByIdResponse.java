package com.pichincha.dragon.ball.services.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterByIdResponse extends CharacterResponse {
    String race;
    String originPlanet;
    String maxKi;
    String description;
    String affiliation;
}
