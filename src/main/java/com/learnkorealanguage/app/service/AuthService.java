package com.learnkorealanguage.app.service;

import com.learnkorealanguage.app.model.Account;
import com.learnkorealanguage.app.repository.AuthRepository;

import java.util.Optional;

public class AuthService {

    private static final AuthRepository authRepository = new  AuthRepository();


    public static Optional<Account> getAccountByUserName(String userName){
        return authRepository.findByUsername(userName);
    }

    public static void createAccount(Account account){
        authRepository.save(account);
    }

    public static Optional<Account> validAccount(String username, String password){
        return authRepository.findByUsernameAndPassword(username, password);
    }
}
