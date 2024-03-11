package com.pichincha.dragon.ball.services.service;

import com.pichincha.dragon.ball.services.domain.models.PostLoginUserRequest;
import com.pichincha.dragon.ball.services.domain.models.PostUserResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface AuthenticationService {
    Mono<ResponseEntity<PostUserResponse>> postLoginUser(Mono<PostLoginUserRequest> loginRequest);
}
