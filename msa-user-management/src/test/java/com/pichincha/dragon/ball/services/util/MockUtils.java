package com.pichincha.dragon.ball.services.util;

import com.pichincha.dragon.ball.services.domain.entities.UsersEntity;
import com.pichincha.dragon.ball.services.domain.models.PostLoginUserRequest;
import com.pichincha.dragon.ball.services.domain.models.PostUserRequest;
import com.pichincha.dragon.ball.services.domain.models.PostUserResponse;
import org.springframework.http.ResponseEntity;

public class MockUtils {
    public static ResponseEntity<PostUserResponse> postUser() {
        PostUserResponse postUserResponse = new PostUserResponse();
        postUserResponse.setUserId(1L);
        postUserResponse.setUserName("test");
        postUserResponse.setEmail("test@test.com");
        return ResponseEntity.ok().body(postUserResponse);
    }

    public static PostUserRequest postUserRequest() {
        PostUserRequest request = new PostUserRequest();
        request.setEmail("test@test.com");
        request.setUserName("test");
        request.setPassword("test");
        return request;
    }

    public static PostLoginUserRequest postLoginUserRequest() {
        PostLoginUserRequest request = new PostLoginUserRequest();
        request.setEmail("test");
        request.setPassword("test");
        return request;
    }

    public static UsersEntity usersEntity() {
        UsersEntity users = new UsersEntity();
        users.setUserId(2L);
        users.setUserName("test");
        users.setPassword("test");
        users.setEmail("test@test.com");
        return  users;
    }
}
