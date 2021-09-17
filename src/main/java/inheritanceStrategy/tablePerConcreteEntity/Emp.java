package inheritanceStrategy.tablePerConcreteEntity;

import javax.persistence.*;

//@Entity
//@Table(name = "S_21Employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Emp {
    @Id
    private int eId;
    private String eName;

    public Emp(int eId, String eName) {
        this.eId = eId;
        this.eName = eName;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }
}
