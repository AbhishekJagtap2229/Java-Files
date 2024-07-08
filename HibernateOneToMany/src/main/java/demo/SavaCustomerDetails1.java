package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SavaCustomerDetails1 {
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

        //Object Of Customer
        Customer c1=new Customer();
        c1.setCustomerName("AKASH");
        c1.setCustomerEmail("A@gmail.com");

        Customer c2=new Customer();
        c2.setCustomerName("OMKAR");
        c2.setCustomerEmail("OMKAR@gmail.com");

        Orders ord1=new Orders();
        ord1.setOrderNumber("ORD2001");

        Orders ord2=new Orders();
        ord2.setOrderNumber("ORD2002");

        Orders ord3=new Orders();
        ord3.setOrderNumber("ORD2003");

        c1.addOrder(ord1);
        c1.addOrder(ord2);
        c2.addOrder(ord3);

        tx= ses.beginTransaction();
        ses.save(c1);
        ses.save(c2);
        ses.save(ord1);
        ses.save(ord2);
        ses.save(ord3);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
