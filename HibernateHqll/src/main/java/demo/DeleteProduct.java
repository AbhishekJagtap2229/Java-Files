package demo;

import domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteProduct {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //step 1 -->Activate Hibernate framework
        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Product.class);
        factory = cfg.buildSessionFactory();

        ses = factory.openSession();
        tx = ses.beginTransaction();
        Query q=ses.createQuery("delete Product p where p.productId=1");
        int count=q.executeUpdate();
        tx.commit();
        System.out.println(count+" Products Deleted");
    }
}
