package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import javax.security.auth.login.Configuration;
import java.util.Scanner;

public class insertProduct {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Id");
        int id= sc1.nextInt();
        System.out.println("Enter Product Name");
        String name= sc1.next();
        System.out.println("Enter Product Category");
        String cate= sc1.next();
        System.out.println("Enter Product Price");
        double price= sc1.nextDouble();

        //step 1 -->Activate Hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();  //reads the data from cfg
        //step 2 -->Establish communication link
        factory=cfg.buildSessionFactory();
        //step 3-->
        ses=factory.openSession();
        //step 4 -->create object of domin class
        product p1=new product();
        p1.setProductId(id);
        p1.setProductName(name);
        p1.setProductCategory(cate);
        p1.setProductPrice(price);

        //step 5 -->Start the transaction
        tx=ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product inserted successfully");
    }
}
