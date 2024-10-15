/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumvalue;

/**
 *
 * @author limingxia
 */
public enum SeatEnum {

    FIRST_CLASS("first class", 0),
    ECONOMY_CLASS("economy class", 1);
//    PREFER_NOT_TO_SAY("prefer not to say", 2);

    private String level;
    private int index;

    /**
     * SeatEnum Constructor
     *
     * @param level
     * @param index
     */
    SeatEnum(String level, int index) {
        this.level = level;
        this.index = index;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
