package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TesterTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
    EntityManager em = emf.createEntityManager();

    @Mock
    Bug bug;

    @BeforeEach
    void init() {
        em.getTransaction().begin();
        Query clearTesterRecords = em.createQuery("DELETE FROM Tester");
        Query clearBugRecords = em.createQuery("DELETE FROM Bug");

        clearTesterRecords.executeUpdate();
        clearBugRecords.executeUpdate();
        em.getTransaction().commit();

        MockitoAnnotations.openMocks(this);

    }

    @Test
    void Test_TesterSubmitsNewBug() {

        // persist a new tester
        Tester t1 = new Tester("t1", "password");

        em.getTransaction().begin();
        em.persist(t1);
        em.getTransaction().commit();

        // get the userId of that new tester
        Query q1 = em.createQuery("select t from Tester t where t.username = ?1", Tester.class);
        q1.setParameter(1, "t1");
        Tester t2 = (Tester) q1.getSingleResult();
        int testerId = t2.getUserId();

        // submit a bug as that tester
        t2.submitBug(new Bug("testBugSubmission", "description", t2.getUserId(), new ArrayList<>(), Bug.Severity.HIGH, Bug.Status.OPEN));

        //check that the bug has the userId of the tester that created it in its foundBy attribute
        Query q2 = em.createQuery("select b from Bug b where b.summary = ?1", Bug.class);
        q2.setParameter(1, "testBugSubmission");
        Bug b1 = (Bug) q2.getSingleResult();
        assertEquals(testerId, b1.getFoundBy());

    }

    @Test
    void Test_ChangeBugStatus() {

        // submit new bug with Status.OPEN
        Bug b1 = new Bug("b1", "description", 0, new ArrayList<>(), Bug.Severity.HIGH, Bug.Status.CLOSED);
        em.getTransaction().begin();
        em.persist(b1);
        em.getTransaction().commit();



        // update that bug with Status.CLOSED
        Query q1 = em.createQuery("update Bug b set b.status = ?1 where b.summary = ?2");
        em.getTransaction().begin();
        q1.setParameter(1, Bug.Status.OPEN);
        q1.setParameter(2, "b1");
        q1.executeUpdate();
        em.flush();
        em.getTransaction().commit();


        Query q2 = em.createQuery("select b from Bug b where b.summary = ?1", Bug.class);

        q2.setParameter(1, "b1");
        Bug b2 = (Bug) q2.getSingleResult();
        System.out.println(b1);
        System.out.println(b2);

        assertEquals(Bug.Status.OPEN, b2.getStatus());

    }

}