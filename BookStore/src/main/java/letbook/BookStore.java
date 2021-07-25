package letbook;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="BookStore_table")
public class BookStore {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String bookName;
    private Long bookId;
    private String bookGenre;
    private String bookStatus;
    private Long payId;

    @PostPersist
    public void onPostPersist() {

        System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□ Book Store PostPersist " + System.currentTimeMillis() + "□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
        System.out.println("Book Store  "+this.getBookStatus());

        if(this.getBookStatus().equals("Book Rented")) {

            BookExported bookExported = new BookExported();

            this.setBookStatus("Book Exported");

            BeanUtils.copyProperties(this, bookExported);
            bookExported.publishAfterCommit();

        } else {
            //if(this.getBookStatus().equals("Book Returned")) {

            BookImported bookImported = new BookImported();

            this.setBookStatus("Book Imported");

            System.out.println("Book Store Import Before");

            BeanUtils.copyProperties(this, bookImported);
            bookImported.publishAfterCommit();

            System.out.println("Book Store Import After");

        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }




}
