package oneToOne.models;

import javax.persistence.*;

//@Entity
//@Table(name = "S21Tenant")
public class Tenant {
    @Id
    private int tenantId;
    private String tenantName;

    @OneToOne(mappedBy = "tenant")
    private ParkingLot parkingLot;




    public Tenant(int tenantId, String tenantName) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
    }


    public int getTenantId() {
        return tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantId=" + tenantId +
                ", tenantName='" + tenantName + '\'' +
                ", parkingLot=" + parkingLot +
                '}';
    }
}
