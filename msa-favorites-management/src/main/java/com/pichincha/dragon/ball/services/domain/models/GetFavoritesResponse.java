package com.pichincha.dragon.ball.services.domain.models;

import com.pichincha.dragon.ball.services.domain.entities.FavoritesEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetFavoritesResponse {
    Integer userId;
    List<FavoritesEntity> characters;
}

