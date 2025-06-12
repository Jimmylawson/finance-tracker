package com.jimmydev.personal_finance_tracker.controller;


import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class TransactionController {
    private final TransactionService transactionService;


    @GetMapping("/users/{userId}/transactions")
    public ResponseEntity<Page<TransactionsResponseDto>> getAllTransactions(@Valid @PathVariable Long transactionId,
                                                                        @PageableDefault(size = 20, sort="date" , direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAllTransactionsByUserId(transactionId,pageable));
    }

    @GetMapping("/transaction/{userId}")
    public ResponseEntity<TransactionsResponseDto> getTransaction(@Valid @PathVariable Long transactionId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transactionService.getTransactionById(transactionId));
    }


    @PostMapping("/transaction")
    public ResponseEntity<TransactionsResponseDto> createTransaction(@Valid @RequestBody TransactionsRequestDto transactionsRequestDto){

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    transactionService.addTransaction(transactionsRequestDto)
            );
    }

    @PatchMapping("/transaction/{userId}")
    public ResponseEntity<TransactionsResponseDto> updateTransaction(@Valid @PathVariable Long transactionId, @Valid @RequestBody TransactionsRequestDto transactionsRequestDto){

        return ResponseEntity.status(HttpStatus.OK).body(
                transactionService.updateTransaction(transactionId , transactionsRequestDto)
        );
    }

    @PutMapping("/transaction/{userId}")
    public ResponseEntity<TransactionsResponseDto> updatePutTransaction(@Valid @PathVariable Long transactionId, @Valid @RequestBody TransactionsRequestDto transactionsRequestDto){

        return ResponseEntity.status(HttpStatus.OK).body(
                transactionService.updateTransaction(transactionId , transactionsRequestDto)
        );
    }


    @DeleteMapping("/transaction/{userId}")
    public ResponseEntity<Void> deleteTransaction(@Valid @PathVariable Long transactionId){
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity
                .noContent().build();

    }




}
