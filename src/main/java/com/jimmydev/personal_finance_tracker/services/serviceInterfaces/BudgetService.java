package com.jimmydev.personal_finance_tracker.services.serviceInterfaces;

import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;

import java.util.Optional;

public interface BudgetService {

    BudgetResponseDto save(BudgetResponseDto budgetResponseDto);
    Optional<BudgetResponseDto> findById(Long id);
    BudgetResponseDto update(BudgetResponseDto budgetResponseDto);
    BudgetResponseDto deleteById(Long id);


}
