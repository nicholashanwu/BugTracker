package oneToMany.models;

import javax.persistence.*;

//@Entity
//@Table(name = "S21Book2")
public class Book {

    @Id
    private int bookId;
    private String bookName;

    // many books can be borrowed by one user
    @ManyToOne
    @JoinColumn(name = "FK_userId")
    private User user;


    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "bookId=" + bookId +
//                ", bookName='" + bookName + '\'' +
//                ", user=" + user +
//                '}';
//    }
}
