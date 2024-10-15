/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author limingxia
 */
public class EntryExitRcd {

    private String immId;
    private String passportNumber;
    private String date;
    private String from; // country leave from
    private String to; //country entry
    private Boolean withDanger; // danger?
    private String comments;

    public String getImmId() {
        return immId;
    }

    public void setImmId(String immId) {
        this.immId = immId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Boolean getWithDanger() {
        return withDanger;
    }

    public void setWithDanger(Boolean withDanger) {
        this.withDanger = withDanger;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return getDate();
    }
}
