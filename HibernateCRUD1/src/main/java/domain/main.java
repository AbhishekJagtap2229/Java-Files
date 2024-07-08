package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class main {
    public static void main(String[] args){

        //declare object
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
        //step 4 -->create object of domin class
        product p1=new product();
        p1.setProductId(1);
        p1.setProductName("Laptop");
        p1.setProductCategory("Electronic");
        p1.setProductPrice(45000);

        //step 5 -->Start the transaction
        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product inserted successfully");
    }
}
