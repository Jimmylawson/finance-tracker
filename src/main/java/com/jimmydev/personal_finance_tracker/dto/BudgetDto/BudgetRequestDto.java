package com.jimmydev.personal_finance_tracker.dto.BudgetDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class BudgetRequestDto {
    @NotBlank(message = "Category is required")
    private String category;
    @NotBlank(message = "Limit amount is required")
    private BigDecimal limitAmount;
    @NotBlank(message = "Month is required")
    private String month;
    @NotBlank(message = "User ID is required")
    private Long userId; /// to associate the budget with a user


}
