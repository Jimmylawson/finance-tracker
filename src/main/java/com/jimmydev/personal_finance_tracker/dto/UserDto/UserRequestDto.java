package com.jimmydev.personal_finance_tracker.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private Long id;
    private String username;
    private String email;
    private String password;


}
