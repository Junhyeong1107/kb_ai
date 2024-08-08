package com.example.sanback.controller;

import com.opencsv.CSVReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CsvController {

    @GetMapping("/totals")
    public String processCsv(Model model) {
        Map<String, Double> categoryTotals = new HashMap<>();
        String filePath = "C:\\Users\\USER\\Desktop\\kb_ai\\test.csv"; // CSV 파일 경로 설정

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            // 첫 번째 행은 헤더이므로 건너뜁니다
            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                String category = record[0];
                double amount = Double.parseDouble(record[1]);

                categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0) + amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("categoryTotals", categoryTotals);
        return "totals";
    }
}