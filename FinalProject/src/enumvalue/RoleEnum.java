/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enumvalue;

/**
 *
 * @author limingxia
 */
public enum RoleEnum {

    // admin 
    SYSTEM_ADMIN("System Admin", 1),
    AIRPORT_ADMIN("Airport Admin", 2),
    SERVICE_ADMIN("Service Admin", 3),
    GOVERN_ADMIN("Govern Admin", 4),
    AIRBUS_ADMIN("Airbus Admin", 5),
    // other
    PASSENGER("Passenger", 6),
    CUSTOMS("Customs", 7),
    GREETER("Greeter", 8), // yin bin yuan
    SALESMAN("Salesman", 9),
    FLIGHTCREW("Flight Crew", 10), // jizu
    COUNTER("Counter", 11),
    PICKUP("Pickup", 12),
    TRAFFICCONTROL("Traffic Control", 13),
    // GROUND("Ground", 14),
    // LABORSUPERVISOR("Labor Supervisor", 15), // hou qin zhu guan
    CONDUCTOR("Conductor", 16), // sale ticket
    POLICEMAN("Security Policeman", 17),;

    private String role;
    private int index;

    /**
     * RoleEnum Constructor
     *
     * @param name
     * @param index
     */
    RoleEnum(String name,
            int index
    ) {
        this.role = name;
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
