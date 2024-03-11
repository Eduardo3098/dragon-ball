package com.pichincha.dragon.ball.services.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterResponse {
    Integer id;
    String name;
    String gender;
    String ki;
    String image;
}
