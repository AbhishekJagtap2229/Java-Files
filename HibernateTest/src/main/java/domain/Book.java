package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
@Entity
@Table(name = "book_info")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "book_name")
    private String bookName;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_ref"),
            inverseJoinColumns = @JoinColumn(name = "author_ref")
    )
    private List<Author> authorList;

    public void addAuthor(Author authorRef){
        if (authorList==null){
            authorList=new LinkedList<>();
        }
        authorList.add(authorRef);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
