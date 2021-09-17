package inheritanceStrategy.singleTablePerClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue(value = "FoodApp_Customer")
public class Customer extends Client{

    private String history;

    public Customer(int cId, String cName, String history) {
        super(cId, cName);
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
