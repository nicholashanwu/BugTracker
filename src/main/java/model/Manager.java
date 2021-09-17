package model;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Manager extends User{

    public Manager(String username, String password) {
        super(username, password);
    }

    public void assignBug(int bugId, List<Integer> developerList) {              // assign bug to a developer
    }

    public void viewBacklog() {                                 // show all bugs, employ some sort of filtering/sorting
    }

    public void addUser(User user) {                            // add user to db
    }

    public void deleteUser(int userId) {                        // remove user from db
    }

    public void changeBugSeverity(int bugId, String severity) {
    }

    public void changeBugStatus(int bugId, String status) {
    }

}
