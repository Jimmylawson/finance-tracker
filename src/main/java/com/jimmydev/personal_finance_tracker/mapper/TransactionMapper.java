package com.jimmydev.personal_finance_tracker.mapper;

import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsRequestDto;
import com.jimmydev.personal_finance_tracker.dto.TransactionDto.TransactionsResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    /// from entity to dto
    TransactionsResponseDto toResponse(Transactions transactions);
    /// from dto to entity
    Transactions toEntity(TransactionsRequestDto transactionsRequestDto);

    //Updating entity with new values from dto
    //@Mapping(target = "id",ignore = true) // Prevent overwriting the id
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(TransactionsRequestDto dto, @MappingTarget Transactions entity);
}
