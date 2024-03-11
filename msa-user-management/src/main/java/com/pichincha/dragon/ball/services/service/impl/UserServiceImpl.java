package com.pichincha.dragon.ball.services.service.impl;

import com.google.gson.Gson;
import com.pichincha.dragon.ball.services.domain.entities.UsersEntity;
import com.pichincha.dragon.ball.services.domain.models.PostUserRequest;
import com.pichincha.dragon.ball.services.domain.models.PostUserResponse;
import com.pichincha.dragon.ball.services.domain.repository.UserRepository;
import com.pichincha.dragon.ball.services.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public Mono<ResponseEntity<PostUserResponse>> postUser(Mono<PostUserRequest> userRequest) {
        log.info("Create new user");
        return userRequest.flatMap(postUserRequest -> {
            log.debug("Object PostUserRequest Request in Json: [request:{}]", new Gson().toJson(postUserRequest));
            UsersEntity newUser = new UsersEntity();
            newUser.setUserName(postUserRequest.getUserName());
            newUser.setEmail(postUserRequest.getEmail());
            newUser.setPassword(postUserRequest.getPassword());

            return userRepository
                    .save(newUser)
                    .doOnError(e -> log.error("Error saving new user", e))
                    .doOnNext(x -> log.info("User saved"))
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
