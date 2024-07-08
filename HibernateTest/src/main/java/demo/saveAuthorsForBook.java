package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class saveAuthorsForBook {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg=cfg.addAnnotatedClass(Author.class);
        cfg=cfg.addAnnotatedClass(Book.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter Book Name");
        String book1= sc1.next();
        System.out.println("Enter First Author Name");
        String name1= sc1.next();
        System.out.println("Enter Second Author Name");
        String name2= sc1.next();

        Book b1=new Book();
        b1.setBookName(book1);

        Author a1=new Author();
        a1.setAuthorName(name1);

        Author a2=new Author();
        a2.setAuthorName(name2);

        b1.addAuthor(a1);
        b1.addAuthor(a2);

        tx= ses.beginTransaction();
        ses.save(b1);
        ses.save(a1);
        ses.save(a2);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
