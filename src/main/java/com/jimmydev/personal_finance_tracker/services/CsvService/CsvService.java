package com.jimmydev.personal_finance_tracker.services.CsvService;


import com.jimmydev.personal_finance_tracker.dto.csv.MonthlySummaryCsvDto;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Service
public class CsvService {

    public void exportMonthlySummary(List<MonthlySummaryCsvDto> summaries, HttpServletResponse res) {
        try {
            // Set response headers for CSV download
            res.setContentType("text/csv");
            res.setHeader("Content-Disposition", "attachment; filename=monthly_summary.csv");

            PrintWriter writer = res.getWriter();

            StatefulBeanToCsv<MonthlySummaryCsvDto> beanToCsv = new StatefulBeanToCsvBuilder<MonthlySummaryCsvDto>(writer)
                    .withApplyQuotesToAll(false) // Optional: disables quoting for all fields
                    .build();

            beanToCsv.write(summaries);

        } catch (IOException | CsvException e) {
            throw new RuntimeException("Failed to write CSV data", e);
        }
    }
}