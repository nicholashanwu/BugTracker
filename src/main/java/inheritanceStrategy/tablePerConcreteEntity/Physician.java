package inheritanceStrategy.tablePerConcreteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "S_21Physician")
public class Physician extends Emp {

    private String specialization;

    public Physician(int eId, String eName, String specialization) {
        super(eId, eName);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


}
