package com.jimmydev.personal_finance_tracker.controller;


import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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


    @GetMapping("/transaction/{id}")
    public ResponseEntity<TransactionsResponseDto>  getTransactions(@Valid PathVariable Long id ) {
        return
    }

    @GetMapping("/transactions")
    public ResponseEntity<TransactionsResponseDto>  getTransactions(@Valid @RequestBody List<@Valid TransactionsRequestDto> requestTransactions) {

        return
    }
    @PostMapping("/transaction")
    public ResponseEntity<TransactionsResponseDto> createTransaction(@Valid @RequestBody TransactionsRequestDto transactionsRequestDto){

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    transactionService.addTransaction(transactionsRequestDto)
            );
    }

}
