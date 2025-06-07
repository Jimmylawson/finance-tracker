package com.jimmydev.personal_finance_tracker.services.serviceInterfaces;

import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;

import java.util.List;
import java.util.Optional;

public interface TransactionService{

    TransactionsResponseDto addTransaction(TransactionsRequestDto transactionRequestDto);

    void deleteTransaction(Long transactionId);
    TransactionsResponseDto updateTransaction(Long transactionId, TransactionsRequestDto transactionRequestDto);
    TransactionsResponseDto getTransactionById(Long transactionId);
    List<TransactionsResponseDto> getAllTransactionsByUserId(Long userId);

}
