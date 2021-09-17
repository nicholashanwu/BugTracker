package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
    EntityManager em = emf.createEntityManager();

    @BeforeEach
    void init() {
        em.getTransaction().begin();
        Query clearRecords = em.createQuery("DELETE FROM Developer");
        Query clearBugRecords = em.createQuery("DELETE FROM Bug");
        Query clearTesterRecords = em.createQuery("DELETE FROM Tester");
        clearRecords.executeUpdate();
        clearBugRecords.executeUpdate();
        clearTesterRecords.executeUpdate();
        em.getTransaction().commit();
    }


    // should show all bugs in system that are have OPEN status
    @Test
    void Test_ViewBacklog() {
        // add example bugs
        Bug b1 = new Bug("b1", "description", 0, new ArrayList<>(), Bug.Severity.HIGH, Bug.Status.OPEN);
        Bug b2 = new Bug("b2", "description", 0, new ArrayList<>(), Bug.Severity.MEDIUM, Bug.Status.OPEN);
        Bug b3 = new Bug("b3", "description", 0, new ArrayList<>(), Bug.Severity.LOW, Bug.Status.CLOSED);

        em.getTransaction().begin();
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.getTransaction().commit();

        Query q1 = em.createQuery("select b from Bug b where b.status = ?1", Bug.class);
        q1.setParameter(1, Bug.Status.OPEN);
        List<Bug> bugBacklog = q1.getResultList();
        bugBacklog.forEach(System.out::println);

        // we added two open bugs, so there should only be two in the resultsList
        assertEquals(2, bugBacklog.size());

    }

    // should assign bugs to developers
    @Test
    void Test_AssignBugs() {
        // add example bugs
        Bug b1 = new Bug("b1", "description", 0, new ArrayList<>(), Bug.Severity.HIGH, Bug.Status.OPEN);
        Bug b2 = new Bug("b2", "description", 0, new ArrayList<>(), Bug.Severity.MEDIUM, Bug.Status.OPEN);
        Bug b3 = new Bug("b3", "description", 0, new ArrayList<>(), Bug.Severity.LOW, Bug.Status.CLOSED);

        // add example developers
        Developer d1 = new Developer("nicholas", "123");
        Developer d2 = new Developer("tyrone", "456");
        Developer d3 = new Developer("bill", "789");

        em.getTransaction().begin();
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.persist(d1);
        em.persist(d2);
        em.persist(d3);

        // assign bug b1 to developer d1
        d1.getAssignedBugList().add(b1);
        b1.getAssignedTo().add(d1);

        em.getTransaction().commit();

        // check that b1 is assigned to d1 and d1 is assigned to b1
        assertEquals(d1.getAssignedBugList().get(0).getBugId(), b1.getBugId());
        assertEquals(b1.getAssignedTo().get(0).getUserId(), d1.getUserId());

    }

    @Test
    void Test_AddUsers() {
        // add example developer and tester
        Developer d1 = new Developer("nicholas", "123");
        Tester t1 = new Tester("bill", "321");

        em.getTransaction().begin();
        em.persist(d1);
        em.persist(t1);
        em.getTransaction().commit();

        Developer d2 = (Developer) em.createQuery("select d from Developer d").getSingleResult();
        Tester t2 = (Tester) em.createQuery("select t from Tester t").getSingleResult();

        // check that the developer and tester were added
        assertEquals(d1.getUserId(), d2.getUserId());
        assertEquals(t1.getUserId(), t2.getUserId());

    }

    @Test
    void Test_ChangeBugStatus() {

        // submit new bug with Status.OPEN
        Bug b1 = new Bug("b1", "description", 0, new ArrayList<>(), Bug.Severity.HIGH, Bug.Status.OPEN);
        em.getTransaction().begin();
        em.persist(b1);
        em.getTransaction().commit();

        // update that bug with Status.CLOSED

        em.getTransaction().begin();
//        b1.setStatus(Bug.Status.CLOSED);

        Query q1 = em.createQuery("update Bug b set b.status = ?1 where b.summary = ?2");
        q1.setParameter(1, Bug.Status.OPEN);
        q1.setParameter(2, "b1");
        q1.executeUpdate();

        em.getTransaction().commit();

        Query q2 = em.createQuery("select b from Bug b where b.summary = ?1", Bug.class);

        q2.setParameter(1, "b1");
        Bug b2 = (Bug) q2.getSingleResult();
        System.out.println(b1);
        System.out.println(b2);

        assertEquals("OPEN", b2.getStatus());

    }

    @Test
    void Test_ChangeBugSeverity() {

        // submit new bug with Severity.HIGH
        Bug b1 = new Bug("b1", "description", 0, new ArrayList<>(), Bug.Severity.HIGH, Bug.Status.CLOSED);
        em.getTransaction().begin();
        em.persist(b1);
        em.getTransaction().commit();

        // update that bug with Severity.MEDIUM
//        Query q1 = em.createQuery("update Bug b set b.severity = ?1 where b.summary = ?2");
        em.getTransaction().begin();
//        q1.setParameter(1, Bug.Severity.MEDIUM);
//        q1.setParameter(2, "b1");
//        q1.executeUpdate();
        b1.setSeverity(Bug.Severity.MEDIUM);
        em.getTransaction().commit();


        Query q2 = em.createQuery("select b from Bug b where b.summary = ?1", Bug.class);

        q2.setParameter(1, "b1");
        Bug b2 = (Bug) q2.getSingleResult();
        System.out.println(b1);
        System.out.println(b2);

        assertEquals(Bug.Severity.MEDIUM, b2.getSeverity());

    }


}