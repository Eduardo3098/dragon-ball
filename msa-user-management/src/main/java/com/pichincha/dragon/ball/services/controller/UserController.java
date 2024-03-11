package com.pichincha.dragon.ball.services.controller;

import com.pichincha.dragon.ball.services.domain.models.PostLoginUserRequest;
import com.pichincha.dragon.ball.services.domain.models.PostUserRequest;
import com.pichincha.dragon.ball.services.domain.models.PostUserResponse;
import com.pichincha.dragon.ball.services.service.AuthenticationService;
import com.pichincha.dragon.ball.services.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/user-management",
            produces = { "application/json", "application/json;charset=UTF-8"},
            consumes = { "application/json"})
    public Mono<ResponseEntity<PostUserResponse>> postUser(@RequestBody Mono<PostUserRequest> userRequest) {
        return userService.postUser(userRequest);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/user-authentication/login",
            produces = { "application/json", "application/json;charset=UTF-8"},
            consumes = { "application/json"})
    public Mono<ResponseEntity<PostUserResponse>> postLoginUser(@RequestBody Mono<PostLoginUserRequest> loginRequest) {
        return authenticationService.postLoginUser(loginRequest);
    }
}
