package inheritanceStrategy.singleTablePerClass;

import javax.persistence.*;

//@Entity
//@Table(name = "S_21Client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Client_Type", discriminatorType = DiscriminatorType.STRING)
public class Client {
    @Id
    private int cId;
    private String cName;

    public Client(int cId, String cName) {
        this.cId = cId;
        this.cName = cName;
    }

    public int getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }


}
