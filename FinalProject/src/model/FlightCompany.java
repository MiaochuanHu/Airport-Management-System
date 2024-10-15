/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.PersonDao;
import java.util.ArrayList;
import java.util.Objects;
import utils.CheckUtils;

/**
 *
 * @author limingxia
 */
public class FlightCompany {

    private Integer fcID;
    private String fcName;
    private ArrayList<Flight> flightList;
    private String counterList;
    private ArrayList<String> crewList;
    private String admin; // lmx add

    public FlightCompany() {
    }

    public FlightCompany(Integer fcID) {
        this.fcID = fcID;
    }

    public FlightCompany(String fcName, String admin) {
        this.admin = admin;
        this.fcName = fcName;
    }

    public FlightCompany(Integer fcID, String fcName, String admin, String counter) {
        this.fcID = fcID;
        this.admin = admin;
        this.fcName = fcName;
        this.counterList = counter;
    }

    public FlightCompany(String fcName, String admin, String counter) {
        this.admin = admin;
        this.fcName = fcName;
        this.counterList = counter;
    }

    public FlightCompany(Integer fcID, String fcName) {
        this.fcID = fcID;
        this.fcName = fcName;
    }

    public Integer getFcID() {
        return fcID;
    }

    public void setFcID(Integer fcID) {
        this.fcID = fcID;
    }

    public String getFcName() {
        return fcName;
    }

    public void setFcName(String fcName) {
        this.fcName = fcName;
    }

    public ArrayList<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(ArrayList<Flight> flightList) {
        this.flightList = flightList;
    }

    public String getCounterList() {
        return counterList;
    }

    public void setCounterList(String counterList) {
        this.counterList = counterList;
    }

    public ArrayList<String> getCrewList() {
        return crewList;
    }

    public void setCrewList(ArrayList<String> crewList) {
        this.crewList = crewList;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return fcName;
    }

    public String checkField() {
        String warning = "";

        if (!CheckUtils.checkEmail(admin)) {
            warning = "Please Check Admin Email!";
            return warning;

        }

        // email
        // ** MUST BE UNQIUE ** //
        if (!Objects.isNull(PersonDao.queryLoginByAccount(admin))) {
            warning = "This Admin Has Signed Up, Change Another One!";
            return warning;
        }

        return warning;
    }
}
