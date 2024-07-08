package HCQL;

import domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.Iterator;
import java.util.List;

public class displayHCQL {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();

        cfg=cfg.configure();

        cfg=cfg.addAnnotatedClass(Product.class);

        factory= cfg.buildSessionFactory();

        ses=factory.openSession();
        //Fetching deatils from all the column
        //create Criteria
        Criteria crt1=ses.createCriteria(Product.class);
        //exicute Criteria
        List<Product> productList=crt1.list();
        for(Product p:productList){
            System.out.println(p);
        }
        System.out.println("======================================================================================");


        //fetching the details from specific column
        //create criteria

        Criteria crt2=ses.createCriteria(Product.class);
        //add requirement details
        crt2.setProjection(Projections.property("productName"));
        //exicute Criteria
        List<String> name=crt2.list();
        for(String s:name){
            System.out.println(s);
        }
        System.out.println("==========================================");

        //fetch details from name and column
        Criteria crt3=ses.createCriteria(Product.class);

        ProjectionList plist=Projections.projectionList();

        //add requirement details
        plist.add(Projections.property("productName"));
        plist.add(Projections.property("productPrice"));
        crt3.setProjection(plist);
        //exicute Criteria
        List data=crt3.list();
        Iterator itr= data.iterator();
        while (itr.hasNext()) {
            Object[] arr = (Object[]) itr.next();
            System.out.println(arr[0] + "\t" + arr[1]);
        }

    }

}
