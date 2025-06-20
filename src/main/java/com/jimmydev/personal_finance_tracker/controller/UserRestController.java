package com.jimmydev.personal_finance_tracker.controller;


import com.jimmydev.personal_finance_tracker.dto.UserDto.UserRequestDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserResponseDto;
import com.jimmydev.personal_finance_tracker.dto.UserDto.UserUpdateDto;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.IService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
@Slf4j
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
        log.debug("Received user request: {}", userRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @PostMapping("/users")
    public ResponseEntity<List<UserResponseDto>> createMultipleUsers(@RequestBody List<@Valid UserRequestDto> userRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUsers(userRequestDto));

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

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@Valid @PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<UserUpdateDto> partialUpdateUser(@Valid @PathVariable Long id, @RequestBody UserRequestDto userRequestDto){

        return ResponseEntity.ok(userService.updateUser(id, userRequestDto));
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<UserUpdateDto> updateUser(
            @PathVariable Long id,
            @RequestBody @Valid UserRequestDto userRequestDto) {

        return ResponseEntity.ok(userService.updateUser(id, userRequestDto));
    }
}
