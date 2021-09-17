package inheritanceStrategy.mappedSuperClass;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "S21_Librarian")
public class Librarian extends User{

    private double salary;

    public Librarian(int userId, String name, String password, double salary) {
        super(userId, name, password);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
