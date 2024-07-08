package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class deleteProduct {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;


        //step 1 -->Activate Hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();  //reads the data from cfg
        //step 2 -->Establish communication link
        factory=cfg.buildSessionFactory();
        //step 3-->
        ses=factory.openSession();

        //step 4--> load the object
        product p=ses.load(product.class,1);


        //step 5-->start the transaction
        tx=ses.beginTransaction();
        ses.delete(p);
        tx.commit();
        System.out.println("Product deleted successfully");
    }
}
