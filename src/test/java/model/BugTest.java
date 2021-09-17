package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BugTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
    EntityManager em = emf.createEntityManager();

    @BeforeEach
    void init() {
        em.getTransaction().begin();
        Query clearRecords = em.createQuery("DELETE FROM Bug");
        clearRecords.executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    void Test_AddNewBug() {

        Bug b1 = new Bug("b1", "description", 0, new ArrayList<>(), Bug.Severity.HIGH, Bug.Status.OPEN);

        em.getTransaction().begin();
        em.persist(b1);
        em.getTransaction().commit();

        Query q1 = em.createQuery("select b from Bug b where b.summary = ?1", Bug.class);
        q1.setParameter(1, "b1");

        System.out.println("////////////////////////////////////////");
        q1.getResultList().forEach(System.out::println);

    }

}

//
//
//        Query q1 = em.createQuery("select a from Attendee a where a.name = ?1", Attendee.class);
//        q1.setParameter(1, "Steve Jobs");
//        Attendee sj = (Attendee) q1.getResultList().get(0);
//
//
//        em.getTransaction().begin();
//        sj.getMeetings().add(safety);
//        safety.getAttendeesList().add(sj);
//        em.getTransaction().commit();
//
//        em.close();
//        emf.close();
//

//        Query q1 = em.createQuery("select a from Attendee a where a.name = ?1", Attendee.class);





