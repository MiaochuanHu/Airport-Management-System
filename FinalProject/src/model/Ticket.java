/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author limingxia
 */
public class Ticket {

    private String ticketID;
    private String flightNo;
    private BoardingPass boardingPass;
    private Double actualPrice;

    // below lmx add
    private Boolean carryDanger; // for secruity check
    private String from;
    private String to;
    private String boardingTime;
    private Boolean issuedGift;
    private Boolean printBoardingPass;
    private Boolean isBorderCheck;
    
    private String laggageList;
    private String port;
    private String idSeat;

    public Ticket() {

    }

    public Ticket(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }

    public void setBoardingPass(BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Boolean getCarryDanger() {
        return carryDanger;
    }

    public void setCarryDanger(Boolean carryDanger) {
        this.carryDanger = carryDanger;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public Boolean getIssuedGift() {
        return issuedGift;
    }

    public void setIssuedGift(Boolean issuedGift) {
        this.issuedGift = issuedGift;
    }

    public Boolean getPrintBoardingPass() {
        return printBoardingPass;
    }

    public void setPrintBoardingPass(Boolean printBoardingPass) {
        this.printBoardingPass = printBoardingPass;
    }

    public Boolean getIsBorderCheck() {
        return isBorderCheck;
    }

    public void setIsBorderCheck(Boolean isBorderCheck) {
        this.isBorderCheck = isBorderCheck;
    }

    public String getLaggageList() {
        return laggageList;
    }

    public void setLaggageList(String laggageList) {
        this.laggageList = laggageList;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(String idSeat) {
        this.idSeat = idSeat;
    }
    
    
    
    @Override
    public String toString() {
        return getTicketID();
    }

}
