package com.jimmydev.personal_finance_tracker.mapper;


import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserResponseDto;
import com.jimmydev.personal_finance_tracker.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    /*
    * UserMapper mapper
    * */
    /// from entity to dto
    UserResponseDto toResponse(User user);
    /// from dto to entity
    User toEntity(UserRequestDto requestDto);

}
