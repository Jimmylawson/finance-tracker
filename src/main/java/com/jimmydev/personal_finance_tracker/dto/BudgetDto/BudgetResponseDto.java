package com.jimmydev.personal_finance_tracker.dto.BudgetDto;

import com.jimmydev.personal_finance_tracker.dto.UserDto.UserSummaryDto;
import com.jimmydev.personal_finance_tracker.entity.Budget;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetResponseDto {
    private String category;
    private BigDecimal limitAmount;
   private LocalDate month;
   private UserSummaryDto user;
}
