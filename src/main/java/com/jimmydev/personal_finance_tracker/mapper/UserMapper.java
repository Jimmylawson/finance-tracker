package com.jimmydev.personal_finance_tracker.mapper;

import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserResponseDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserSummaryDto;

import com.jimmydev.personal_finance_tracker.dto.UserDto.UserUpdateDto;
import com.jimmydev.personal_finance_tracker.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    /*
    * UserMapper mapper
    * */
    /// from entity to dto
    UserResponseDto toResponse(User user);
    /// from dto to entity
    User toEntity(UserRequestDto requestDto);

    UserSummaryDto toSummary(User user);
    UserUpdateDto toUpdate(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UserRequestDto dto, @MappingTarget User entity);

}
