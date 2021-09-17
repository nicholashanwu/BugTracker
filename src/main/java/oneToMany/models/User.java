package oneToMany.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "S21LibraryUser")
public class User {

    @Id
    private int userId; //do not use uid as it is an oracle keyword
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Book> bookList = new ArrayList<>();

    public User(int userId, String name, List<Book> bookList) {
        this.userId = userId;
        this.name = name;
        this.bookList = bookList;
    }

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", name='" + name + '\'' +
//                ", bookList=" + bookList +
//                '}';
//    }

    public List<Book> getBooks() {
        return bookList;
    }
}
