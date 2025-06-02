package com.jimmydev.personal_finance_tracker.services.ServiceImpls;

import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.BudgetService;

import java.util.Optional;

public class BudgetServiceImpl implements BudgetService {
    @Override
    public BudgetResponseDto save(BudgetResponseDto budgetResponseDto) {
        return null;
    }

    @Override
    public Optional<BudgetResponseDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public BudgetResponseDto update(BudgetResponseDto budgetResponseDto) {
        return null;
    }

    @Override
    public BudgetResponseDto deleteById(Long id) {
        return null;
    }
}
