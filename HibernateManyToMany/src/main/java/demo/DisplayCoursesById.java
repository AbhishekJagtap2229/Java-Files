package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayCoursesById {
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

        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Student Id");
        int id=sc1.nextInt();

        Student s1=ses.load(Student.class,id);
        System.out.println("NAME:"+s1.getStudentName());
        List<Course> courseList=s1.getCourseList();
        for (Course c:courseList){
            System.out.println(c.getCourseName());
        }

    }
}
