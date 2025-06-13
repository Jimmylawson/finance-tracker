package com.jimmydev.personal_finance_tracker.services.CsvService;

import com.jimmydev.personal_finance_tracker.dto.csv.MonthlySummaryCsvDto;
import com.jimmydev.personal_finance_tracker.entity.User;
import com.jimmydev.personal_finance_tracker.repository.BudgetRepository;
import com.jimmydev.personal_finance_tracker.repository.TransactionRepository;
import com.jimmydev.personal_finance_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;
import java.time.YearMonth;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final BudgetRepository budgetRepository;

    public List<MonthlySummaryCsvDto> generatedMonthlySummary() {
        List<MonthlySummaryCsvDto> summaries = new ArrayList<>();
        var users = userRepository.findAll();
        var currentMonth = YearMonth.now();
        LocalDate start = currentMonth.atDay(1);
        LocalDate end = currentMonth.atEndOfMonth();

        for (User user : users) {
            BigDecimal totalIncome = transactionRepository.sumByUserAndTypeAndDateRange(user.getId(), "INCOME", start, end);
            BigDecimal totalExpenses = transactionRepository.sumByUserAndTypeAndDateRange(user.getId(), "EXPENSE", start, end);
            BigDecimal totalBudget = budgetRepository.sumLimitByUserAndMonth(user.getId(), start, end);

            MonthlySummaryCsvDto dto = new MonthlySummaryCsvDto();
            dto.setMonth(currentMonth.toString());
            dto.setUsername(user.getUsername());
            dto.setTotalIncome(totalIncome != null ? totalIncome : BigDecimal.ZERO);
            dto.setTotalExpenses(totalExpenses != null ? totalExpenses : BigDecimal.ZERO);
            dto.setTotalBudgets(totalBudget != null ? totalBudget : BigDecimal.ZERO);
            dto.setCategories(""); // Fill in if categories are aggregated

            summaries.add(dto);
        }

        return summaries;
    }
    public MonthlySummaryCsvDto generatedMonthlySummaryForUser(Long userId) {
        var user = userRepository.findById(userId).orElseThrow();
        YearMonth currentMonth = YearMonth.now();
        LocalDate start = currentMonth.atDay(1);
        LocalDate end = currentMonth.atEndOfMonth();

        BigDecimal totalIncome = transactionRepository.sumByUserAndTypeAndDateRange(userId, "INCOME", start, end);
        BigDecimal totalExpenses = transactionRepository.sumByUserAndTypeAndDateRange(userId, "EXPENSE", start, end);
        BigDecimal totalBudget = budgetRepository.sumLimitByUserAndMonth(userId, start, end);

        return new MonthlySummaryCsvDto(
                currentMonth.toString(),
                user.getUsername(),
                totalIncome != null ? totalIncome : BigDecimal.ZERO,
                totalExpenses != null ? totalExpenses : BigDecimal.ZERO,
                totalBudget != null ? totalBudget : BigDecimal.ZERO,
                ""
        );
    }

}
