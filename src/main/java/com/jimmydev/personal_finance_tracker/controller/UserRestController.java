package com.jimmydev.personal_finance_tracker.controller;


import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserResponseDto;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.IService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class UserRestController {
    private final IService userService;



    @GetMapping("/user")
    String getUser(){

        return "Hello User";
    }

    /// Create users
    @PostMapping("/user")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto){
        var user = userService.save(userRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }


    /// get all users
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    /// get a specific user
    @GetMapping("/user/{id}")
    public  ResponseEntity<UserResponseDto> getUser(@Valid @PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

}
