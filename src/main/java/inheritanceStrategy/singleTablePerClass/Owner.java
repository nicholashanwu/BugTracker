package inheritanceStrategy.singleTablePerClass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue(value = "FoodApp_Owner")
public class Owner extends Client {

    private String shopName;

    public Owner(int cId, String cName, String shopName) {
        super(cId, cName);
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "shopName='" + shopName + '\'' +
                '}';
    }
}
