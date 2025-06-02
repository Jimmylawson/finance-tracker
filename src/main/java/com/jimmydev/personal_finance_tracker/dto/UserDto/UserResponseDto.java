package com.jimmydev.personal_finance_tracker.dto.UserDto;

import com.jimmydev.personal_finance_tracker.entity.Budget;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class UserResponseDto {
    private String username;
    private String email;
    private List<Transactions> transactions;
    private List<Budget> budgets;

}
