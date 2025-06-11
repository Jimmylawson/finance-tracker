package com.jimmydev.personal_finance_tracker.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    /// Adding additional entities here

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "user")
    List<Transactions> transactions;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Budget> budgets;


}
