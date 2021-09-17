package model;

import javax.persistence.*;

@Entity
@Table
public class Tester extends User{

    public Tester() {
        super();

    }

    public Tester(String username, String password) {
        super(username, password);
    }

    public void submitBug(Bug bug) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(bug);
        em.getTransaction().commit();

    }

    public void retestBug(int bugId) {
    }

    public void changeBugStatus(int bugId, String status) {
    }
}
