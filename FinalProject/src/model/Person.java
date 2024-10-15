/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.PersonDao;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import utils.CheckUtils;

/**
 *
 * @author limingxia
 */
public class Person {

    // TODO lmx modify
    private Integer personID;
    private String account;
    private String password;
    private String roleType;

    private String personName;
    private Integer age;
    private String gender;

    public Person() {
    }

    public Person(Integer personID, String account, String password, String roleType, String personName, Integer age, String gender) {
        this.personID = personID;
        this.account = account;
        this.password = password;
        this.roleType = roleType;
        this.personName = personName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return getPersonName();
    }

    public String checkField() {
        String warning = "";

        if (StringUtils.isEmpty(personName)
                || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(account)) {
            warning = "Please fill in all the blanks!";
            return warning;
        }

        if (!CheckUtils.checkLegalName(personName)) {
            warning = "Please Check Name!";
            return warning;

        }

        if (!CheckUtils.checkEmail(account)) {
            warning = "Please Check Email!";
            return warning;

        }
        if (!CheckUtils.checkAge(age)) {
            warning = "Please Check Age!";
            return warning;
        }

        // password
        if (!CheckUtils.checkPassword(password)) {
            warning = "Password: Please longer than 8 character, only contain digit and letter, at least one capital letter!";
            return warning;
        }

        // email
        // ** MUST BE UNQIUE ** //
        if (!Objects.isNull(PersonDao.queryLoginByAccount(account))) {
            warning = "Already Sign up, Please Sign In!";
            return warning;
        }

        return warning;
    }

}
