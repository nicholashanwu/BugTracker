package oneToMany.client;

import manyToMany.models.Attendee;
import oneToMany.models.Book;
import oneToMany.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LibClient {

    public static void main(String[] args){

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
        EntityManager em = emf.createEntityManager();

        // create a new u



        /////////////////////////////////////////////////

        // create Books
        em.getTransaction().begin();
        for(Book book : createBooks()){
            em.persist(book);
        }
        em.getTransaction().commit();

        // user joins
        User u1 = new User(122, "John Doe");
        em.getTransaction().begin();
        em.persist(u1);
        em.getTransaction().commit();

        // user borrows java-related books
        List<Book> result = em.createQuery("select b from Book b where b.bookName like '%Java%'", Book.class).getResultList();
        User managed_JD = em.find(User.class, 122);
        em.getTransaction().begin();

        for(Book b : result) {
            b.setUser(managed_JD);
            managed_JD.getBooks().add(b);
        }
        em.getTransaction().commit();


        // verify that user has borrowed the books
        managed_JD = em.find(User.class, 122);
        for(Book book : managed_JD.getBooks()) {
            System.out.println(book);
        }
*/


    }

    private static List<Book> createBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "Java in Action"));
        books.add(new Book(102, "C++"));
        books.add(new Book(103, "Head First Java"));
        books.add(new Book(104, "Advanced Java"));
        books.add(new Book(105, "Python for beginners"));
        return books;
    }


}
