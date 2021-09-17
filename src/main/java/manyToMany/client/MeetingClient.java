package manyToMany.client;

import manyToMany.models.Attendee;
import manyToMany.models.Meeting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MeetingClient {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BugTracker");
        EntityManager em = emf.createEntityManager();
        //create attendees
        em.getTransaction().begin();

        for(Attendee attendee : createAttendees()) {
            em.persist(attendee);
        }
        //create meetings

        for(Meeting meeting : createMeetings()) {
            em.persist(meeting);
        }

        em.getTransaction().commit();

        //schedule all attendees to daily scrum meeting
        Query q = em.createQuery("select m from Meeting m where m.mtitle =: mname", Meeting.class);
        q.setParameter("mname", "Daily Scrum Meeting");
        Meeting scrum = (Meeting) q.getResultList().get(0);


        List<Attendee> attendeesList = em.createNamedQuery("Attendees.findAll").getResultList();
        em.getTransaction().begin();
        for(Attendee attendee : attendeesList) {
            attendee.getMeetings().add(scrum);
            scrum.getAttendeesList().add(attendee);
        }

        em.getTransaction().commit();

        Query q1 = em.createQuery("select a from Attendee a where a.name = ?1", Attendee.class);
        q1.setParameter(1, "Steve Jobs");
        Attendee sj = (Attendee) q1.getResultList().get(0);

        q.setParameter("mname", "Safety Meeting");
        Meeting safety = (Meeting) q.getResultList().get(0);

        em.getTransaction().begin();
        sj.getMeetings().add(safety);
        safety.getAttendeesList().add(sj);
        em.getTransaction().commit();

        em.close();
        emf.close();





    }

    private static List<Meeting> createMeetings() {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting("Daily Scrum Meeting"));
        meetings.add(new Meeting("Safety Meeting"));
        meetings.add(new Meeting("Wellbeing Meeting"));
        return meetings;
    }

    private static List<Attendee> createAttendees() {
        List<Attendee> attendees = new ArrayList<>();
        attendees.add(new Attendee("Steve Jobs"));
        attendees.add(new Attendee("Larry Page"));
        attendees.add(new Attendee("Roobin Wood"));
        return attendees;
    }

}


