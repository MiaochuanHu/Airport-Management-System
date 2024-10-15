/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author limingxia
 */
public class Flight {

    private String flightNo;
    private FlightCompany flightCompany;
    private String duration;
    private Integer status; // 正常0，延误1, 取消2
    private ArrayList<Seat> seatList;
    private Boolean onGround;
    private Integer parkingLot;
    private Boolean DepartureOrArrival;//ture departure, false arrival
    private String airport;
    private String seatStr;

    //if ture, set below attribute
    //if false, set below attribute
    private String baggageCarousel;

    // lmx add
    private String departTime;
    private String arrTime;

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public FlightCompany getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(FlightCompany flightCompany) {
        this.flightCompany = flightCompany;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(ArrayList<Seat> seatList) {
        this.seatList = seatList;
    }

    public Boolean getOnGround() {
        return onGround;
    }

    public void setOnGround(Boolean onGround) {
        this.onGround = onGround;
    }

    public Integer getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(Integer parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Boolean getDepartureOrArrival() {
        return DepartureOrArrival;
    }

    public void setDepartureOrArrival(Boolean DepartureOrArrival) {
        this.DepartureOrArrival = DepartureOrArrival;
    }

    public String getBaggageCarousel() {
        return baggageCarousel;
    }

    public void setBaggageCarousel(String baggageCarousel) {
        this.baggageCarousel = baggageCarousel;
    }

    public String getSeatStr() {
        return seatStr;
    }

    public void setSeatStr(String seatStr) {
        this.seatStr = seatStr;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    @Override
    public String toString() {
        return getFlightNo();
    }

    public String SeatListGenerator(int bNo, int eNo, String bPrice, String ePrice, String flightNo) {

        String seatlistStr = bNo + "," + bPrice + "," + eNo + "," + ePrice + ",";
        for (int i = 0; i <= bNo; i++) {
            seatlistStr += flightNo + i + "B,";
        }
        for (int i = 1; i <= eNo; i++) {
            seatlistStr += flightNo + i + "E,";
        }

        return seatlistStr;
    }

}
