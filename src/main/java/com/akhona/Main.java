package com.akhona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setRollNo(127);
        student.setsName("Zintle");
        student.setsAge(29);

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(student);
        transaction.commit();

        session.close();
        System.out.println(student);

    }
}