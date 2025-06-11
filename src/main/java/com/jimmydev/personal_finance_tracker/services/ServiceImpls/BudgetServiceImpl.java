package com.jimmydev.personal_finance_tracker.services.ServiceImpls;

import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetRequestDto;
import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;
import com.jimmydev.personal_finance_tracker.exceptions.UserNotFoundException;
import com.jimmydev.personal_finance_tracker.mapper.BudgetMapper;
import com.jimmydev.personal_finance_tracker.repository.BudgetRepository;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor

public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;

    @Override
    public BudgetResponseDto save(BudgetRequestDto budgetRequestDto) {
        // Transform the BudgetRequestDto to an entity using the mapper
        var budgetEntity = budgetMapper.toEntity(budgetRequestDto);

        // Save the entity to the repository
        var savedBudget = budgetRepository.save(budgetEntity);

        // Transform the saved entity back to a DTO and return it
        return budgetMapper.toResponseDto(savedBudget);


    }

    @Override
    public BudgetResponseDto findById(Long id) {
       var budget =   budgetRepository.findById(id)
               .orElseThrow(()-> new UserNotFoundException("Budget not found for user with id: " + id));

       return budgetMapper.toResponseDto(budget);
    }

    /// Updating a user with new budget details
    @Override
    public BudgetResponseDto update(Long id, BudgetRequestDto budgeRequestDto) {
        var budget = budgetRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Budget not found for user with id: " + id));

        // Update the budget entity with new values from the DTO
        budgetMapper.updateBudgetFromDto(budgeRequestDto, budget);

        // Save the updated entity back to the repository
        var updatedBudget = budgetRepository.save(budget);

        // Return the updated budget as a DTO
        return budgetMapper.toResponseDto(updatedBudget);

    }

    @Override
    public void deleteById(Long id) {
        var budget = budgetRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Budget not found for user with id: " + id));

        budgetRepository.delete(budget);
    }

    @Override
    public List<BudgetResponseDto> getAllBudgetByUser(Long userId) {
        var budgets  = budgetRepository.findAllByUserId(userId);
        if (budgets.isEmpty()) {
            throw new UserNotFoundException("No budgets found for user with id: " + userId);
        }

        return budgets
                .stream()
                .map(budgetMapper::toResponseDto)
                .toList();
    }
}
