package api.payloads;

public class Order {

    int id;
    int petid;
    int quantity;
    String shipdate;
    String status;
    Boolean complete;


    public void setId(int id) {
        this.id = id;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public void setQuantity(int quantity) {
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

    public int getId() {
        return id;
    }

    public int getPetid() {
        return petid;
    }

    public int getQuantity() {
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
