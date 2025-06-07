package com.jimmydev.personal_finance_tracker.services.ServiceImpls;


import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserResponseDto;

import com.jimmydev.personal_finance_tracker.exceptions.UserNotFoundException;
import com.jimmydev.personal_finance_tracker.mapper.UserMapper;
import com.jimmydev.personal_finance_tracker.repository.UserRepository;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponseDto save(UserRequestDto entity) {
        var userEntity = userMapper.toEntity(entity);

        userRepository.save(userEntity);

        return userMapper.toResponse(userEntity);

    }

    @Override
    public UserResponseDto findById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not found with id: " + id));

        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponseDto> findAll() {

        var users = userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();

        return users;
    }

    @Override
    public void deleteById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
    }
}
