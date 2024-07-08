package demo;

import domain.Education;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class InsertDetails {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Student Name");
        String name=sc1.next();
        System.out.println("Enter Contact No");
        int contact=sc1.nextInt();
        System.out.println("Enter 10th %");
        double ten=sc1.nextDouble();
        System.out.println("Enter 12th %");
        double twelve=sc1.nextDouble();
        System.out.println("Enter Degree Percent");
        double degree=sc1.nextDouble();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Education.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();



        Education c1=new Education();
        c1.setTenthPercent(ten);
        c1.setTwelvePercent(twelve);
        c1.setDegree(degree);

        Student s1=new Student();
        s1.setStudentName(name);
        s1.setContact(contact);
        s1.setEduId(c1);
        tx= ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("Details Inserted Successfully");

    }
}
