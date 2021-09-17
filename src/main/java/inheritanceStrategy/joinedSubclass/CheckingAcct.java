package inheritanceStrategy.joinedSubclass;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "S_21CA")
public class CheckingAcct extends Acct{

    private double minBalance;

    public CheckingAcct() {

    }

    public CheckingAcct(double balance, double minBalance) {
        super(balance);
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}
