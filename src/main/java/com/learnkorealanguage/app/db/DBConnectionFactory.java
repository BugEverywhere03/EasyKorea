package com.learnkorealanguage.app.db;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnectionFactory {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getDBSessionManager() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }


}
