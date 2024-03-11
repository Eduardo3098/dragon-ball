package com.pichincha.dragon.ball.services.service;

import com.pichincha.dragon.ball.services.domain.repository.UserRepository;
import com.pichincha.dragon.ball.services.service.impl.AuthenticationServiceImpl;
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
@ContextConfiguration(classes = {AuthenticationServiceImpl.class})
public class AuthenticationServiceImplTest {

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Mock
    private UserRepository userRepository;

    @Test
    void shouldPostLoginUser() {
        Mockito.when(userRepository.login(Mockito.anyString(), Mockito.anyString())).
                thenReturn(Mono.just(MockUtils.usersEntity()));

        StepVerifier.create(authenticationService.postLoginUser(Mono.just(MockUtils.postLoginUserRequest())))
                .consumeNextWith(Assertions::assertNotNull)
                .expectComplete().verify();
        Mockito.verify(userRepository, Mockito.times(1)).login(Mockito.anyString(), Mockito.anyString());
    }
}
