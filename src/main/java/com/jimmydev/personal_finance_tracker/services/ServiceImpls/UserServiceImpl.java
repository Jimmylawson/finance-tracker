package com.jimmydev.personal_finance_tracker.services.ServiceImpls;


import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserResponseDto;

import com.jimmydev.personal_finance_tracker.dto.UserDto.UserUpdateDto;
import com.jimmydev.personal_finance_tracker.entity.User;
import com.jimmydev.personal_finance_tracker.exceptions.UserNotFoundException;
import com.jimmydev.personal_finance_tracker.mapper.UserMapper;
import com.jimmydev.personal_finance_tracker.repository.UserRepository;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.IService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements IService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    private User getUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        var userEntity = userMapper.toEntity(userRequestDto);
        log.info("DTO received: {}",userRequestDto );
        var saved = userRepository.save(userEntity);
        log.info("Mapped entity: {}", userEntity);

        return userMapper.toResponse(saved);

    }

    @Override
    public List<UserResponseDto> createUsers(List<UserRequestDto> userRequestDtos) {
        var users = userRequestDtos
                .stream()
                .map(userMapper::toEntity)
                .toList();


        users.forEach(user -> log.info("Mapped user: username={}, email={}, password={}",
                user.getUsername(), user.getEmail(), user.getPassword()));

        var savedUsers = userRepository.saveAll(users);
        return savedUsers
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponseDto findById(Long id) {
        var user =  getUserOrThrow(id);

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
        var user = getUserOrThrow(id);

        userRepository.delete(user);
    }

    @Override
    public UserUpdateDto updateUser(Long id, UserRequestDto userRequestDto) {
        var  user  = getUserOrThrow(id);;
        userMapper.updateEntityFromDto(userRequestDto, user);
        userRepository.save(user);///persist data
        return userMapper.toUpdate(user);


    }
}
