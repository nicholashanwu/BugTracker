package inheritanceStrategy.joinedSubclass;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "S_21AC")
public class SavingsAcct extends Acct{

    private double interestRate;



    public SavingsAcct(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
