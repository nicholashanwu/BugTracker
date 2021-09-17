package oneToOne.models;

import javax.persistence.*;

//@Entity
//@Table(name = "S21PL")
public class ParkingLot {
    @Id
    private int plId;
    private String buildingName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_tenant_Id")
    private Tenant tenant;




    public ParkingLot(int plId, String buildingName) {
        this.plId = plId;
        this.buildingName = buildingName;
    }

    public int getPlId() {
        return plId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "plId=" + plId +
                ", buildingName='" + buildingName + '\'' +
                ", tenant=" + tenant +
                '}';
    }
}
