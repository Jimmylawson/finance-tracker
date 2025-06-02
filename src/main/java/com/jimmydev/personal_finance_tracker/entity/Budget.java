package com.jimmydev.personal_finance_tracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "budget")
@RequiredArgsConstructor
public class Budget {
    @Id
    private Long id;
    private String category;
    private Double limitAmount;
    private LocalDate month;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}