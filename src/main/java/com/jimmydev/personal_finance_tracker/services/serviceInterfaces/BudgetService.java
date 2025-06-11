package com.jimmydev.personal_finance_tracker.services.serviceInterfaces;

import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetRequestDto;
import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Budget;

import java.util.List;
import java.util.Optional;

public interface BudgetService {

    BudgetResponseDto save(BudgetRequestDto budgetRequestDto);
    BudgetResponseDto findById(Long id);
    BudgetResponseDto update(Long id,  BudgetRequestDto budgetRequestDto);
    void deleteById(Long id);
    List<BudgetResponseDto> getAllBudgetByUser(Long userId);

}
