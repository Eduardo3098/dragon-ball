package com.pichincha.dragon.ball.services.domain.repository;

import com.pichincha.dragon.ball.services.domain.entities.UsersEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UsersEntity, String> {
    @Query("select * from users where email = :email and password = :password")
    Mono<UsersEntity> login(String email, String password);
}
