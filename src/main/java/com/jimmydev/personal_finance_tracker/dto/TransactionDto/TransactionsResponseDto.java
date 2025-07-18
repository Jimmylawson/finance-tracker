package com.jimmydev.personal_finance_tracker.dto.TransactionDto;

import com.jimmydev.personal_finance_tracker.dto.UserDto.UserSummaryDto;
import com.jimmydev.personal_finance_tracker.entity.Budget;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter

public class TransactionsResponseDto {
    private BigDecimal amount;
    private LocalDate date;
    private String type;
    private String category;
    private String description;
    private UserSummaryDto user;

}
