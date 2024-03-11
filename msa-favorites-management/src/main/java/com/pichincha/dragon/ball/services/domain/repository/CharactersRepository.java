package com.pichincha.dragon.ball.services.domain.repository;

import com.pichincha.dragon.ball.services.domain.entities.CharactersEntity;
import com.pichincha.dragon.ball.services.domain.entities.CharactersFavoritesEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CharactersRepository extends ReactiveCrudRepository<CharactersEntity, Integer> {
    @Query("select c.*  from " +
            "favorites f inner join characters c on c.characters_id = f.characters_id " +
            "where user_id = :userId")
    Flux<CharactersFavoritesEntity> findByUserId(Integer userId);
}
