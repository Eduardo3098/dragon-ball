package com.pichincha.dragon.ball.services.mapper;

import com.pichincha.dragon.ball.services.domain.models.CharacterByIdResponse;
import com.pichincha.dragon.ball.services.domain.models.CharacterByIdResponseApi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
        unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface CharacterMapper {
    CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    CharacterByIdResponse toCharacterByIdResponse(CharacterByIdResponseApi character);
}
