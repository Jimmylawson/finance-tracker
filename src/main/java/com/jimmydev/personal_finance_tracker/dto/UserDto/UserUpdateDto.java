package com.jimmydev.personal_finance_tracker.dto.UserDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @Email(message = "Enter a valid email")
    private String email;

    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    private String password;
}