package com.learnkorealanguage.app.repository;

import com.learnkorealanguage.app.db.DBConnectionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthRepository {
    public boolean login(){
        try (Session session = DBConnectionFactory.getDBSessionManager().openSession()){
            Transaction ts = session.beginTransaction();
            ts.commit();
        } catch (Exception e){
            return false;
        }
        return false;
    }
}
