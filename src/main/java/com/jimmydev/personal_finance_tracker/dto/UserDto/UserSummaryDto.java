package com.jimmydev.personal_finance_tracker.dto.UserDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSummaryDto {
    private String username;
    private String email;
}
