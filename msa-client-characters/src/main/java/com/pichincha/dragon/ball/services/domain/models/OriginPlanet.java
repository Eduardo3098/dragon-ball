package com.pichincha.dragon.ball.services.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OriginPlanet {
    Integer id;
    String name;
    Boolean isDestroyed;
    String description;
    String image;
}
