package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteOnlyOrder {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg=cfg.addAnnotatedClass(Customer.class);
        cfg=cfg.addAnnotatedClass(Orders.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Order ID no");
        int id= sc1.nextInt();

        Orders o1=ses.load(Orders.class,id);
        tx= ses.beginTransaction();
        ses.delete(o1);
        tx.commit();
        System.out.println("delete");
    }
}
