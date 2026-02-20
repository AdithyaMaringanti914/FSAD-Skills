package com.example.employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Adithya");
        emp.setSalary(50000);

        session.save(emp);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Employee saved successfully");
    }
}

