package com.pichincha.dragon.ball.services.mapper;

import com.pichincha.dragon.ball.services.domain.entities.UsersEntity;
import com.pichincha.dragon.ball.services.domain.models.PostUserResponse;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(
        componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(source = "userName", target = "userName")
//    @Mapping(source = "userId", target = "userId")
//    @Mapping(source = "email", target = "email")
    PostUserResponse toPostUserResponse(UsersEntity user);
}
