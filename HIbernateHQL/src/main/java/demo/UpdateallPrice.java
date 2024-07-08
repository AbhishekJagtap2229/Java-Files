package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class UpdateallPrice
{

    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();
        tx= ses.beginTransaction();
        Query q=ses.createQuery("update product p set p.productPrice=50000");
       int count=q.executeUpdate();
       tx.commit();
        System.out.println(count +" records updated succeessfully..!!");

    }
}
