package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayAllStudentWithCourse {
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

        Criteria crt1 = ses.createCriteria(Student.class);
        List<Student> studentsList = crt1.list();
        for (Student s: studentsList) {
            System.out.println("NAME:" + s.getStudentName());
            List<Course> courseList = s.getCourseList();
            System.out.println("Course Name:");
            for (Course c : courseList) {
                System.out.println(c.getCourseName());
            }
            System.out.println("============================");
        }


    }
}
