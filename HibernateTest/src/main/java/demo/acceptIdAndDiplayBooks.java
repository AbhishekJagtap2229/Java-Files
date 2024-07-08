package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class acceptIdAndDiplayBooks {
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
        System.out.println("Enter Author ID");
        int id= sc1.nextInt();

        Author a1=ses.load(Author.class,id);
        System.out.println("Author Name :"+a1.getAuthorName());
        List<Book> bookList=a1.getBookList();
        for (Book b:bookList){
            System.out.println(b.getBookName());
        }
    }
}
