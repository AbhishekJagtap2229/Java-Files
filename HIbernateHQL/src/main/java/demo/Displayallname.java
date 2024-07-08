package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Displayallname
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

        Query q=ses.createQuery("select p.productName from Product p");
        List<String> productList=q.list();

        for(String p:productList)
        {
            System.out.println(p);
        }


    }
}
