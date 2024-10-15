/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.serial;

import utils.DateUtils;

/**
 *
 * @author Jiaf
 */
public class TicketIDGenerator {
    public static final String TICKET_ID_PREFIX = "T_";
    private long id = 1;
    private static final TicketIDGenerator INSTANCE = new TicketIDGenerator();

    private TicketIDGenerator() {
    }

    public synchronized String next() {

        return TICKET_ID_PREFIX + DateUtils.getSerialDateTime() + "_" + id++;
    }

    public static TicketIDGenerator getInstance() {

        return INSTANCE;
    }
}
