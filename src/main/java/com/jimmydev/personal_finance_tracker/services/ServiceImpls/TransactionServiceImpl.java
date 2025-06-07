package com.jimmydev.personal_finance_tracker.services.ServiceImpls;

import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import com.jimmydev.personal_finance_tracker.mapper.TransactionMapper;
import com.jimmydev.personal_finance_tracker.repository.TransactionRepository;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;


    @Override
    public void addTransaction(TransactionsRequestDto transactionRequestDto) {

    }

    @Override
    public void deleteTransaction(Long transactionId) {

    }

    @Override
    public TransactionsResponseDto updateTransaction(Long transactionId, TransactionsRequestDto transactionRequestDto) {
        return null;
    }

    @Override
    public Optional<TransactionsResponseDto> getTransactionById(Long transactionId) {
        return Optional.empty();
    }

    @Override
    public List<TransactionsResponseDto> getAllTransactionsByUserId(Long userId) {
        return List.of();
    }
}
