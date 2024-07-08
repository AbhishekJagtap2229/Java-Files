package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name = "author_info")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int authorId;
    @Column(name = "author_name")
    private String authorName;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "author_ref"),
            inverseJoinColumns = @JoinColumn(name = "book_ref")
    )
    private List<Book> bookList;

    public void addBook(Book bookRef){
        if (bookList==null){
            bookList=new LinkedList<>();
        }
        bookList.add(bookRef);
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
