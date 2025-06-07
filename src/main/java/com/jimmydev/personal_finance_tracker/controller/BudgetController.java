package com.jimmydev.personal_finance_tracker.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BudgetController {


    @GetMapping("/budget")
    public String getBudget() {
        return "Hello Budget";
    }
}
