package com.jimmydev.personal_finance_tracker.dto.TransactionDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionsRequestDto {
    @NotNull(message = "Amount is required")
    private BigDecimal amount;
    @NotNull(message = "Date is required")
    private LocalDate date;
    @NotBlank(message = "Type is required")
    private String type; // "income" or "expense"
    @NotBlank(message = "Category is required")
    private String category;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "User ID is required")
    private Long userId; /// to associate the transaction with a user
}
