package Demo;

import domain.product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdatePriceOfAllProductsFromSpecificCategoryAcceptPriceANDCatagoryFromUser {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //step 1 -->Activate Hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();  //reads the data from cfg
        //step 2 -->Establish communication link
        cfg=cfg.addAnnotatedClass(product.class);
        factory=cfg.buildSessionFactory();
        //step 3-->
        ses=factory.openSession();


        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Product Category");
        String cate=sc1.next();
        System.out.println("Enter Product Price");
        Double price= sc1.nextDouble();


        //Step-4
        tx= ses.beginTransaction();
        Query q= ses.createQuery("update product p set p.productPrice='"+price+"' where p.productCategory='"+cate+"' ");
        int count=q.executeUpdate();
        tx.commit();
        System.out.println(count+" Product Updated");
    }
}
