package com.jimmydev.personal_finance_tracker.mapper;

import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    /// from entity to dto
    TransactionsResponseDto toResponse(TransactionsResponseDto transactionsResponseDto);
    /// from dto to entity
    Transactions toEntity(TransactionsRequestDto transactionsRequestDto);
}
