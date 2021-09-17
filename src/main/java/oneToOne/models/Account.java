package oneToOne.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "S21Acc")
public class Account {
    @Id
    private int accId;
    private String accType;

    //bidirectional
    @OneToOne(mappedBy = "account")
    private Employee employee;


    public Account(int accId, String accType) {
        this.accId = accId;
        this.accType = accType;
    }

    public Account(int accId, String accType, Employee employee) {
        this.accId = accId;
        this.accType = accType;
        this.employee = employee;
    }

    public int getAccId() {
        return accId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public void setEmployee(Employee e1) {
        this.employee = e1;
    }

    @Override
    public String toString() {
        return "Acct{" +
                "accId=" + accId +
                ", accType='" + accType + '\'' +
                ", employee=" + employee +
                '}';
    }
}
