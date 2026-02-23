package com.learnkorealanguage.app.repository;

import com.learnkorealanguage.app.model.Account;

import java.util.Optional;

public class AuthRepository extends BaseRepository<Account> {

    public AuthRepository(){
        super(Account.class);
    }
    public Optional<Account> findByUsername(String userName){
        return executeQuery(session -> session.createQuery("FROM Account WHERE userName = :username ",
                Account.class).setParameter("username", userName).uniqueResultOptional());
    }
    public Optional<Account> findByUsernameAndPassword(String  username, String password){
        return executeQuery(session -> session.createQuery("""
            FROM Account WHERE userName = :username
                AND password = :password""", Account.class).setParameter("username", username).setParameter("password", password).
                uniqueResultOptional());
    }

}
