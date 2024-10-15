/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import dao.FlightCompanyDao;
import dao.PersonDao;
import enumvalue.RoleEnum;
import java.util.List;
import javax.swing.JOptionPane;
import model.FlightCompany;
import model.Person;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import ui.component.ClickLabelEvent;
import utils.Constant;
import static utils.Constant.ROLE_ARR;

/**
 *
 * @author limingxia
 */
public class SignUpFrame extends javax.swing.JFrame {

    private String[] roleType = ROLE_ARR;
    private List<FlightCompany> flightCompanys;
    private String fromPage = "";

    private void initFlightCompanyBox() {
        flightCompanyBox.removeAllItems();
        flightCompanys.forEach(fc -> flightCompanyBox.addItem(fc));
        flightCompanyBox.setSelectedIndex(-1);
    }

    private void initRoleArr() {
        switch (fromPage) {
            case "StaffManagement":
                roleBox.removeAllItems();
                roleBox.addItem(RoleEnum.POLICEMAN.getRole());
                roleBox.addItem(RoleEnum.CUSTOMS.getRole());
                break;

            case "ServiceWorkerManagement":
                roleBox.removeAllItems();
                roleBox.addItem(RoleEnum.GREETER.getRole());
                roleBox.addItem(RoleEnum.SALESMAN.getRole());

                break;
            case "AirportStaffManagement":
                roleBox.removeAllItems();
                roleBox.addItem(RoleEnum.TRAFFICCONTROL.getRole());
                roleBox.addItem(RoleEnum.FLIGHTCREW.getRole());

                break;
            default:

        }
    }

    private class goBackEvent implements ClickLabelEvent {

        @Override
        public void labelClick() {
            goBack();
        }
    }

    private void goBack() {
        this.dispose();
    }

    public SignUpFrame() {
        queryFlightCompanys();

        initComponents();
        initRoleArr();
        initFlightCompanyBox();

        toolBarPanelWithBack1.goBack(new goBackEvent());
        fcPanel.setVisible(false);
    }

