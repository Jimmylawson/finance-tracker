package com.jimmydev.personal_finance_tracker.services.serviceInterfaces;

import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserResponseDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserUpdateDto;
import com.jimmydev.personal_finance_tracker.entity.User;
import com.jimmydev.personal_finance_tracker.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public interface IService {
    // This interface can be used to define common service methods
    // that can be implemented by various service classes in the application.

    // Example method signatures can be added here, such as:
     UserResponseDto save(UserRequestDto entity);
     List<UserResponseDto> createUsers(List<UserRequestDto> userRequestDtos);
    UserResponseDto findById(Long id);
    List<UserResponseDto> findAll();
     void deleteById(Long id);
     UserUpdateDto updateUser(Long id, UserRequestDto userRequestDto);

}
