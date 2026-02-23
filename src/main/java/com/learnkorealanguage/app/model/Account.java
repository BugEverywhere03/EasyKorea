package com.learnkorealanguage.app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity( name = "Account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Integer accountId;
    @Column(unique = true, name = "Username", columnDefinition = "Username VARCHAR(20) NOT NULL")
    private String userName;
    @Column(name = "Password", columnDefinition = "Password VARCHAR(20) NOT NULL")
    private String password;
}

