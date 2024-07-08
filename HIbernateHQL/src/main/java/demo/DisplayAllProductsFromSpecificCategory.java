package Demo;

import domain.product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayAllProductsFromSpecificCategory {
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Product Category");
        String category= sc1.next();

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
        Query q=ses.createQuery("select p from product p where p.productCategory= '"+category+"' ");
        List<product> productList=q.list();
        for (product p:productList){
            System.out.println(p);
        }
    }
}
