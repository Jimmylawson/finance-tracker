package com.jimmydev.personal_finance_tracker.dto.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Year;
import java.time.YearMonth;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor
public class MonthlySummaryCsvDto {
    @CsvBindByName(column = "Month")
    private String month = YearMonth.now().toString();
    @CsvBindByName(column = "username")
    private String username;
    @CsvBindByName(column = "Total Income")
    private BigDecimal totalIncome;
    @CsvBindByName(column = "Total Expenses")
    private BigDecimal totalExpenses;
    @CsvBindByName(column = "Total Budgets")
    private BigDecimal totalBudgets;
    @CsvBindByName(column = "Categories")
    private String categories;

}
