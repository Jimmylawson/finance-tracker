package com.jimmydev.personal_finance_tracker.services.ServiceImpls;


import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.entity.User;
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
    public void save(UserRequestDto entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }
}
