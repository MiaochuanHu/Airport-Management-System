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
public class ImmRecIDGenerator {

    public static final String IMM_ID_PREFIX = "I_";
    private long id = 1;
    private static final ImmRecIDGenerator INSTANCE = new ImmRecIDGenerator();

    private ImmRecIDGenerator() {
    }

    public synchronized String next() {

        return IMM_ID_PREFIX + DateUtils.getCurrentDateTime() + "_" + id++;
    }

    public static ImmRecIDGenerator getInstance() {

        return INSTANCE;
    }

}
