package com.jimmydev.personal_finance_tracker.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter

public class User {
    @Id
    private Long id;
    private String username;
    private String email;
    private String password;

    /// Adding additional entities here
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "user")
    List<Transactions> transactions;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Budget> budgets;





}
