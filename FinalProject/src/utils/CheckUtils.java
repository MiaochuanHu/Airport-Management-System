/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author limingxia
 */
public class CheckUtils {

    public static boolean checkPhoneNo(String phoneNo) {
        if (StringUtils.isBlank(phoneNo)) {
            return false;
        }

        String check = "^\\d{10}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(phoneNo);

        return matcher.matches();
    }

    public static boolean checkEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }

        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);

        return matcher.matches();
    }

    public static boolean checkZipCode(String zipCode) {
        if (StringUtils.isBlank(zipCode)) {
            return false;
        }

        String check = "^\\d{5}";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(zipCode);

        return matcher.matches();
    }

    public static boolean checkLegalName(String name) {
        if (StringUtils.isBlank(name)) {
            return false;
        }

        Pattern pattern = Pattern.compile("^[\\u4E00-\\u9FA5A-Za-z\\s]+(·[\\u4E00-\\u9FA5A-Za-z]+)*$");

        return pattern.matcher(name).matches();
    }

    public static Boolean checkUsername(String username) {
        if (StringUtils.isBlank(username)) {
            return false;
        }

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{6,12}$*");

        return pattern.matcher(username).matches();
    }

    // at least 8 character, 1 upper case letter, 1 lower case letter, 1 digit, cannot contain special character
    public static boolean checkPassword(String password) {
        if (StringUtils.isBlank(password)) {
            return false;
        }

        String check = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(password);

        return matcher.matches();
    }

    public static boolean checkAge(int age) {
        return !(age < 0 || age > 120);
    }

    public static boolean checkPassportID(String passportID) {
        if (StringUtils.isBlank(passportID)) {
            return false;
        }

        String check = "^([a-zA-Z]|[0-9]){5,17}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(passportID);

        return matcher.matches();
    }

    public static String checkWeight(String weight) {
        Double wei = Double.valueOf(weight);

        if (wei < 0) {
            return "Weight Cannot Less Than 0!";
        }
        if (wei > 23) {
            return "Max Weight is 23KG!";
        }

        return "";
    }

    public static boolean checkFlightNo(String flightNo) {
        if (StringUtils.isBlank(flightNo)) {
            return false;
        }

        String check = "^[A-Z\\d]{2}\\d{3,4}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(flightNo);

        return matcher.matches();
    }

    public static boolean checkPrice(String price) {
        if (StringUtils.isBlank(price)) {
            return false;
        }

        String check = "[0-9]+([,.][0-9]{1,2})?";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(price);

        return matcher.matches();
    }
}
