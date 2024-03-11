package com.pichincha.dragon.ball.services.service.impl;

import com.google.gson.Gson;
import com.pichincha.dragon.ball.services.domain.models.PostLoginUserRequest;
import com.pichincha.dragon.ball.services.domain.models.PostUserResponse;
import com.pichincha.dragon.ball.services.domain.repository.UserRepository;
import com.pichincha.dragon.ball.services.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    @Override
    public Mono<ResponseEntity<PostUserResponse>> postLoginUser(Mono<PostLoginUserRequest> loginRequest) {
        log.info("New login request");
        return loginRequest.flatMap(postLoginUserRequest -> {
            log.debug("Object PostUserRequest Request in Json: [request:{}]", new Gson().toJson(postLoginUserRequest));
            return userRepository.login(postLoginUserRequest.getEmail(), postLoginUserRequest.getPassword())
                    .doOnNext(x -> log.info("User authenticated"))
                    .doOnError(e -> log.error("Error in authentication user", e))
                    .switchIfEmpty(Mono.error(new Exception()))
                    .map(usersEntity -> {
                        PostUserResponse response = new PostUserResponse();
                        response.setUserId(usersEntity.getUserId());
                        response.setUserName(usersEntity.getUserName());
                        response.setEmail(usersEntity.getEmail());
                        return ResponseEntity.ok().body(response);
                    });
        });
    }
}
