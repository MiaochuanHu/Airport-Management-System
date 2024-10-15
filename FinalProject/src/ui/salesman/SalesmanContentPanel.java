/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.salesman;

import dao.PassenagerDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Passenger;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import static ui.component.ComponetCommonMethod.setTableCenter;
import utils.CheckUtils;
import utils.Constant;
import utils.emailNotification;

/**
 *
 * @author limingxia
 */
public class SalesmanContentPanel extends javax.swing.JPanel {

    private List<Passenger> todayPassengerList;
    private String[] commodityArr;
    private Passenger selectedPass;
    private StringBuilder shopCartContent = new StringBuilder();
    private Double total = 0.0;

    /**
     * Creates new form contentTablePanel
     */
    public SalesmanContentPanel() {
        initComponents();

        setTableCenter(passTable);
        initCommodityList();
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

        searchAreaBg = new ui.component.RoundPanel();
        searchBtn = new javax.swing.JButton();
        keywordTxt = new javax.swing.JTextField();
        roundPanel1 = new ui.component.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        passTable = new javax.swing.JTable();
        refreshBtn = new ui.component.RoundPanel();
        refreshLbl = new javax.swing.JLabel();
        shopcartPanel = new ui.component.RoundPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTxt = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        commodiyList = new javax.swing.JList<>();
        editBtn = new ui.component.RoundPanel();
        sendEmailLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        totalLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));
        setOpaque(false);

        searchAreaBg.setBackground(new java.awt.Color(255, 255, 255));

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        searchBtn.setBorder(null);
        searchBtn.setBorderPainted(false);
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
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
                .addGap(20, 20, 20)
                .addComponent(keywordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(searchBtn)
                .addContainerGap(20, Short.MAX_VALUE))
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

        jScrollPane1.setOpaque(false);

        passTable.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        passTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Passport ID", "Flight No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        passTable.getTableHeader().setReorderingAllowed(false);
        passTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(passTable);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        refreshBtn.setBackground(new java.awt.Color(255, 255, 255));
        refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBtnMouseClicked(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshLbl)
                .addContainerGap())
        );

        shopcartPanel.setBackground(new java.awt.Color(255, 255, 255));

        cartTxt.setEditable(false);
        cartTxt.setBackground(new java.awt.Color(255, 255, 255));
        cartTxt.setColumns(20);
        cartTxt.setRows(5);
        jScrollPane2.setViewportView(cartTxt);

        commodiyList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        commodiyList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commodiyListMouseClicked(evt);
            }
        });
        commodiyList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                commodiyListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(commodiyList);

        editBtn.setBackground(new java.awt.Color(255, 255, 255));
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });

        sendEmailLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sendEmailLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/edit.png"))); // NOI18N
        sendEmailLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendEmailLblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout editBtnLayout = new javax.swing.GroupLayout(editBtn);
        editBtn.setLayout(editBtnLayout);
        editBtnLayout.setHorizontalGroup(
            editBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sendEmailLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );
        editBtnLayout.setVerticalGroup(
            editBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sendEmailLbl)
                .addContainerGap())
        );

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Total:");

        totalLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLbl.setText("jLabel2");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Commodity List");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Shop Cart");

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Pickup Email");

        javax.swing.GroupLayout shopcartPanelLayout = new javax.swing.GroupLayout(shopcartPanel);
        shopcartPanel.setLayout(shopcartPanelLayout);
        shopcartPanelLayout.setHorizontalGroup(
            shopcartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shopcartPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(shopcartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(shopcartPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(shopcartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(shopcartPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailTxt))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shopcartPanelLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(171, 171, 171))
        );
        shopcartPanelLayout.setVerticalGroup(
            shopcartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shopcartPanelLayout.createSequentialGroup()
                .addGroup(shopcartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shopcartPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(shopcartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(shopcartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(shopcartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(totalLbl)
                            .addComponent(jLabel4)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shopcartPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchAreaBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(shopcartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchAreaBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(shopcartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String keyword = keywordTxt.getText();
        if (StringUtils.isBlank(keyword)) {
            JOptionPane.showMessageDialog(this, "Please input keyword!");
            initPassenagerList();
            return;
        }
        // according to name, passportID
        List<Passenger> searchResult = todayPassengerList.stream().filter(a
                -> a.getPersonName().equalsIgnoreCase(keyword)
                || a.getPassport().getPassportNumber().equalsIgnoreCase(keyword)
        ).collect(Collectors.toList());

        populateTable(searchResult);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void sendEmailLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendEmailLblMouseClicked
        // send email to customer
        if (shopCartContent.length() == 0) {
            JOptionPane.showMessageDialog(this, "Empty Shop Cart!!");
            return;
        }
        String pickupPerson = emailTxt.getText();
        if (!CheckUtils.checkEmail(pickupPerson)) {
            JOptionPane.showMessageDialog(this, "Email Format is Wrong!");
            return;
        }
        emailNotification.sendMail(
                pickupPerson,
                "Order Has Been Placed.",
                "\nThank you for you order!\n" + shopCartContent.toString() + "\nTotal: " + total);
        JOptionPane.showMessageDialog(this, "Send Email to Customer Successfully!");
        refreshPanel();
    }//GEN-LAST:event_sendEmailLblMouseClicked

    private void refreshLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshLblMouseClicked
        refreshPanel();
    }//GEN-LAST:event_refreshLblMouseClicked

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked

    }//GEN-LAST:event_editBtnMouseClicked

    private void refreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseClicked

    }//GEN-LAST:event_refreshBtnMouseClicked

    private void passTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTableMouseClicked
        // TODO add your handling code here:
        resetShopCart();
        int selectedRowIndex = passTable.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, Constant.SELECT_ERROR);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) passTable.getModel();
        selectedPass = (Passenger) model.getValueAt(selectedRowIndex, 0);

        commodiyList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = commodityArr;

            public int getSize() {
                return strings.length;
            }

            public String getElementAt(int i) {
                return strings[i];
            }
        });

        shopcartPanel.setVisible(true);
    }//GEN-LAST:event_passTableMouseClicked

    private void commodiyListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_commodiyListValueChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_commodiyListValueChanged

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnMouseClicked

    private void commodiyListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commodiyListMouseClicked
        // TODO add your handling code here:
        String selectedComm = commodiyList.getSelectedValue();
        shopCartContent.append(selectedComm).append("\n");
        String subtotla = selectedComm.split("\t")[1];
        total += Double.valueOf(subtotla);

        cartTxt.setText(shopCartContent.toString());
        totalLbl.setText(total + "");
    }//GEN-LAST:event_commodiyListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea cartTxt;
    private javax.swing.JList<String> commodiyList;
    private ui.component.RoundPanel editBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField keywordTxt;
    private javax.swing.JTable passTable;
    private ui.component.RoundPanel refreshBtn;
    private javax.swing.JLabel refreshLbl;
    private ui.component.RoundPanel roundPanel1;
    private ui.component.RoundPanel searchAreaBg;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel sendEmailLbl;
    private ui.component.RoundPanel shopcartPanel;
    private javax.swing.JLabel totalLbl;
    // End of variables declaration//GEN-END:variables

    private void initPassenagerList() {
        keywordTxt.setText("");
        this.todayPassengerList = PassenagerDao.queryPassengersWithBP();
    }

    private void populateTable(List<Passenger> passengerList) {
        DefaultTableModel model = (DefaultTableModel) passTable.getModel();
        model.setRowCount(0);

        if (ObjectUtils.isEmpty(passengerList)) {
            return;
        }

        for (Passenger passenger : passengerList) {

            Object[] row = new Object[3];
            row[0] = passenger;
            row[1] = passenger.getPassport().getPassportNumber();
            row[2] = passenger.getTicket().getFlightNo();

            model.addRow(row);
        }
    }

    private void initCommodityList() {
        List<String> commodityList = new ArrayList<>();
        Constant.COMMODITY_LIST.forEach(c
                -> commodityList.add(c.getName() + "\t" + c.getPrice())
        );
        commodityArr = commodityList.stream().toArray(String[]::new);
    }

    private void refreshPanel() {
        keywordTxt.setText("");

        resetShopCart();
        shopcartPanel.setVisible(false);

        initPassenagerList();
        populateTable(todayPassengerList);
    }

    private void resetShopCart() {
        total = 0.0;
        shopCartContent = new StringBuilder();
        cartTxt.setText("");
        totalLbl.setText("0.0");
        emailTxt.setText("");
    }
}
