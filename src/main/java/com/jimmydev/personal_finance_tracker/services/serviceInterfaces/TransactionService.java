package com.jimmydev.personal_finance_tracker.services.serviceInterfaces;

import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TransactionService{

    TransactionsResponseDto addTransaction(TransactionsRequestDto transactionRequestDto);

    void deleteTransaction(Long transactionId);
    TransactionsResponseDto updateTransaction(Long transactionId, TransactionsRequestDto transactionRequestDto);
    TransactionsResponseDto getTransactionById(Long transactionId);
    Page<TransactionsResponseDto> getAllTransactionsByUserId(Long userId, Pageable pageable);

}
