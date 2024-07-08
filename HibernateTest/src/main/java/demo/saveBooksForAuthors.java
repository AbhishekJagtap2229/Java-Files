package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class saveBooksForAuthors {
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
        System.out.println("Enter Author Name");
        String name= sc1.next();
        System.out.println("Enter First Book Name");
        String book1= sc1.next();
        System.out.println("Enter Second Book Name");
        String book2= sc1.next();

        Author a1=new Author();
        a1.setAuthorName(name);

        Book b1=new Book();
        b1.setBookName(book1);

        Book b2=new Book();
        b2.setBookName(book2);

        a1.addBook(b1);
        a1.addBook(b2);

        tx= ses.beginTransaction();
        ses.save(a1);
        ses.save(b1);
        ses.save(b2);
        tx.commit();
        System.out.println("Details Inserted Successfully");
    }
}
