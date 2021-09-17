package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Bug {

    enum Severity {
        LOW,
        MEDIUM,
        HIGH
    }

    enum Status {
        RESOLVED,       // 0
        OPEN,           // 1
        CLOSED          // 2
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Bug_seq")
    @SequenceGenerator(name = "Bug_seq", sequenceName = "S1", initialValue = 1000)
    private int bugId;
    private String summary;
    private String description;
    private int foundBy;                // userId of tester
    private Status status;
    private Severity severity;

    @ManyToMany(mappedBy = "assignedBugList")
    private List<Developer> assignedTo;   // userId of developers that the manager assigned bugs to

    public Bug() {

    }

    // not all bugs are immediately assigned to a developer when found
    public Bug(String summary, String description, int foundBy, Severity severity, Status status) {
        this.summary = summary;
        this.description = description;
        this.foundBy = foundBy;
        this.severity = severity;
        this.status = status;
    }

    public Bug(String summary, String description, int foundBy, List<Developer> assignedTo, Severity severity, Status status) {
        this.summary = summary;
        this.description = description;
        this.foundBy = foundBy;
        this.assignedTo = new ArrayList<>();
        this.severity = severity;
        this.status = status;
    }

    public int getBugId() {
        return bugId;
    }

    public void setBugId(int bugId) {
        this.bugId = bugId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFoundBy() {
        return foundBy;
    }

    public void setFoundBy(int foundBy) {
        this.foundBy = foundBy;
    }

    public List<Developer> getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Developer dev) {
        this.assignedTo.add(dev);
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "bugId=" + bugId +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", foundBy=" + foundBy +
                ", status=" + status +
                ", severity=" + severity +
//                ", assignedTo=" + assignedTo +
                '}';
    }

}
