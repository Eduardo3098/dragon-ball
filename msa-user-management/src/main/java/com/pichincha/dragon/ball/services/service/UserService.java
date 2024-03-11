package com.pichincha.dragon.ball.services.service;

import com.pichincha.dragon.ball.services.domain.models.PostUserRequest;
import com.pichincha.dragon.ball.services.domain.models.PostUserResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<ResponseEntity<PostUserResponse>> postUser(Mono<PostUserRequest> userRequest);
}
