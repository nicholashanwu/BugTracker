package model;

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

    public void resolveBug(int bugId) {
        //set bug status as resolved
    }

    public void escalateBug(int bugId) {
        //send bug to another developer?
    }

    public List<Bug> getAssignedBugList() {
        return assignedBugList;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "assignedBugList=" + assignedBugList +
                '}';
    }
}
