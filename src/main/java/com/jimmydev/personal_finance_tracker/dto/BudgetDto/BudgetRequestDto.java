package com.jimmydev.personal_finance_tracker.dto.BudgetDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class BudgetRequestDto {
    private String category;
    private String limitAmount;
    private String month;
    private Long userId; /// to associate the budget with a user


}
