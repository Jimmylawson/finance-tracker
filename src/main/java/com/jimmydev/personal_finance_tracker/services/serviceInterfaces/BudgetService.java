package com.jimmydev.personal_finance_tracker.services.serviceInterfaces;

import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetRequestDto;
import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Budget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BudgetService {

    BudgetResponseDto save(BudgetRequestDto budgetRequestDto);
    BudgetResponseDto findById(Long id);
    BudgetResponseDto update(Long id,  BudgetRequestDto budgetRequestDto);
    void deleteById(Long id);
    Page<BudgetResponseDto> getAllBudgetByUser(Long userId, Pageable pageable);

}
