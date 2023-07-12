package api.payloads;

public class Order {

    String id;
    String petid;
    String quantity;
    String shipdate;
    String status;
    Boolean complete;


    public void setId(String id) {
        this.id = id;
    }

    public void setPetid(String petid) {
        this.petid = petid;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setShipdate(String shipdate) {
        this.shipdate = shipdate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getId() {
        return id;
    }

    public String getPetid() {
        return petid;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getShipdate() {
        return shipdate;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getComplete() {
        return complete;
    }


}
