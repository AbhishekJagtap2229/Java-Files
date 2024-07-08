package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveCustomerDetails {
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
        c1.setCustomerName("Sandeep");
        c1.setCustomerEmail("S@gmail.com");

        //Objects Of Orders
        Orders ord1=new Orders();
        ord1.setOrderNumber("ORD1001");

        Orders ord2=new Orders();
        ord2.setOrderNumber("ORD2002");

        //add orders to customer list
        c1.addOrder(ord1);
        c1.addOrder(ord2);

        tx= ses.beginTransaction();
        ses.save(c1);
        ses.save(ord1);
        ses.save(ord2);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
