package com.pichincha.dragon.ball.services.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {
    @Id()
    @Column("user_id")
    private Long userId;

    @Column("user_name")
    private String userName;

    @Column("email")
    private String email;

    @Column("password")
    private String password;
}
