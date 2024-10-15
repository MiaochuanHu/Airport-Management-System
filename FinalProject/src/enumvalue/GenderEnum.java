/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumvalue;

/**
 *
 * @author limingxia
 */
public enum GenderEnum {
    
    MALE("male", 0),
    FEMALE("female", 1),
    PREFER_NOT_TO_SAY("prefer not to say", 2);

    private String role;
    private int index;

    /**
     * GenderEnum Constructor
     * @param gender
     * @param index 
     */
    GenderEnum(String gender, int index) {
        this.role = gender;
        this.index = index;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
