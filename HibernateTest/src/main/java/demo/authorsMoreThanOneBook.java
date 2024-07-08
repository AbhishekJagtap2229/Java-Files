package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class authorsMoreThanOneBook {
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;


        cfg = new Configuration();
        cfg = cfg.configure();
        cfg=cfg.addAnnotatedClass(Author.class);
        cfg=cfg.addAnnotatedClass(Book.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt= ses.createCriteria(Author.class);
        List<Author> authorList=crt.list();
        for (Author a:authorList){
            if (a.getBookList().size()>1) {
                System.out.println("Author Name: "+a.getAuthorName());
                List<Book> bookList=a.getBookList();

                System.out.println("Book Name: ");
                for (Book b : bookList) {
                    System.out.println(b.getBookName());
                }
            }
            System.out.println("====================================");
        }
    }
}