    public SignUpFrame(String fromPage) {
        this.fromPage = fromPage;

        queryFlightCompanys();
        initComponents();

        initRoleArr();
        initFlightCompanyBox();
        toolBarPanelWithBack1.goBack(new goBackEvent());
        fcPanel.setVisible(false);
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
        jLabel1 = new javax.swing.JLabel();
        personNameLbl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        signUpPanel = new keeptoo.KGradientPanel();
        signLbl = new javax.swing.JLabel();
        toolBarPanelWithBack1 = new ui.component.toolBarPanelWithBack();
        jLabel3 = new javax.swing.JLabel();
        confirmPasswordTxt = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        genderBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        ageTxt = new javax.swing.JFormattedTextField();
        roleBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        fcPanel = new javax.swing.JPanel();
        flightCompanyBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 133, 182));
        jLabel1.setText("Name");

        personNameLbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(106, 133, 182)));
        personNameLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personNameLblActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(106, 133, 182));
        jLabel2.setText("Password");

        passwordTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(106, 133, 182)));

        signUpPanel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signUpPanel.setkEndColor(new java.awt.Color(48, 207, 208));
        signUpPanel.setkStartColor(new java.awt.Color(51, 8, 103));
        signUpPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpPanelMouseClicked(evt);
            }
        });

        signLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signLbl.setForeground(new java.awt.Color(255, 255, 255));
        signLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signLbl.setText("Sign Up");
        signLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signLblMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout signUpPanelLayout = new javax.swing.GroupLayout(signUpPanel);
        signUpPanel.setLayout(signUpPanelLayout);
        signUpPanelLayout.setHorizontalGroup(
            signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        signUpPanelLayout.setVerticalGroup(
            signUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(106, 133, 182));
        jLabel3.setText("Confirm Password");

        confirmPasswordTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(106, 133, 182)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(106, 133, 182));
        jLabel4.setText("Age");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(106, 133, 182));
        jLabel5.setText("Gender");

        genderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Prefer not to say" }));
        genderBox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(106, 133, 182)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(106, 133, 182));
        jLabel6.setText("Email");

        emailTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(106, 133, 182)));
        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });

        ageTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(106, 133, 182)));
        ageTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        roleBox.setModel(new javax.swing.DefaultComboBoxModel<>(roleType));
        roleBox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(106, 133, 182)));
        roleBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleBoxActionPerformed(evt);
            }
        });
        roleBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                roleBoxPropertyChange(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(106, 133, 182));
        jLabel7.setText("Role Type");

        flightCompanyBox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(106, 133, 182)));
        flightCompanyBox.setOpaque(true);
        flightCompanyBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightCompanyBoxActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(106, 133, 182));
        jLabel8.setText("Flight Company");
        jLabel8.setOpaque(true);

        javax.swing.GroupLayout fcPanelLayout = new javax.swing.GroupLayout(fcPanel);
        fcPanel.setLayout(fcPanelLayout);
        fcPanelLayout.setHorizontalGroup(
            fcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fcPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(fcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(flightCompanyBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        fcPanelLayout.setVerticalGroup(
            fcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fcPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(flightCompanyBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBarPanelWithBack1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(personNameLbl)
                            .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(roleBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 262, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emailTxt)
                            .addComponent(genderBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ageTxt)
                            .addComponent(fcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(signUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ageTxt, confirmPasswordTxt, emailTxt, genderBox, passwordTxt, personNameLbl, roleBox});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(toolBarPanelWithBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(0, 0, 0)
                        .addComponent(personNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(ageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(confirmPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(genderBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(roleBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(signUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void personNameLblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personNameLblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personNameLblActionPerformed

    private void signUpPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpPanelMouseClicked

    }//GEN-LAST:event_signUpPanelMouseClicked

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void flightCompanyBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightCompanyBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flightCompanyBoxActionPerformed

    private void roleBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_roleBoxPropertyChange
        if (roleBox.getSelectedIndex() == -1) {
            return;
        }
        String selectedRole = roleBox.getSelectedItem().toString();
        // counter & company admin --> a flight company
        fcPanel.setVisible(selectedRole.equals(RoleEnum.COUNTER.getRole()));
    }//GEN-LAST:event_roleBoxPropertyChange

    private void signLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signLblMouseClicked

        // email must be unique
        String name = personNameLbl.getText();
        String password = new String(passwordTxt.getPassword());
        String confirmPassword = new String(confirmPasswordTxt.getPassword());
        String email = emailTxt.getText();
        String age = ageTxt.getText();
        String gender = genderBox.getSelectedItem().toString();

        if (StringUtils.isEmpty(age) || StringUtils.isEmpty(confirmPassword) || ObjectUtils.isEmpty(roleBox.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, Constant.BLANKS_ERROR);
            return;
        }

        String role = roleBox.getSelectedItem().toString();

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Inconsistent password!");
            return;
        }

        Person newUser = new Person(0, email, password, role, name, Integer.valueOf(age), gender);
        String warning = newUser.checkField();
        if (StringUtils.isNotBlank(warning)) {
            JOptionPane.showMessageDialog(this, warning);
            return;
        }

        // speical process for counters which to flight company
        FlightCompany selectedFc = null;
        if (flightCompanyBox.getSelectedIndex() >= 0) {
            selectedFc = (FlightCompany) flightCompanyBox.getSelectedItem();
            if (!PersonDao.insertNewCounter(newUser, selectedFc.getFcID())) {
                JOptionPane.showMessageDialog(this, Constant.DATABASE_ERROR);
                return;
            }
        } else {
            if (!PersonDao.insertNewPerson(newUser)) {
                JOptionPane.showMessageDialog(this, Constant.DATABASE_ERROR);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, Constant.SUCC);

        this.dispose();
    }//GEN-LAST:event_signLblMouseClicked

    private void roleBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleBoxActionPerformed
        if (roleBox.getSelectedIndex() >= 0 && roleBox.getSelectedItem().toString().equals(RoleEnum.COUNTER.getRole())) {
            fcPanel.setVisible(true);
        } else {
            fcPanel.setVisible(false);
        }
    }//GEN-LAST:event_roleBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField ageTxt;
    private javax.swing.JPasswordField confirmPasswordTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JPanel fcPanel;
    private javax.swing.JComboBox<Object> flightCompanyBox;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField personNameLbl;
    private javax.swing.JComboBox<String> roleBox;
    private javax.swing.JLabel signLbl;
    private keeptoo.KGradientPanel signUpPanel;
    private ui.component.toolBarPanelWithBack toolBarPanelWithBack1;
    // End of variables declaration//GEN-END:variables

    private void queryFlightCompanys() {
        flightCompanys = FlightCompanyDao.queryAllFlightCompany();
    }
}
