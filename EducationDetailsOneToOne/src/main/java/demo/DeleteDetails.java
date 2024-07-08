package demo;

import domain.Student;
import domain.Education;
import domain.Student;
import domain.Education;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteDetails {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Student Id");
        int id=sc1.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Education.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        //create Object of passport
        Education s1=new Education();

        //create object of citizen
        Student c1=new Student();
        c1=ses.load(Student.class,id);

        //assign passport details to citizen object
        c1.getEduId();
        tx=ses.beginTransaction();
        ses.delete(c1);
        tx.commit();
        System.out.println("Information Deleted Successfully");
    }
}
