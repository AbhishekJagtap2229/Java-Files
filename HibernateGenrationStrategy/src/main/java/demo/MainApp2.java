package demo;

import domain.BookData1;
import domain.BookData2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainApp2 {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Book Name");
        String name= sc1.next();
        System.out.println("Enter Book Price");
        double price= sc1.nextDouble();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(BookData2.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();

        BookData2 b2=new BookData2();
        b2.setBookName(name);
        b2.setBookPrice(price);

        tx= ses.beginTransaction();
        ses.save(b2);
        tx.commit();
        System.out.println("Book Inserted Successfully");
    }
}
