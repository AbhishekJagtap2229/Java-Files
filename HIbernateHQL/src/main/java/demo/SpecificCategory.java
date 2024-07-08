package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class SpecificCategory
{
    public static void main(String[] args)
    {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE PRODUCT CATEGORY : ");
        String category=sc.next();

        cfg=new Configuration();

        cfg=cfg.configure();

        cfg=cfg.addAnnotatedClass(Product.class);

        factory= cfg.buildSessionFactory();

        ses=factory.openSession();

        Query q=ses.createQuery("select p from Product p where p.productCategory="+category+"");
        List<Product> productList=q.list();

        for(Product p:productList)
        {
            System.out.println(p);
        }


    }
}
