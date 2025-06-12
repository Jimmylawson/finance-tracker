package com.jimmydev.personal_finance_tracker.controller;


import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetRequestDto;
import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Budget;
import com.jimmydev.personal_finance_tracker.services.serviceInterfaces.BudgetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BudgetController {
    private final BudgetService budgetService;


    @GetMapping("/budget/{id}")
    public ResponseEntity<BudgetResponseDto> getBudget(@Valid @PathVariable Long id) {

        return ResponseEntity.ok(budgetService.findById(id));
    }

    @PostMapping("/budget")
    public ResponseEntity<BudgetResponseDto> createBudgetForUser(@Valid @RequestBody BudgetRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(budgetService.save(requestDto));
    }
    @GetMapping("/users/{userId}/budget")
    public ResponseEntity<Page<BudgetResponseDto>> getAllUsersBudget(@Valid @PathVariable Long id,
                                                                     @PageableDefault(size=20, sort="date",direction = Sort.Direction.DESC) Pageable pageable){
            return ResponseEntity.ok(budgetService.getAllBudgetByUser(id,pageable));
    }


    @DeleteMapping("/budget/{id}")
    public ResponseEntity<Void> deleteAUserBudget(@Valid @PathVariable Long id){

        budgetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
