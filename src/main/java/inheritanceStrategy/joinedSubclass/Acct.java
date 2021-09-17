package inheritanceStrategy.joinedSubclass;

import javax.persistence.*;

//@Entity
//@Table(name = "S_21Account")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Acct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aId;
    private double balance;

    public Acct() {

    }

    public Acct(double balance) {
        this.balance = balance;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
