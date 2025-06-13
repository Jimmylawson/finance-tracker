package com.jimmydev.personal_finance_tracker.services.ServiceImpls;

import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import com.jimmydev.personal_finance_tracker.entity.User;
import com.jimmydev.personal_finance_tracker.exceptions.TransactionNotFoundException;
import com.jimmydev.personal_finance_tracker.exceptions.UserNotFoundException;
import com.jimmydev.personal_finance_tracker.mapper.TransactionMapper;
import com.jimmydev.personal_finance_tracker.repository.TransactionRepository;
import com.jimmydev.personal_finance_tracker.repository.UserRepository;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final UserRepository userRepository;


    private Transactions getUserOrThrow(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }


    @Override
    public TransactionsResponseDto addTransaction(TransactionsRequestDto transactionRequestDto) {
        //adding transaction to the database
        var transactionEntity = transactionMapper.toEntity(transactionRequestDto);
        /// Saving the transaction entity to the repository
        var user = userRepository.findById(transactionRequestDto.getUserId())
                .orElseThrow(()-> new UserNotFoundException("User not found with id: " + transactionRequestDto.getUserId()));
        /// set the user entity
        transactionEntity.setUser(user);
        var saveTransaction = transactionRepository.save(transactionEntity);

        // Transforming the saved entity back to a DTO and returning it
        return transactionMapper.toResponse(saveTransaction);

    }

    @Override
    public void deleteTransaction(Long transactionId) {
        var transaction = getUserOrThrow(transactionId );
        transactionRepository.delete(transaction);
    }

    @Override
    public TransactionsResponseDto updateTransaction(Long transactionId, TransactionsRequestDto transactionRequestDto) {
        var transaction = getUserOrThrow(transactionId );
        transactionMapper.updateEntityFromDto(transactionRequestDto,transaction);
        // Saving the updated transaction entity back to the repository
        var updatedTransaction = transactionRepository.save(transaction);

        // Returning the updated transaction as a DTO
        return transactionMapper.toResponse(updatedTransaction);

    }

    @Override
    public TransactionsResponseDto getTransactionById(Long transactionId) {
        var transaction = getUserOrThrow(transactionId );

        return transactionMapper.toResponse(transaction);
    }


    @Override
    public Page<TransactionsResponseDto> getAllTransactionsByUserId(Long userId,Pageable pageable) {

       /// Get User first
        var user  =  userRepository.findById(userId)
                .orElseThrow(()->  new UserNotFoundException("User not found with id: " + userId));
        /// retrieve the user from the transactions entity
        var transactions = transactionRepository.findAllByUserId(user.getId(), pageable);


        //if(transactions.isEmpty()) throw new TransactionNotFoundException("No transaction found for user with id: " + userId );

        return transactions.map(transactionMapper::toResponse);

    }

    @Override
    public BigDecimal getTotalIncome(Long userId, YearMonth month) {
        LocalDate start = month.atDay(1);
        LocalDate end = month.atEndOfMonth();
        BigDecimal income = transactionRepository.sumByUserAndTypeAndDateRange(userId,"INCOME",start, end);

        return income != null ? income : BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getTotalExpenses(Long userId, YearMonth month) {
        LocalDate start = month.atDay(1);
        LocalDate end = month.atEndOfMonth();
        BigDecimal expenses = transactionRepository.sumByUserAndTypeAndDateRange(userId,"EXPENSE",start, end);

        return expenses != null ? expenses : BigDecimal.ZERO;
    }

    @Override
    public List<TransactionsResponseDto> getAllTransactions() {
        var transactions =  transactionRepository.findAll();

        return transactions
                .stream()
                .map(transactionMapper::toResponse)
                .toList();
    }
}
