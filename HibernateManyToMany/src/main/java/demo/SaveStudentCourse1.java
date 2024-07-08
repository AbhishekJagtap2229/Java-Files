package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveStudentCourse1 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg=cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Course.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Student s1=ses.load(Student.class,8);

        Course c1=new Course();
        c1.setCourseName("J2EE");

        Course c2=new Course();
        c2.setCourseName("HIBERNATE");

        tx= ses.beginTransaction();
        ses.save(c1);
        ses.save(c2);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
