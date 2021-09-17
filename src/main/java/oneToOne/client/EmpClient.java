package oneToOne.client;

import oneToOne.models.Account;
import oneToOne.models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpClient {

    public static void main(String[] args) {

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
        EntityManager em = emf.createEntityManager();

        // persist account and employee

        Account a1 = new Account(111, "Savings");
        Employee e1 = new Employee(1001, "John Doe", a1);

        Account a2 = new Account(112, "Checking");
        Employee e2 = new Employee(1002, "Jane Doe", a2);

        Account a3 = new Account(113, "Business");
        Employee e3 = new Employee(1003, "David Tan", a3);


        em.getTransaction().begin();
        em.persist(e1);
        a1.setEmployee(e1);
        em.persist(a1);

        em.persist(e2);
        a1.setEmployee(e2);
        em.persist(a2);

        em.persist(e3);
        a1.setEmployee(e3);
        em.persist(a3);

        em.getTransaction().commit();

        //find e3

        Employee managede3 = em.find(Employee.class, 1003);
        System.out.println(managede3.getAccount());
*/




    }
}
