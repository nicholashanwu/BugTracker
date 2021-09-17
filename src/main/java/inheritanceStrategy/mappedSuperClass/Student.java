package inheritanceStrategy.mappedSuperClass;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "S21_Student")
public class Student extends User{

    private String className;

    public Student(int userId, String name, String password, String className) {
        super(userId, name, password);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
