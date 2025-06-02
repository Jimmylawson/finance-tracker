package com.jimmydev.personal_finance_tracker.dto.TransactionDto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionsRequestDto {
    private Long id;
    private Double amount;
    private LocalDate date;
    private String type; // "income" or "expense"
    private String category;
    private String description;
    private Long userId; /// to associate the transaction with a user
}
