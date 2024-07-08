package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCourseStudent1 {
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

        Course c1=ses.load(Course.class,7);

        Student s1=new Student();
        s1.setStudentName("SANDEEP");

        c1.addStudent(s1);

        tx= ses.beginTransaction();
        ses.save(s1);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
