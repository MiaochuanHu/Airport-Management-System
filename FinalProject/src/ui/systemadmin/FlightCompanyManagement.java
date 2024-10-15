/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.systemadmin;

import dao.FlightCompanyDao;
import dao.PersonDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.FlightCompany;
import model.Person;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import static ui.component.ComponetCommonMethod.setTableCenter;
import utils.Constant;
import static utils.Constant.DATABASE_ERROR;

/**
 *
 * @author limingxia
 */
public class FlightCompanyManagement extends javax.swing.JPanel {

    private List<FlightCompany> flightCompanys = new ArrayList<>();
    private boolean onlyView = false;

    /**
     * Creates new form AirlineManagement
     */
    public FlightCompanyManagement() {
        initComponents();
        counterBox.setModel(new javax.swing.DefaultComboBoxModel<>(Constant.COUNTER_LIST));
        setTableCenter(airlineTable);

        refreshPanel();
    }

    public FlightCompanyManagement(boolean onlyView) {
        this.onlyView = onlyView;

        initComponents();
        counterBox.setModel(new javax.swing.DefaultComboBoxModel<>(Constant.COUNTER_LIST));
        setTableCenter(airlineTable);

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

        resetPasswordBtn2 = new ui.component.RoundPanel();
        showBtn = new javax.swing.JLabel();
        searchAreaBg = new ui.component.RoundPanel();
        searchBtn = new javax.swing.JButton();
        keywordTxt = new javax.swing.JTextField();
        roundPanel1 = new ui.component.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        airlineTable = new javax.swing.JTable();
        createAirlinePanel = new ui.component.RoundPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        adminTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        cpswdTxt = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        counterBox = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        alterPanel = new javax.swing.JPanel();
        resetPasswordBtn1 = new ui.component.RoundPanel();
        delBtn = new javax.swing.JLabel();
        refreshBtn = new ui.component.RoundPanel();
        jLabel2 = new javax.swing.JLabel();

        resetPasswordBtn2.setBackground(new java.awt.Color(255, 255, 255));

        showBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-preview-pane-28.png"))); // NOI18N
        showBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout resetPasswordBtn2Layout = new javax.swing.GroupLayout(resetPasswordBtn2);
        resetPasswordBtn2.setLayout(resetPasswordBtn2Layout);
        resetPasswordBtn2Layout.setHorizontalGroup(
            resetPasswordBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(showBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );
        resetPasswordBtn2Layout.setVerticalGroup(
            resetPasswordBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resetPasswordBtn2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addComponent(keywordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
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

        airlineTable.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        airlineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Admin", "Counter"
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
        airlineTable.setShowGrid(false);
        airlineTable.getTableHeader().setReorderingAllowed(false);
        airlineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                airlineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(airlineTable);
        if (airlineTable.getColumnModel().getColumnCount() > 0) {
            airlineTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        createAirlinePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Name");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Admin Email");

        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Password");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Confirm Password");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Counter");

        counterBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-create-document-28.png"))); // NOI18N
        addBtn.setText("Submit");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createAirlinePanelLayout = new javax.swing.GroupLayout(createAirlinePanel);
        createAirlinePanel.setLayout(createAirlinePanelLayout);
        createAirlinePanelLayout.setHorizontalGroup(
            createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createAirlinePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createAirlinePanelLayout.createSequentialGroup()
                        .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createAirlinePanelLayout.createSequentialGroup()
                                .addComponent(counterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(createAirlinePanelLayout.createSequentialGroup()
                                .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addBtn)
                                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(createAirlinePanelLayout.createSequentialGroup()
                        .addComponent(cpswdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        createAirlinePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel9});

        createAirlinePanelLayout.setVerticalGroup(
            createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createAirlinePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(counterBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(adminTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createAirlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cpswdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn))
                .addGap(15, 15, 15))
        );

        resetPasswordBtn1.setBackground(new java.awt.Color(255, 255, 255));

        delBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-remove-24.png"))); // NOI18N
        delBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout resetPasswordBtn1Layout = new javax.swing.GroupLayout(resetPasswordBtn1);
        resetPasswordBtn1.setLayout(resetPasswordBtn1Layout);
        resetPasswordBtn1Layout.setHorizontalGroup(
            resetPasswordBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resetPasswordBtn1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(delBtn)
                .addGap(8, 8, 8))
        );
        resetPasswordBtn1Layout.setVerticalGroup(
            resetPasswordBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resetPasswordBtn1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(delBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout alterPanelLayout = new javax.swing.GroupLayout(alterPanel);
        alterPanel.setLayout(alterPanelLayout);
        alterPanelLayout.setHorizontalGroup(
            alterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alterPanelLayout.createSequentialGroup()
                .addComponent(resetPasswordBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        alterPanelLayout.setVerticalGroup(
            alterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resetPasswordBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        refreshBtn.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/refresh.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout refreshBtnLayout = new javax.swing.GroupLayout(refreshBtn);
        refreshBtn.setLayout(refreshBtnLayout);
        refreshBtnLayout.setHorizontalGroup(
            refreshBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refreshBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        refreshBtnLayout.setVerticalGroup(
            refreshBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refreshBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createAirlinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchAreaBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(alterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetPasswordBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchAreaBg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetPasswordBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createAirlinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String keyword = keywordTxt.getText();
        if (StringUtils.isBlank(keyword)) {
            JOptionPane.showMessageDialog(this, "Please input keyword!");
            refreshPanel();
            return;
        }

        // support to search by id & name
        List<FlightCompany> searchResult = flightCompanys.stream().filter(a
                -> a.getFcName().equalsIgnoreCase(keyword)
                || String.valueOf(a.getFcID()).equalsIgnoreCase(keyword)
        ).collect(Collectors.toList());

        populateTable(searchResult);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void airlineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_airlineTableMouseClicked

    }//GEN-LAST:event_airlineTableMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        refreshPanel();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void delBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtnMouseClicked

        int selectedRowIndex = airlineTable.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, Constant.SELECT_ERROR);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) airlineTable.getModel();
        FlightCompany airline = (FlightCompany) model.getValueAt(selectedRowIndex, 1);

        String warning = FlightCompanyDao.deleteFlightCompanyByFCID(airline.getFcID());
        if (StringUtils.isNotBlank(warning)) {
            JOptionPane.showMessageDialog(this, warning);
            return;
        }
        if (!PersonDao.deletePersonByAccount(airline.getAdmin())) {
            JOptionPane.showMessageDialog(this, Constant.DATABASE_ERROR);
            return;
        }
        JOptionPane.showMessageDialog(this, Constant.SUCC);

        refreshPanel();
    }//GEN-LAST:event_delBtnMouseClicked

    private void showBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showBtnMouseClicked

        int selectedRowIndex = airlineTable.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, Constant.SELECT_ERROR);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) airlineTable.getModel();
        FlightCompany airline = (FlightCompany) model.getValueAt(selectedRowIndex, 1);

        FlightCompanyInfoFrame fcif = new FlightCompanyInfoFrame(airline);
        fcif.setVisible(true);
    }//GEN-LAST:event_showBtnMouseClicked

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String flightName = nameTxt.getText();
        String fAdminEmail = adminTxt.getText();
        String password = new String(passwordTxt.getPassword());
        String confirmPassword = new String(cpswdTxt.getPassword());
        String counter = counterBox.getSelectedItem().toString();

        if (StringUtils.isBlank(flightName) || StringUtils.isBlank(fAdminEmail)
                || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword) || StringUtils.isBlank(counter)) {
            JOptionPane.showMessageDialog(this, "Please fill in all the blanks!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Inconsistent password!");
            return;
        }

        // create Flight Company Object
        FlightCompany fc = new FlightCompany(flightName, fAdminEmail, counter);
        String warning = fc.checkField();
        if (StringUtils.isNotBlank(warning)) {
            JOptionPane.showMessageDialog(this, warning);
            return;
        }

        // insert into flight company
        if (!FlightCompanyDao.insertNewFlightCompany(fc)) {
            JOptionPane.showMessageDialog(this, DATABASE_ERROR);
            return;
        }

        Integer flightCompanyId = FlightCompanyDao.queryFCByName(flightName);
        if (ObjectUtils.isEmpty(flightCompanyId)) {
            JOptionPane.showMessageDialog(this, DATABASE_ERROR);
            return;
        }

        // create Person Object
        Person faPerson = new Person();
        faPerson.setAccount(fAdminEmail);
        faPerson.setPassword(password);
        faPerson.setRoleType(enumvalue.RoleEnum.AIRBUS_ADMIN.getRole());
        faPerson.setAge(30); // I put an random value here
        faPerson.setGender("male");
        faPerson.setPersonName(enumvalue.RoleEnum.AIRBUS_ADMIN.getRole());// I put an random value here

        warning = faPerson.checkField();
        if (StringUtils.isNotBlank(warning)) {
            JOptionPane.showMessageDialog(this, warning);
            return;
        }

        // insert new person
        if (!PersonDao.insertNewFCAdmin(faPerson, flightCompanyId)) {
            JOptionPane.showMessageDialog(this, DATABASE_ERROR);
            return;
        }

        JOptionPane.showMessageDialog(this, "Successfully!");
        // refresh table
        refreshPanel();
    }//GEN-LAST:event_addBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField adminTxt;
    private javax.swing.JTable airlineTable;
    private javax.swing.JPanel alterPanel;
    private javax.swing.JComboBox<String> counterBox;
    private javax.swing.JPasswordField cpswdTxt;
    private ui.component.RoundPanel createAirlinePanel;
    private javax.swing.JLabel delBtn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keywordTxt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JPasswordField passwordTxt;
    private ui.component.RoundPanel refreshBtn;
    private ui.component.RoundPanel resetPasswordBtn1;
    private ui.component.RoundPanel resetPasswordBtn2;
    private ui.component.RoundPanel roundPanel1;
    private ui.component.RoundPanel searchAreaBg;
    private javax.swing.JButton searchBtn;
    private javax.swing.JLabel showBtn;
    // End of variables declaration//GEN-END:variables

    private void initFlightCompanys() {
        flightCompanys = FlightCompanyDao.queryAllFlightCompany();
    }

    private void populateTable(List<FlightCompany> flightCompanys) {
        DefaultTableModel model = (DefaultTableModel) airlineTable.getModel();
        model.setRowCount(0);

        if (ObjectUtils.isEmpty(flightCompanys)) {
            return;
        }

        for (FlightCompany flightCompany : flightCompanys) {

            Object[] row = new Object[4];
            row[0] = flightCompany.getFcID();
            row[1] = flightCompany;
            row[2] = flightCompany.getAdmin();
            row[3] = flightCompany.getCounterList();

            model.addRow(row);
        }
    }

    private void resetBlanks() {
        nameTxt.setText("");
        adminTxt.setText("");
        passwordTxt.setText("");
        cpswdTxt.setText("");
        counterBox.setSelectedIndex(0);
    }

    private void refreshPanel() {

        if (onlyView) {
            alterPanel.setVisible(false);
            createAirlinePanel.setVisible(false);
        }

        keywordTxt.setText("");
        resetBlanks();
        initFlightCompanys();
        populateTable(flightCompanys);
    }
}
