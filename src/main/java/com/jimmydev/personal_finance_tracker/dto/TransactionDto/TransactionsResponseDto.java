package com.jimmydev.personal_finance_tracker.dto.TransactionDto;

import com.jimmydev.personal_finance_tracker.entity.Budget;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class TransactionsResponseDto {
    private Double amount;
    private LocalDate date;
    private String type;
    private String category;
    private String description;
    private Long userId; /// to associate the transaction with a user


}
