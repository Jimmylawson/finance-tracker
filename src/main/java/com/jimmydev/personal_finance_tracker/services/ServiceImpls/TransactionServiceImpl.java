package com.jimmydev.personal_finance_tracker.services.ServiceImpls;

import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import com.jimmydev.personal_finance_tracker.exceptions.UserNotFoundException;
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
    public TransactionsResponseDto addTransaction(TransactionsRequestDto transactionRequestDto) {
        //adding transaction to the database
        var transactionEntity = transactionMapper.toEntity(transactionRequestDto);
        /// Saving the transaction entity to the repository
        var saveTransaction = transactionRepository.save(transactionEntity);

        // Transforming the saved entity back to a DTO and returning it
        return transactionMapper.toResponse(saveTransaction);

    }

    @Override
    public void deleteTransaction(Long transactionId) {
        var transaction = transactionRepository.findById(transactionId)
                .orElseThrow(()-> new UserNotFoundException("Transaction not found with id: " + transactionId));

        transactionRepository.delete(transaction);
    }

    @Override
    public TransactionsResponseDto updateTransaction(Long transactionId, TransactionsRequestDto transactionRequestDto) {
        var transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new UserNotFoundException("Transaction not found with id: " + transactionId));

        transactionMapper.updateEntityFromDto(transactionRequestDto,transaction);
        // Saving the updated transaction entity back to the repository
        var updatedTransaction = transactionRepository.save(transaction);

        // Returning the updated transaction as a DTO
        return transactionMapper.toResponse(updatedTransaction);

    }

    @Override
    public TransactionsResponseDto getTransactionById(Long transactionId) {
        var transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new UserNotFoundException("Transaction not found with id: " + transactionId));

        return transactionMapper.toResponse(transaction);
    }

    @Override
    public List<TransactionsResponseDto> getAllTransactionsByUserId(Long userId) {
        var transactions = transactionRepository.findAllByUserId(userId);

        if(transactions.isEmpty()) throw new UserNotFoundException("No transactions found for user with id: " + userId);

        return transactions
                .stream()
                .map(transactionMapper::toResponse)
                .toList();



    }
}
