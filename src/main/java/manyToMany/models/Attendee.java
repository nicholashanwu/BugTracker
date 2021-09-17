package manyToMany.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "S21Attendee")
@NamedQuery(name = "Attendees.findAll", query = "select a from Attendee a")
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int attendeeId;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "S21MeetingAttendees",
            joinColumns =   @JoinColumn(name = "FK_attendee_id"),
            inverseJoinColumns = @JoinColumn(name = "FK_meeting_id")
            )

    private List<Meeting> meetings = new ArrayList<>();

    public Attendee() {

    }

    public Attendee(String name) {
        this.name = name;
    }

    public int getId() {
        return attendeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "attendeeId=" + attendeeId +
                ", name='" + name + '\'' +
                '}';
    }
}
