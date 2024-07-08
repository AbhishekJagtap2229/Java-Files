package demo;

import domain.product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertProduct {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg=cfg.addAnnotatedClass(product.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        product p1=new product(2,"AC","Electronic",45000.15);

        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product inserted successfully");

    }
}
