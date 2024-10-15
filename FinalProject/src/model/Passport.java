/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import utils.CheckUtils;
import utils.DateUtils;

/**
 *
 * @author limingxia
 */
public class Passport {

    private String passportNumber; // /^([a-zA-Z]|[0-9]){5,17}$/
    private String legalName;
    private String expiryDate;
    private String visa;
    private List<EntryExitRcd> immRcd;
    private String birthday;

    public Passport() {
    }

    public Passport(String passportNumber, String legalName, String expiryDate, String visa, String birthday) {
        this.passportNumber = passportNumber;
        this.legalName = legalName;
        this.expiryDate = expiryDate;
        this.visa = visa;
        this.birthday = birthday;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public List<EntryExitRcd> getImmRcd() {
        return immRcd;
    }

    public void setImmRcd(List<EntryExitRcd> immRcd) {
        this.immRcd = immRcd;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String checkField() {
        String warning = "";

        if (StringUtils.isEmpty(legalName)
                || StringUtils.isEmpty(passportNumber)
                || StringUtils.isEmpty(birthday)
                || Objects.isNull(expiryDate)) {
            warning = "Please Fill in All the Blanks";
            return warning;
        }

        if (!CheckUtils.checkLegalName(legalName)) {
            warning = "Please Check Name Format";
            return warning;
        }
        if (!CheckUtils.checkPassportID(passportNumber)) {
            warning = "Please Check Passport Number";
            return warning;
        }
        if (DateUtils.stringToDate(birthday) == null || DateUtils.stringToDate(expiryDate) == null) {
            warning = "Invalid Date, Please Input as 09/21/2023";
            return warning;
        }

        return warning;
    }

}
