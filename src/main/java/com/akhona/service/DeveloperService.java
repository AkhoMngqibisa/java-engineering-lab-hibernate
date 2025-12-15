package com.akhona.service;

import com.akhona.entity.Developer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class DeveloperService {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    private void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Developer.class)
                .configure()
                .buildSessionFactory();
    }

    private void setSession(Session session) {
        this.session = getSessionFactory().openSession();
    }

    private void setTransaction(Transaction transaction) {
        this.transaction = getSession().beginTransaction();
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Session getSession() {
        return session;
    }

    private Transaction getTransaction() {
        return transaction;
    }
}
