package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCourseStudentDetails {
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

        //create course Object
        Course c1=new Course();
        c1.setCourseName("JAVA");

        //Create Students Objects
        Student s1=new Student();
        s1.setStudentName("DIVESH");

        Student s2=new Student();
        s2.setStudentName("ABHI");
        //add students to courses
        c1.addStudent(s1);
        c1.addStudent(s2);
        //save objects
        tx= ses.beginTransaction();
        ses.save(c1);
        ses.save(s1);
        ses.save(s2);
        tx.commit();
        System.out.println("Courses And Students Details Saved Successfully");
    }
}
