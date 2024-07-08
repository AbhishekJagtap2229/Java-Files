package Demo;


import domain.product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteAllProductFormDB {
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
        tx= ses.beginTransaction();
        Query q= ses.createQuery("delete p from product p");
        int count=q.executeUpdate();//DML
        tx.commit();
        System.out.println(count+" Product Deleted");
    }
}
