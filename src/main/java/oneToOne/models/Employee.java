package oneToOne.models;

import javax.persistence.*;

//@Entity
//@Table(name = "S21Emp")
public class Employee {
    @Id
    @Column(name = "Emp_Id")
    private int eid;
    @Column(name = "Emp_Name")
    private String ename;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_AccNo")
    private Account account;

    public Employee(int eid, String ename, Account account) {
        this.eid = eid;
        this.ename = ename;
        this.account = account;
    }

    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", account=" + account +
                '}';
    }
}
