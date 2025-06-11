package com.jimmydev.personal_finance_tracker.dto.BudgetDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
