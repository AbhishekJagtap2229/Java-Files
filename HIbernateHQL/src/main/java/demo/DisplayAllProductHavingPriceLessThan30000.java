package Demo;

import domain.product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayAllProductHavingPriceLessThan30000 {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        //step 1 -->Activate Hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();  //reads the data from cfg
        //step 2 -->Establish communication link
        cfg=cfg.addAnnotatedClass(product.class);
        factory=cfg.buildSessionFactory();
        //step 3-->
        ses=factory.openSession();

        //step 4--> HQL
        Query q=ses.createQuery("select p from product p where p.productPrice>10000 ");
        List<product> productList=q.list();
        for (product p:productList){
            System.out.println(p);
        }
    }
}
