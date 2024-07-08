package demo;

import domain.Author;
import domain.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class booksOnlyOneAuthor {
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

        Criteria crt= ses.createCriteria(Book.class);
        List<Book> bookList=crt.list();
        for (Book b:bookList){
            if (b.getAuthorList().size()==1) {
                System.out.println("Book Name: "+b.getBookName());
                List<Author> authorList=b.getAuthorList();
                System.out.println("Author Name: ");
                for (Author a : authorList) {
                    System.out.println(a.getAuthorName());
                }
            }
            System.out.println("====================================");
        }
    }
}

