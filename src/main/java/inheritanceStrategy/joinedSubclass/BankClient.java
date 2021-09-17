package inheritanceStrategy.joinedSubclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BankClient {

    public static void main(String[] args) {

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
        EntityManager em = emf.createEntityManager();

        CheckingAcct ca = new CheckingAcct(5000, 2000);
        SavingsAcct sa = new SavingsAcct(5000, 2.3);

        em.getTransaction().begin();
        em.persist(ca);
        em.persist(sa);
        em.getTransaction().commit();

        em.createQuery("select a from Account a").getResultList().forEach(System.out::println);


        CheckingAcct m_ca = em.find(CheckingAcct.class, 28);
        em.getTransaction().begin();
        em.remove(m_ca);
        em.getTransaction().commit();
        em.createQuery("select a from Account a").getResultList().forEach(System.out::println);*/

    }
}
