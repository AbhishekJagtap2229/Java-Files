package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class displayProduct {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        //step 1 -->Activate Hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();  //reads the data from cfg
        //step 2 -->Establish communication link
        factory=cfg.buildSessionFactory();
        //step 3-->
        ses=factory.openSession();

        //step 4--> read data from database

        product p=ses.load(product.class,1);
        System.out.print(p.getProductId()+"  ");
        System.out.print(p.getProductName()+"  ");
        System.out.print(p.getProductCategory()+"  ");
        System.out.print(p.getProductPrice()+"  ");
    }
}
