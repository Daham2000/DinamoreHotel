package Model;

import java.time.LocalDateTime;

public class Order {
    private String O_id;
    private LocalDateTime O_time;
    private int TeleOprtrID;
    private String C_name;

    public Order(String O_id, LocalDateTime O_time, int TeleOprtrID, String C_name) {
        this.O_id = O_id;
        this.O_time = O_time;
        this.TeleOprtrID = TeleOprtrID;
        this.C_name = C_name;
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
     * @return the O_time
     */
    public LocalDateTime getO_time() {
        return O_time;
    }

    /**
     * @param O_time the O_time to set
     */
    public void setO_time(LocalDateTime O_time) {
        this.O_time = O_time;
    }

    /**
     * @return the TeleOprtrID
     */
    public int getTeleOprtrID() {
        return TeleOprtrID;
    }

    /**
     * @param TeleOprtrID the TeleOprtrID to set
     */
    public void setTeleOprtrID(int TeleOprtrID) {
        this.TeleOprtrID = TeleOprtrID;
    }

    /**
     * @return the C_name
     */
    public String getC_name() {
        return C_name;
    }

    /**
     * @param C_name the C_name to set
     */
    public void setC_name(String C_name) {
        this.C_name = C_name;
    }
}
