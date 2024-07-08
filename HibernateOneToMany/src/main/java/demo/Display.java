package demo;

import domain.Customer;
import domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Display {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg=cfg.addAnnotatedClass(Customer.class);
        cfg=cfg.addAnnotatedClass(Orders.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Customer ID no");
        int id= sc1.nextInt();

        Customer c1=ses.load(Customer.class,id);
        String name=c1.getCustomerName();
        System.out.println("name"+name);
        List<Orders>ordersList=c1.getOrdersList();
        System.out.println("OrderNumber :");
        for(Orders o:ordersList){
            System.out.println(o.getOrderNumber());
        }



    }
}

