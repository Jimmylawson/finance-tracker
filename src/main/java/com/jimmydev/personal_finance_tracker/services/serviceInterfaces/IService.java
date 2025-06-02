package com.jimmydev.personal_finance_tracker.services.serviceInterfaces;

import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.entity.User;

import java.util.List;
import java.util.Optional;

public interface IService {
    // This interface can be used to define common service methods
    // that can be implemented by various service classes in the application.

    // Example method signatures can be added here, such as:
     void save(UserRequestDto entity);
    Optional<User> findById(Long id);
    List<User> findAll();
     void deleteById(Long id);

}
