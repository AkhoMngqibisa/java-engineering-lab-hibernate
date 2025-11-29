package com.akhona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    private void setSessionFactory() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();
    }

    private void setSession() {
        session = getSessionFactory().openSession();
    }

    private void setTransaction() {
        transaction = getSession().beginTransaction();
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

    public void createStudent(Student student) {
        student.setRollNo(128);
        student.setsName("Andile");
        student.setsAge(26);

        getSession().persist(student);
        getTransaction().commit();

        getSession().close();
        getSessionFactory().close();

        System.out.println("Student created successfully");
    }

    public void getStudent(Student student) {
        Student retrievedStudent = getSession().find(Student.class, student.getRollNo());

        getSession().close();
        getSessionFactory().close();

        System.out.println("Student retrieved successfully " + retrievedStudent);
    }

    public void updateStudent(Student student) {
        getSession().merge(student);

        getSessionFactory().close();
        getSession().close();

        System.out.println("Student updated successfully " + student);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setRollNo(128);
        student.setsAge(28);
        student.setsName("Andile");

        Main main = new Main();
        main.setSessionFactory();
        main.setSession();
        main.setTransaction();
        // main.createStudent(new Student());
        // main.getStudent(student);
        main.updateStudent(student);

    }
}