package domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class form {
    public static void main(String[] args) {


        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        //step 1 -->Activate Hibernate framework
        cfg = new Configuration();
        cfg = cfg.configure();  //reads the data from cfg
        //step 2 -->Establish communication link
        factory = cfg.buildSessionFactory();
        //step 3-->
        ses = factory.openSession();

        Scanner sc1 = new Scanner(System.in);

        System.out.println("1:INSERT RECORD\n2:UPDATE RECORD\n3:DELETE RECORD\n4:DISPLAY RECORD");
        int choice1 = sc1.nextInt();
        if (choice1 == 1) {

            System.out.println("Enter Id");
            int id= sc1.nextInt();
            System.out.println("Enter Product Name");
            String name= sc1.next();
            System.out.println("Enter Product Category");
            String cate= sc1.next();
            System.out.println("Enter Product Price");
            double price= sc1.nextDouble();

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
            System.out.println("Record inserted successfully");
        } else if (choice1 == 2) {
            System.out.println("Enter Id");
            int id = sc1.nextInt();
            System.out.println("Which field need to modify");
            System.out.println("1;Name");
            System.out.println("2:Category");
            System.out.println("3:Price");

            int choice = sc1.nextInt();
            if (choice == 1) {
                System.out.println("Enter Updated Name");
                String name = sc1.next();
                product p = ses.load(product.class, id);
                p.setProductName(name);
                //step 5-->start the transaction
                tx = ses.beginTransaction();
                ses.update(p);
                tx.commit();
                System.out.println("Product updated successfully");

            } else if (choice == 2) {
                System.out.println("Enter Category");
                String cate = sc1.next();
                product p = ses.load(product.class, id);
                p.setProductCategory(cate);
                //step 5-->start the transaction
                tx = ses.beginTransaction();
                ses.update(p);
                tx.commit();
                System.out.println("Product updated successfully");

            } else if (choice == 3) {
                System.out.println("Enter Price");
                double price = sc1.nextDouble();
                product p = ses.load(product.class, id);
                p.setProductPrice(price);
                //step 5-->start the transaction
                tx = ses.beginTransaction();
                ses.update(p);
                tx.commit();
                System.out.println("Product updated successfully");
            } else {
                System.out.println("Invalid choice");
            }
        } else if (choice1 == 3) {
            System.out.println("Enter Id");
            int id = sc1.nextInt();
            //step 4--> load the object
            product p = ses.load(product.class, id);


            //step 5-->start the transaction
            tx = ses.beginTransaction();
            ses.delete(p);
            tx.commit();
            System.out.println("Record deleted successfully");

        } else if (choice1 == 4) {
            System.out.println("Enter Id");
            int id = sc1.nextInt();
            product p = ses.load(product.class, id);
            System.out.print(p.getProductId() + "  ");
            System.out.print(p.getProductName() + "  ");
            System.out.print(p.getProductCategory() + "  ");
            System.out.print(p.getProductPrice() + "  ");
        } else {
            System.out.println("Invalid choice");
        }



    }
}
