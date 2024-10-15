/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumvalue;

/**
 *
 * @author limingxia
 */
public enum FlightStatus {

    NORMAL("normal", 0),
    DELAY("delay", 1),
    CANCEL("cancel", 2);

    private String status;
    private int index;

    /**
     * GenderEnum Constructor
     *
     * @param status
     * @param index
     */
    FlightStatus(String status, int index) {
        this.status = status;
        this.index = index;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
