package inheritanceStrategy.tablePerConcreteEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "S_21Admin")
public class Admin extends Emp {

    private String deskNo;

    public Admin(int eId, String eName, String deskNo) {
        super(eId, eName);
        this.deskNo = deskNo;
    }

    public String getDeskNo() {
        return deskNo;
    }

    public void setDeskNo(String deskNo) {
        this.deskNo = deskNo;
    }
}
