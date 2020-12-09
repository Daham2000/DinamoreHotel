package Model;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class CustomOrder implements Serializable{

    private int teleNum;
    private int Qty;
    private int TOid;
    private LocalDateTime OrderTime;
    private String Customername;
    private int teleOparatorID;
    private String O_id;
    private String chefID;
    private String ProcceingTime;
    private String timeSpend;
    private String Or_finishTime;

    public CustomOrder() throws RemoteException {

    }
    
    @Override
    public String toString() {
        return Customername + "-" + O_id;
    }

    public CustomOrder(String O_id, int teleNum, int Qty, String OrderTime, int teleOparatorID) throws RemoteException {

    }

    public CustomOrder(String O_id, int telenum, int qty, int TOid, String Customername, LocalDateTime OrderTime) throws RemoteException {
        this.teleNum = telenum;
        this.Qty = qty;
        this.TOid = TOid;
        this.Customername = Customername;
        this.O_id = O_id;
        this.OrderTime = OrderTime;
    }

    /**
     * @return the teleNum
     */
    public int getTeleNum() throws RemoteException {
        return teleNum;
    }

    /**
     * @param teleNum the teleNum to set
     */
    public void setTeleNum(int teleNum) throws RemoteException {
        this.teleNum = teleNum;
    }

    /**
     * @return the Qty
     */
    public int getQty() throws RemoteException {
        return Qty;
    }

    /**
     * @param Qty the Qty to set
     * @throws java.rmi.RemoteException
     */
    public void setQty(int Qty) throws RemoteException {
        this.Qty = Qty;
    }

    /**
     * @return the TOid
     */
    public int getTOid() throws RemoteException {
        return TOid;
    }

    /**
     * @param TOid the TOid to set
     */
    public void setTOid(int TOid) throws RemoteException {
        this.TOid = TOid;
    }

    /**
     * @return the prossingtime
     * @throws java.rmi.RemoteException
     */
    public LocalDateTime getOrderTime() throws RemoteException {
        return OrderTime;
    }

    /**
     * @param prossingtime the prossingtime to set
     */
    public void setOrderTime(LocalDateTime OrderTime) throws RemoteException {
        this.OrderTime = OrderTime;
    }

    /**
     * @return the teleOparatorID
     */
    public int getTeleOparatorID() throws RemoteException {
        return teleOparatorID;
    }

    /**
     * @param teleOparatorID the teleOparatorID to set
     */
    public void setTeleOparatorID(String Customername) throws RemoteException {
        this.setCustomername(Customername);
    }

    /**
     * @return the Customername
     */
    public String getCustomername() throws RemoteException {
        return Customername;
    }

    /**
     * @param Customername the Customername to set
     */
    public void setCustomername(String Customername) throws RemoteException {
        this.Customername = Customername;
    }

    /**
     * @param teleOparatorID the teleOparatorID to set
     */
    public void setTeleOparatorID(int teleOparatorID) throws RemoteException {
        this.teleOparatorID = teleOparatorID;
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
     * @return the chefID
     */
    public String getChefID() {
        return chefID;
    }

    /**
     * @param chefID the chefID to set
     */
    public void setChefID(String chefID) {
        this.chefID = chefID;
    }

    /**
     * @return the ProcceingTime
     */
    public String getProcceingTime() {
        return ProcceingTime;
    }

    /**
     * @param ProcceingTime the ProcceingTime to set
     */
    public void setProcceingTime(String ProcceingTime) {
        this.ProcceingTime = ProcceingTime;
    }

    /**
     * @return the timeSpend
     */
    public String getTimeSpend() {
        return timeSpend;
    }

    /**
     * @param timeSpend the timeSpend to set
     */
    public void setTimeSpend(String timeSpend) {
        this.timeSpend = timeSpend;
    }

    /**
     * @return the Or_finishTime
     */
    public String getOr_finishTime() {
        return Or_finishTime;
    }

    /**
     * @param Or_finishTime the Or_finishTime to set
     */
    public void setOr_finishTime(String Or_finishTime) {
        this.Or_finishTime = Or_finishTime;
    }

}
