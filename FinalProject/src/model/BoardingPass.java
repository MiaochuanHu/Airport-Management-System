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
public class BoardingPass {

    private String flightNo;
    private String boardingTime;
    private Seat seat;
    private String baggageCarousel;
    private ArrayList<Luggage> luggageList;
    private String portID; // lmx add

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getBaggageCarousel() {
        return baggageCarousel;
    }

    public void setBaggageCarousel(String baggageCarousel) {
        this.baggageCarousel = baggageCarousel;
    }

    public ArrayList<Luggage> getLuggageList() {
        return luggageList;
    }

    public void setLuggageList(ArrayList<Luggage> luggageList) {
        this.luggageList = luggageList;
    }

    public String getPortID() {
        return portID;
    }

    public void setPortID(String portID) {
        this.portID = portID;
    }

}
