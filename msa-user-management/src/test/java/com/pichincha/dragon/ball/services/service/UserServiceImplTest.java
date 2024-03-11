package com.pichincha.dragon.ball.services.service;

import com.pichincha.dragon.ball.services.domain.repository.UserRepository;
import com.pichincha.dragon.ball.services.service.impl.AuthenticationServiceImpl;
import com.pichincha.dragon.ball.services.service.impl.UserServiceImpl;
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
@ContextConfiguration(classes = {UserServiceImpl.class})
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void shouldPostLoginUser() {
        Mockito.when(userRepository.save(Mockito.any())).
                thenReturn(Mono.just(MockUtils.usersEntity()));

        StepVerifier.create(userService.postUser(Mono.just(MockUtils.postUserRequest())))
                .consumeNextWith(Assertions::assertNotNull)
                .expectComplete().verify();
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any());
    }
}
