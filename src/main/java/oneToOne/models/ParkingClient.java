package oneToOne.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ParkingClient {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
        EntityManager em = emf.createEntityManager();

        Tenant t1 = new Tenant(1, "John Doe");
        Tenant t2 = new Tenant(2, "Johnny Doe");
        Tenant t3 = new Tenant(3, "Sandra Park");
        Tenant t4 = new Tenant(4, "Alex Burr");
        Tenant t5 = new Tenant(5, "Gary Moore");

        em.getTransaction().begin();
        em.persist(t1);
        em.persist(t2);
        em.persist(t3);
        em.persist(t4);
        em.persist(t5);

        // create and persist the parkingLots
        for(ParkingLot pl : createParkingLots()) {
            em.persist(pl);
        }

//        em.getTransaction().commit();

        // assign parkingLots to existing tenants
//        em.getTransaction().begin();
        Tenant managedt2 = em.find(Tenant.class, 2);
        ParkingLot managed102 = em.find(ParkingLot.class, 102);
        managed102.setTenant(managedt2);
        em.getTransaction().commit();


        Tenant t7 = new Tenant(115, "Marc Lam");
        ParkingLot managed103 = em.find(ParkingLot.class, 103);
//        em.getTransaction().begin();
        em.persist(t7);
        managed103.setTenant(t7);
        em.getTransaction().commit();
    }

    private static List<ParkingLot> createParkingLots() {
        List<ParkingLot> lots = new ArrayList<>();
        lots.add(new ParkingLot(101, "B1"));
        lots.add(new ParkingLot(102, "B11"));
        lots.add(new ParkingLot(103, "B2"));
        lots.add(new ParkingLot(124, "B34"));
        lots.add(new ParkingLot(121, "B54"));
        lots.add(new ParkingLot(123, "B54"));

        return lots;
    }
}
