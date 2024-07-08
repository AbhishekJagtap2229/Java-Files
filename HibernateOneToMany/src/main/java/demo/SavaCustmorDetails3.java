package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SavaCustmorDetails3 {
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

        Customer c1=ses.load(Customer.class,1);

        Orders ord1=new Orders();
        ord1.setOrderNumber("ORD2006");
        Orders ord2=new Orders();
        ord2.setOrderNumber("ORD2007");

        c1.addOrder(ord1);
        c1.addOrder(ord2);

        tx= ses.beginTransaction();
        ses.save(ord1);
        ses.save(ord2);

        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
