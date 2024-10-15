/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.component;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Passenger;
import org.apache.commons.lang3.ObjectUtils;

/**
 *
 * @author limingxia
 */
public class ComponetCommonMethod {

    // use for police and customs
    public static void populatePassengerTable(List<Passenger> passengerList, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        if (ObjectUtils.isEmpty(passengerList)) {
            return;
        }

        for (Passenger passenger : passengerList) {

            Object[] row = new Object[5];
            row[0] = passenger;
            row[1] = passenger.getGender();
            row[2] = passenger.getPassport().getPassportNumber();
            row[3] = passenger.getTicket().getFlightNo();
            row[4] = passenger.getTicket().getCarryDanger();

            model.addRow(row);
        }
    }

    public static void setTableCenter(JTable table) {
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
    }
}
