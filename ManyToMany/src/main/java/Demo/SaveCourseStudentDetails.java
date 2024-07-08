package Demo;

import Domain.Course;
import Domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCourseStudentDetails {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx ;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg=cfg.addAnnotatedClass(Course.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        //object of course

        Course c1=new Course();
        c1.setCourseName("JAVA");

        //object of student
        Student s1=new Student();
        s1.setStudentName("ROHAN");

        Student s2=new Student();
        s2.setStudentName("RAM");

        //add student to courses
        c1.addStudents(s1);
        c1.addStudents(s2);

        //save object
        tx= ses.beginTransaction();
        ses.save(c1);
        ses.save(s1);
        ses.save(s2);
        tx.commit();
        System.out.println("Record save Successfully");
    }
}
