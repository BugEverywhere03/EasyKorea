package com.learnkorealanguage.app.config;


import com.learnkorealanguage.app.model.Account;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBConnectionFactory {

    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();

        // Config property for Configuration
        configuration.setProperty("hibernate.dialect", GlobalConfig.getProperty("DIALECT"));
        configuration.setProperty("hibernate.connection.driver.class", GlobalConfig.getProperty("DRIVER_CLASS"));
        configuration.setProperty("hibernate.connection.url", GlobalConfig.getProperty("DATABASE_URL"));
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");

        // Add entity for Configuration
        configuration.addAnnotatedClass(Account.class);
        ServiceRegistry serviceRegister = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegister);
    }


}
