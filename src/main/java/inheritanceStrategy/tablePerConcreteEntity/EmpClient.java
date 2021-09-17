package inheritanceStrategy.tablePerConcreteEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpClient {


    public static void main(String[] args) {
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
        EntityManager em = emf.createEntityManager();

        Physician p1 = new Physician(1001, "John", "doctor");
        Admin a1 = new Admin(2001, "Lizzie", "B10");
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(a1);
        em.getTransaction().commit();

        //Polymorphic query
        em.createQuery("select e from Emp e").getResultList().forEach(System.out::println);*/
    }

}
