package Model;

public class OrderDetails {

    private String O_id;
    private String Cheif_id;
    private String timeSpent;
    private String proccesingTime;
    private String OrderFinishTime;
    private int Qty;

    public OrderDetails() {
    }

    public OrderDetails(String O_id, String Cheif_id, String timeSpent, String proccesingTime, String OrderFinishTime, int Qty) {
        this.O_id = O_id;
        this.Cheif_id = Cheif_id;
        this.timeSpent = timeSpent;
        this.proccesingTime = proccesingTime;
        this.OrderFinishTime = OrderFinishTime;
        this.Qty = Qty;
    }
    
    

    /**
     * @return the O_id
     */
    public String getO_id() {
        return O_id;
    }

    /**
     * @param O_id the O_id to set
     */
    public void setO_id(String O_id) {
        this.O_id = O_id;
    }

    /**
     * @return the Cheif_id
     */
    public String getCheif_id() {
        return Cheif_id;
    }

    /**
     * @param Cheif_id the Cheif_id to set
     */
    public void setCheif_id(String Cheif_id) {
        this.Cheif_id = Cheif_id;
    }

    /**
     * @return the timeSpent
     */
    public String getTimeSpent() {
        return timeSpent;
    }

    /**
     * @param timeSpent the timeSpent to set
     */
    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    /**
     * @return the proccesingTime
     */
    public String getProccesingTime() {
        return proccesingTime;
    }

    /**
     * @param proccesingTime the proccesingTime to set
     */
    public void setProccesingTime(String proccesingTime) {
        this.proccesingTime = proccesingTime;
    }

    /**
     * @return the OrderFinishTime
     */
    public String getOrderFinishTime() {
        return OrderFinishTime;
    }

    /**
     * @param OrderFinishTime the OrderFinishTime to set
     */
    public void setOrderFinishTime(String OrderFinishTime) {
        this.OrderFinishTime = OrderFinishTime;
    }

    /**
     * @return the Qty
     */
    public int getQty() {
        return Qty;
    }

    /**
     * @param Qty the Qty to set
     */
    public void setQty(int Qty) {
        this.Qty = Qty;
    }

}
