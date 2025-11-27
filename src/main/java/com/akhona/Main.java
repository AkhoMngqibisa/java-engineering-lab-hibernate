package com.akhona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setRollNo(123);
        student.setsName("Akhona");
        student.setsAge(22);

        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.persist(student);


        System.out.println(student);

    }
}