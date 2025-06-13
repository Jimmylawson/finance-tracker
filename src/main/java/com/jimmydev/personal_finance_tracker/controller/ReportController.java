package com.jimmydev.personal_finance_tracker.controller;


import com.jimmydev.personal_finance_tracker.services.CsvService.CsvService;
import com.jimmydev.personal_finance_tracker.services.CsvService.ReportService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/report")
public class ReportController {
    private  final CsvService csvService;
    private final ReportService reportService;

    @GetMapping("/month-summary/user")
    public void exportMonthlySummaryForAUser(@RequestParam Long userId,  HttpServletResponse response){
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition","attachment;filename=monthly_summary.csv");

        var summaries = reportService.generatedMonthlySummaryForUser(userId);
        csvService.exportMonthlySummary(List.of(summaries),response);
    }
    @GetMapping("/month-summary/all")
    public void exportMonthlySummary(HttpServletResponse response){
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition","attachment;filename=monthly_summary.csv");

        var summaries = reportService.generatedMonthlySummary();
        csvService.exportMonthlySummary(summaries,response);
    }

}
