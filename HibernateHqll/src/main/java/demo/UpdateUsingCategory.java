package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateUsingCategory {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Category ");
        String cate= sc1.next();

        //step 1 -->Activate Hibernate framework
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Product.class);
        factory = cfg.buildSessionFactory();

        ses = factory.openSession();
        tx = ses.beginTransaction();
        Query q=ses.createQuery("update Product p set p.productPrice=25000 where p.productCategory='"+cate+"'" );

        int count=q.executeUpdate();
        tx.commit();
        System.out.println(count+" Products Updated");
    }
}