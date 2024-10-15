/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author limingxia
 */
public class Luggage {

    private String luggageID;
    private Double weight;
    private boolean isFragile;

    public Luggage() {
    }

    public Luggage(String luggageID, Double weight, boolean isFragile) {
        this.luggageID = luggageID;
        this.weight = weight;
        this.isFragile = isFragile;
    }

    public Luggage(Double weight, boolean isFragile) {
        this.weight = weight;
        this.isFragile = isFragile;
    }

    public String getLuggageID() {
        return luggageID;
    }

    public void setLuggageID(String luggageID) {
        this.luggageID = luggageID;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public boolean isIsFragile() {
        return isFragile;
    }

    public void setIsFragile(boolean isFragile) {
        this.isFragile = isFragile;
    }
}
