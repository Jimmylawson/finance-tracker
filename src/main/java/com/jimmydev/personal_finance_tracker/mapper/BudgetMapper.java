package com.jimmydev.personal_finance_tracker.mapper;


import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetRequestDto;
import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Budget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BudgetMapper {

    // Define mapping methods here, e.g.:
    // BudgetResponseDto toResponse(Budget budget);
    // Budget toEntity(BudgetRequestDto requestDto);
    /// from entity to dto
    BudgetResponseDto toResponseDto(Budget budget);

    /// from dto to entity
    Budget toEntity(BudgetRequestDto requestDto);

    // Add this method:
    @Mapping(target = "id", ignore = true) // Prevent overwriting the id
    void updateBudgetFromDto(BudgetResponseDto dto, @MappingTarget Budget entity);

}
