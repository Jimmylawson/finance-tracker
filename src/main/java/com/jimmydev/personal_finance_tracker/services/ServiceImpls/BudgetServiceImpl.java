package com.jimmydev.personal_finance_tracker.services.ServiceImpls;

import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetRequestDto;
import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Budget;

import com.jimmydev.personal_finance_tracker.exceptions.UserNotFoundException;
import com.jimmydev.personal_finance_tracker.mapper.BudgetMapper;
import com.jimmydev.personal_finance_tracker.repository.BudgetRepository;
import com.jimmydev.personal_finance_tracker.repository.UserRepository;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.BudgetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
@RequiredArgsConstructor

public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;
    private final BudgetMapper budgetMapper;
    private final UserRepository userRepository;

    private Budget getBudgetOrThrow(Long id) {
        return budgetRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }


    @Override
    public List<BudgetResponseDto> getAllBudgets() {
        var transactions =  budgetRepository.findAll();

        return transactions
                .stream()
                .map(budgetMapper::toResponseDto)
                .toList();
    }

    @Override
    public BudgetResponseDto save(BudgetRequestDto budgetRequestDto) {
        // Transform the BudgetRequestDto to an entity using the mapper
        var budgetEntity = budgetMapper.toEntity(budgetRequestDto);

        var user = userRepository.findById(budgetRequestDto.getUserId())
                .orElseThrow(()-> new UserNotFoundException("User not found with id: " + budgetRequestDto.getUserId()));
        /// set the user entity
        budgetEntity.setUser(user);
        // Save the entity to the repository
        var savedBudget = budgetRepository.save(budgetEntity);

        // Transform the saved entity back to a DTO and return it
        return budgetMapper.toResponseDto(savedBudget);


    }

    @Override
    public BudgetResponseDto findById(Long id) {
       var budget =   getBudgetOrThrow(id);

       return budgetMapper.toResponseDto(budget);
    }

    /// Updating a user with new budget details
    @Override
    public BudgetResponseDto update(Long id, BudgetRequestDto budgeRequestDto) {
        var budget = getBudgetOrThrow(id);
        // Update the budget entity with new values from the DTO
        budgetMapper.updateBudgetFromDto(budgeRequestDto, budget);

        // Save the updated entity back to the repository
        var updatedBudget = budgetRepository.save(budget);

        // Return the updated budget as a DTO
        return budgetMapper.toResponseDto(updatedBudget);

    }

    @Override
    public void deleteById(Long id) {
        var budget = getBudgetOrThrow(id);

        budgetRepository.delete(budget);
    }

    @Override
    public Page<BudgetResponseDto> getAllBudgetByUser(Long userId, Pageable pageable) {
        var user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User not found with id: " + userId));

        var budgets  = budgetRepository.findAllByUserId(user.getId(),pageable);


        return budgets.map(budgetMapper::toResponseDto);



    }




}
