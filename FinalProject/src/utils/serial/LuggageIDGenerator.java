/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.serial;

import utils.DateUtils;

/**
 *
 * @author limingxia
 */
public class LuggageIDGenerator {

    public static final String LUGGAGE_ID_PREFIX = "L_";
    private long id = 1;
    private static final LuggageIDGenerator INSTANCE = new LuggageIDGenerator();

    private LuggageIDGenerator() {
    }

    public synchronized String next() {

        return LUGGAGE_ID_PREFIX + DateUtils.getCurrentDateTime() + "_" + id++;
    }

    public static LuggageIDGenerator getInstance() {

        return INSTANCE;
    }

}
