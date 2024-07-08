package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveExistingStudentCourse {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg = cfg.addAnnotatedClass(Course.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Student s1=ses.load(Student.class,9);
        Course c1=ses.load(Course.class,6);
        s1.addCourse(c1);
        tx=ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("Details Inserted Successfully");


    }
}
