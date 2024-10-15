/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import model.Commodity;
import enumvalue.RoleEnum;
import static enumvalue.RoleEnum.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author limingxia
 */
public class Constant {

    public static final ArrayList<String> VISA_COUNTRY_LIST
            = new ArrayList<>(Arrays.asList("China",
                    "India",
                    "Tailand",
                    "United Stats",
                    "United Kindom"
            ));

    public static final String DATABASE_ERROR = "Try Again!";
    public static final String SELECT_ERROR = "Please Select One Row!";
    public static final String BLANKS_ERROR = "Please Fill in All Blanks!";
    public static final String INFO_ERROR = "Wrong information provided!";
    public static final String SUCC = "Successful!";

    public static final Map<String, RoleEnum> ROLE_MAP = new HashMap() {
        {
            put(SYSTEM_ADMIN.getRole(), SYSTEM_ADMIN);
            put(AIRPORT_ADMIN.getRole(), AIRPORT_ADMIN);
            put(SERVICE_ADMIN.getRole(), SERVICE_ADMIN);
            put(GOVERN_ADMIN.getRole(), GOVERN_ADMIN);
            put(AIRBUS_ADMIN.getRole(), AIRBUS_ADMIN);
            put(PASSENGER.getRole(), PASSENGER);
            put(CUSTOMS.getRole(), CUSTOMS);
            put(GREETER.getRole(), GREETER);
            put(SALESMAN.getRole(), SALESMAN);
            put(FLIGHTCREW.getRole(), FLIGHTCREW);
            put(COUNTER.getRole(), COUNTER);
            put(PICKUP.getRole(), PICKUP);
            put(TRAFFICCONTROL.getRole(), TRAFFICCONTROL);
            // put(GROUND.getRole(), GROUND);
            // put(LABORSUPERVISOR.getRole(), LABORSUPERVISOR);
            put(CONDUCTOR.getRole(), CONDUCTOR);
            put(POLICEMAN.getRole(), POLICEMAN);

        }
    };
    public static final String[] ROLE_ARR = ROLE_MAP.keySet().stream()
            .filter(r -> !r.equals(SYSTEM_ADMIN.getRole())
            & !r.equals(AIRPORT_ADMIN.getRole())
            & !r.equals(SERVICE_ADMIN.getRole())
            & !r.equals(GOVERN_ADMIN.getRole())
            & !r.equals(AIRBUS_ADMIN.getRole()))
            .toArray(String[]::new);

    public static final List<Commodity> COMMODITY_LIST = new ArrayList<Commodity>(
            Arrays.asList(
                    new Commodity("MacBook Pro", 2000.00),
                    new Commodity("LV HandBag", 1499.00),
                    new Commodity("Skii Moisturizer", 120.00),
                    new Commodity("Gucci Scarf", 666.00),
                    new Commodity("Mac Lipstick", 15.00),
                    new Commodity("Bose earphone", 119.00),
                    new Commodity("iPhone 18Pro", 256.00),
                    new Commodity("GNC Fish Oil", 32.00),
                    new Commodity("Longchamp Backpack", 109.00)
            )
    );

    public static final String[] FLIGHT_STATUS = {"normal", "delay", "cancel"};

    public static final String[] COUNTER_LIST
            = {
                "A10",
                "B11",
                "C12",
                "D13",
                "E14",
                "F15",
                "G16",
                "H17",
                "I18"
            };
}
