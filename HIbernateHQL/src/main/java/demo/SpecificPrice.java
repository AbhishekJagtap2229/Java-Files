package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class SpecificPrice
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();

        cfg=cfg.configure();

        cfg=cfg.addAnnotatedClass(Product.class);

        factory= cfg.buildSessionFactory();

        ses=factory.openSession();

        Query q=ses.createQuery("select p from Product p where p.productPrice<30000");
        List<Product> productList=q.list();

        for(Product p:productList)
        {
            System.out.println(p);
        }


    }
}
