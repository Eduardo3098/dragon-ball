package com.pichincha.dragon.ball.services.service;

import com.pichincha.dragon.ball.services.domain.models.DeleteFavoriteRequest;
import com.pichincha.dragon.ball.services.domain.models.GetFavoritesResponse;
import com.pichincha.dragon.ball.services.domain.models.PostFavoriteRequest;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface FavoriteService {

    Mono<ResponseEntity<Void>> postFavorite(Mono<PostFavoriteRequest> favoriteRequest);

    Mono<ResponseEntity<Void>> deleteFavorite(Mono<DeleteFavoriteRequest> favoriteRequest);

    Mono<ResponseEntity<Mono<GetFavoritesResponse>>>getFavorites(Integer userId);
}
