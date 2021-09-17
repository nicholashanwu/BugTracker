package manyToMany.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "S21Meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Meeting_seq")
    @SequenceGenerator(name = "Meeting_seq", sequenceName = "S2", initialValue = 500)
    private int mid;
    private String mtitle;

    @ManyToMany(mappedBy = "meetings")
    private List<Attendee> attendeesList = new ArrayList<>();

    public Meeting() {

    }

    public Meeting(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public List<Attendee> getAttendeesList() {
        return attendeesList;
    }

    public void setAttendeesList(List<Attendee> attendeesList) {
        this.attendeesList = attendeesList;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "mid=" + mid +
                ", mtitle='" + mtitle + '\'' +
                '}';
    }
}
