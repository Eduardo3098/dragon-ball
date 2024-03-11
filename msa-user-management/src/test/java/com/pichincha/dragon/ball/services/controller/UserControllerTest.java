package com.pichincha.dragon.ball.services.controller;

import com.pichincha.dragon.ball.services.service.AuthenticationService;
import com.pichincha.dragon.ball.services.service.UserService;
import com.pichincha.dragon.ball.services.util.MockUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@ContextConfiguration(classes = {UserController.class})
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    AuthenticationService authenticationService;

    @Test
    void shouldPostUser() {
        Mockito.when(userService.postUser(Mockito.any())).thenReturn(Mono.just(MockUtils.postUser()));

        StepVerifier.create(userController.postUser(Mono.just(MockUtils.postUserRequest())))
                .consumeNextWith(Assertions::assertNotNull)
                .expectComplete().verify();
        Mockito.verify(userService, Mockito.times(1)).postUser(Mockito.any());
    }

    @Test
    void shouldPostLoginUser() {
        Mockito.when(authenticationService.postLoginUser(Mockito.any())).thenReturn(Mono.just(MockUtils.postUser()));

        StepVerifier.create(userController.postLoginUser(Mono.just(MockUtils.postLoginUserRequest())))
                .consumeNextWith(Assertions::assertNotNull)
                .expectComplete().verify();
        Mockito.verify(authenticationService, Mockito.times(1)).postLoginUser(Mockito.any());
    }
}
