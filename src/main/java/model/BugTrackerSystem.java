package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class BugTrackerSystem {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
        EntityManager em = emf.createEntityManager();

        Tester t1 = new Tester("tester1", "password");


        Developer d1 = new Developer("nicholas.wu", "password");


        em.getTransaction().begin();
        em.persist(t1);
        em.persist(d1);
        em.getTransaction().commit();

        em.getTransaction().begin();

//        em.createQuery("select t.userId from bug where ")

        t1.submitBug(new Bug("summary", "description", t1.getUserId(), new ArrayList<>(), Bug.Severity.HIGH, Bug.Status.OPEN));




    }
}
