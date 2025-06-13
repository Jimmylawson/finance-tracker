package com.jimmydev.personal_finance_tracker.services.serviceInterfaces;

import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface TransactionService{

    TransactionsResponseDto addTransaction(TransactionsRequestDto transactionRequestDto);

    void deleteTransaction(Long transactionId);
    TransactionsResponseDto updateTransaction(Long transactionId, TransactionsRequestDto transactionRequestDto);
    TransactionsResponseDto getTransactionById(Long transactionId);
    Page<TransactionsResponseDto> getAllTransactionsByUserId(Long userId, Pageable pageable);
    List<TransactionsResponseDto> getAllTransactions();
    BigDecimal getTotalExpenses(Long userId, YearMonth month);
    BigDecimal getTotalIncome(Long userId, YearMonth month);
}
