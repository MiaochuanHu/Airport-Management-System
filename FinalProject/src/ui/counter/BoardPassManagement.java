/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.counter;

import dao.FlightCompanyDao;
import dao.LuggageDao;
import dao.PassenagerDao;
import dao.TicketDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Luggage;
import model.Passenger;
import model.Person;
import model.Ticket;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import static ui.component.ComponetCommonMethod.setTableCenter;
import utils.CheckUtils;
import utils.Constant;
import static utils.Constant.DATABASE_ERROR;
import static utils.Constant.SELECT_ERROR;
import utils.serial.LuggageIDGenerator;

/**
 *
 * @author limingxia
 */
public class BoardPassManagement extends javax.swing.JPanel {

    private List<Ticket> tickets = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private String[] passArr = null;
    private Passenger selectedPass;
    private Ticket selectedTicket;
    private Person curCounter;

    /**
     * Creates new form AirlineManagement
     */
    public BoardPassManagement() {
        initComponents();
        setTableCenter(ticketTb);
        refreshPanel();
    }

    BoardPassManagement(Person curPerson) {
        curCounter = curPerson;

        initComponents();
        setTableCenter(ticketTb);
        refreshPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        searchAreaBg = new ui.component.RoundPanel();
        searchBtn = new javax.swing.JButton();
        keywordTxt = new javax.swing.JTextField();
        roundPanel1 = new ui.component.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ticketTb = new javax.swing.JTable();
        refreshBtn = new ui.component.RoundPanel();
        refreshLbl = new javax.swing.JLabel();
        bpPanel = new ui.component.RoundPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        w1Lbl = new javax.swing.JFormattedTextField();
        w2Lbl = new javax.swing.JFormattedTextField();
        fragile1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        fragile2 = new javax.swing.JCheckBox();
        illLbl = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setOpaque(false);

        searchAreaBg.setBackground(new java.awt.Color(255, 255, 255));

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        searchBtn.setBorder(null);
        searchBtn.setBorderPainted(false);
        searchBtn.setOpaque(true);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        keywordTxt.setToolTipText("");

        javax.swing.GroupLayout searchAreaBgLayout = new javax.swing.GroupLayout(searchAreaBg);
        searchAreaBg.setLayout(searchAreaBgLayout);
        searchAreaBgLayout.setHorizontalGroup(
            searchAreaBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchAreaBgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(keywordTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn)
                .addGap(10, 10, 10))
        );
        searchAreaBgLayout.setVerticalGroup(
            searchAreaBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchAreaBgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchAreaBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(keywordTxt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ticketTb.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        ticketTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TicketID", "Flight No", "Passenger", "Printed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ticketTb.setShowGrid(false);
        ticketTb.getTableHeader().setReorderingAllowed(false);
        ticketTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ticketTbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ticketTb);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        refreshBtn.setBackground(new java.awt.Color(255, 255, 255));

        refreshLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refreshLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh.png"))); // NOI18N
        refreshLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshLblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout refreshBtnLayout = new javax.swing.GroupLayout(refreshBtn);
        refreshBtn.setLayout(refreshBtnLayout);
        refreshBtnLayout.setHorizontalGroup(
            refreshBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(refreshLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );
        refreshBtnLayout.setVerticalGroup(
            refreshBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, refreshBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refreshLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bpPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(48, 207, 208));
        jPanel2.setOpaque(false);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("isFragile");

        w1Lbl.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        w1Lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w1LblActionPerformed(evt);
            }
        });

        w2Lbl.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        w2Lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w2LblActionPerformed(evt);
            }
        });

        fragile1.setText("Yes");
        fragile1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fragile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fragile1ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Weight");

        fragile2.setText("Yes");
        fragile2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fragile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fragile2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(w1Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(fragile1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(w2Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(fragile2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(w1Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fragile1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(w2Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fragile2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        illLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bloom-woman-with-her-suitcase-sitting-near-airport-tablo-and-looking-at-her-watch.png"))); // NOI18N

        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/edit.png"))); // NOI18N
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bpPanelLayout = new javax.swing.GroupLayout(bpPanel);
        bpPanel.setLayout(bpPanelLayout);
        bpPanelLayout.setHorizontalGroup(
            bpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bpPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(illLbl)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitBtn)
                .addContainerGap())
        );
        bpPanelLayout.setVerticalGroup(
            bpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bpPanelLayout.createSequentialGroup()
                .addGroup(bpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(illLbl)
                    .addGroup(bpPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bpPanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(submitBtn)))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(searchAreaBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchAreaBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        bpPanel.setVisible(false);

        String keyword = keywordTxt.getText();
        if (StringUtils.isBlank(keyword)) {
            JOptionPane.showMessageDialog(this, "Please input keyword!");
            refreshPanel();
            return;
        }

        // support to search by id & name
        List<Ticket> searchResult = tickets.stream().filter(t
                -> t.getFlightNo().equalsIgnoreCase(keyword)
        ).collect(Collectors.toList());

        populateTable(searchResult);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void ticketTbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ticketTbMouseClicked

        int selectedRowIndex = ticketTb.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, SELECT_ERROR);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) ticketTb.getModel();
        selectedTicket = (Ticket) model.getValueAt(selectedRowIndex, 0);

        initBpPanel();
        bpPanel.setVisible(true);
    }//GEN-LAST:event_ticketTbMouseClicked

    private void refreshLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshLblMouseClicked
        refreshPanel();
    }//GEN-LAST:event_refreshLblMouseClicked

    private void fragile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fragile1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fragile1ActionPerformed

    private void w1LblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w1LblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_w1LblActionPerformed

    private void w2LblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w2LblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_w2LblActionPerformed

    private void fragile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fragile2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fragile2ActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        List<Luggage> luggages = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String luggageID = "";
        String warning = "";

        String weight1Str = w1Lbl.getText();
        if (StringUtils.isNotBlank(weight1Str)) {
            warning = CheckUtils.checkWeight(weight1Str);
            if (StringUtils.isNotBlank(warning)) {
                JOptionPane.showMessageDialog(this, warning);
                return;
            }
            Double weight1 = Double.valueOf(weight1Str);
            boolean isFragile1 = fragile1.isSelected();
            luggageID = LuggageIDGenerator.getInstance().next();
            sb.append(luggageID).append("|");
            luggages.add(new Luggage(luggageID, weight1, isFragile1));
        }
        String weight2Str = w2Lbl.getText();
        if (StringUtils.isNotBlank(weight2Str)) {
            warning = CheckUtils.checkWeight(weight2Str);
            if (StringUtils.isNotBlank(warning)) {
                JOptionPane.showMessageDialog(this, warning);
                return;
            }
            Double weight2 = Double.valueOf(weight2Str);
            boolean isFragile2 = fragile2.isSelected();
            luggageID = LuggageIDGenerator.getInstance().next();
            sb.append(luggageID).append("|");
            luggages.add(new Luggage(luggageID, weight2, isFragile2));
        }

        // write Luggage table
        if (!LuggageDao.insertNewLuggages(luggages)) {
            JOptionPane.showMessageDialog(this, DATABASE_ERROR);
            return;
        }

        // write ticket table
        if (!TicketDao.createBoardingPass(selectedTicket, sb.toString())) {
            JOptionPane.showMessageDialog(this, DATABASE_ERROR);
            return;
        }

        JOptionPane.showMessageDialog(this, Constant.SUCC);
        refreshPanel();
    }//GEN-LAST:event_submitBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.component.RoundPanel bpPanel;
    private javax.swing.JCheckBox fragile1;
    private javax.swing.JCheckBox fragile2;
    private javax.swing.JLabel illLbl;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keywordTxt;
    private ui.component.RoundPanel refreshBtn;
    private javax.swing.JLabel refreshLbl;
    private ui.component.RoundPanel roundPanel1;
    private ui.component.RoundPanel searchAreaBg;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTable ticketTb;
    private javax.swing.JFormattedTextField w1Lbl;
    private javax.swing.JFormattedTextField w2Lbl;
    // End of variables declaration//GEN-END:variables

    private void queryAllTicketByFcID(Integer fcId) {
        tickets = TicketDao.queryAllNormalTicketNoBPByFcID(fcId);
    }

    private void populateTable(List<Ticket> tickets) {
        DefaultTableModel model = (DefaultTableModel) ticketTb.getModel();
        model.setRowCount(0);

        if (ObjectUtils.isEmpty(tickets)) {
            return;
        }

        for (Ticket t : tickets) {

            Object[] row = new Object[4];
            row[0] = t;
            row[1] = t.getFlightNo();
            row[2] = passengerName(t.getTicketID());
//            row[3] = t.getFrom();
//            row[4] = t.getTo();
            row[3] = t.getPrintBoardingPass() ? "Yes" : "No";

            model.addRow(row);
        }
    }

    private String passengerName(String ticketID) {

        return PassenagerDao.queryPassengerByTicketID(ticketID);
    }

    private void refreshPanel() {
        keywordTxt.setText("");
        setLuggageEnable();
        bpPanel.setVisible(false);

        Integer fcId = FlightCompanyDao.queryFCByCounter(curCounter.getPersonID());
        queryAllTicketByFcID(fcId);
        populateTable(tickets);
    }

    private void initBpPanel() {
        if (selectedTicket.getPrintBoardingPass()) {
            String lagguageIDArr = TicketDao.queryLagguageIDByTID(selectedTicket.getTicketID());
            if (!StringUtils.isBlank(lagguageIDArr)) {

                List<Luggage> luggages = LuggageDao.queryLuggagesByIDs(lagguageIDArr.split("\\|"));

                w1Lbl.setText(luggages.get(0).getWeight() + "");
                fragile1.setSelected(luggages.get(0).isIsFragile());
                if (luggages.size() == 2) {
                    w2Lbl.setText(luggages.get(1).getWeight() + "");
                    fragile2.setSelected(luggages.get(1).isIsFragile());
                } else {
                    w2Lbl.setText("");
                    fragile2.setSelected(false);
                }

            }
            setLuggageDisable();
        } else {
            setLuggageEnable();
        }
    }

    private void setLuggageEnable() {
        w1Lbl.setText("");
        w2Lbl.setText("");
        fragile1.setSelected(false);
        fragile2.setSelected(false);
        w1Lbl.setEnabled(true);
        w2Lbl.setEnabled(true);
        fragile1.setEnabled(true);
        fragile2.setEnabled(true);
    }

    private void setLuggageDisable() {
        w1Lbl.setEnabled(false);
        w2Lbl.setEnabled(false);
        fragile1.setEnabled(false);
        fragile2.setEnabled(false);
    }
}
