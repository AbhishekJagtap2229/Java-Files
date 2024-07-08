package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DisplayByName {
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

        Criteria crt = ses.createCriteria(Customer.class);
        List<Customer> customerList = crt.list();
        for (Customer c : customerList) {
            System.out.println("name"+c.getCustomerName());
            List<Orders> ordersList=c.getOrdersList();
            System.out.println("OrderNumber :");
            for(Orders o:ordersList){
                System.out.println(o.getOrderNumber());



        }
            System.out.println("======================================================");


        }

    }
}
