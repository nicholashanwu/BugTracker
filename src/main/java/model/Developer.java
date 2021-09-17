package model;

import manyToMany.models.Attendee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Developer extends User{

    @ManyToMany
    @JoinTable(
            name = "BugResolution",
            joinColumns = @JoinColumn(name = "FK_developer_id"),
            inverseJoinColumns = @JoinColumn(name = "FK_bug_id")
    )
    private List<Bug> assignedBugList;

    // when a new developer is added, they will not immediately have bugs to fix
    public Developer(String username, String password) {
        super(username, password);
        this.assignedBugList = new ArrayList<>();
    }

//    public Developer(String username, String password, List<Bug> assignedBugList) {
//        super(username, password);
//        this.assignedBugList = new ArrayList<>();
//    }

    public void resolveBug(int bugId) {
        //set bug status as resolved
    }

    public void escalateBug(int bugId) {
        //send bug to another developer?
    }

    public List<Bug> getAssignedBugList() {
        return assignedBugList;
    }

    public void assignBug (Bug bug) {
        this.assignedBugList.add(bug);

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        this.getAssignedBugList().add(bug);
//        bug.setAssignedTo(this);
//        em.getTransaction().commit();
////
////        em.createQuery("update Developer d set d.assignedBugList = ?1 where d.userid = ?2");
////        em.setProperty(1, bug.getBugId());
////        em.setProperty(2, getUserId());
////
////
////
////        for(Attendee attendee : attendeesList) {
////            attendee.getMeetings().add(scrum);
////            scrum.getAttendeesList().add(attendee);
////        }
//
//        em.getTransaction().commit();


    }

    @Override
    public String toString() {
        return "Developer{" +
                "assignedBugList=" + assignedBugList +
                '}';
    }
}
