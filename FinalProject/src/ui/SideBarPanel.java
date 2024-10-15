/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import enumvalue.RoleEnum;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import model.Person;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import ui.component.ClickLabelEvent;
import ui.component.CustomEvent;
import ui.component.FuncItem;
import ui.component.FuncItemBtn;

/**
 *
 * @author limingxia
 */
public class SideBarPanel extends javax.swing.JPanel {

    private ClickLabelEvent exitEvent;
    private CustomEvent event;
    private FuncItemBtn selectedItem;
    private FuncItemBtn unSelectedItem;
    private Animator animator;

    private Person curPerson = new Person();

    /**
     * Creates new form DrawerAvatar
     */
    public SideBarPanel() {
        curPerson.setAccount("test@gmail.com");
        curPerson.setRoleType(RoleEnum.SYSTEM_ADMIN.getRole());

        initComponents();

        menuPanel.setLayout(new MigLayout("wrap, fillx, inset 0", "[grow]"));

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                selectedItem.setAnimate(fraction);
                if (unSelectedItem != null) {
                    unSelectedItem.setAnimate(1f - fraction);
                }
            }
        };
        animator = new Animator(300, target);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.setResolution(0);
    }

    public SideBarPanel(Person curPerson) {
        this.curPerson = curPerson;

        initComponents();

        menuPanel.setLayout(new MigLayout("wrap, fillx, inset 0", "[grow]"));

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                selectedItem.setAnimate(fraction);
                if (unSelectedItem != null) {
                    unSelectedItem.setAnimate(1f - fraction);
                }
            }
        };
        animator = new Animator(300, target);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
        animator.setResolution(0);
    }

    public void initMenu(ArrayList<FuncItem> funcItemList, CustomEvent event, ClickLabelEvent exitEvent) {
        this.exitEvent = exitEvent;
        this.event = event;

        if (funcItemList == null || funcItemList.isEmpty()) {
            return;
        }

        for (FuncItem item : funcItemList) {
            addFuncItem(item.getIcon(), item.getText(), item.getIndex());
        }
    }

    public void initMenu(ArrayList<FuncItem> funcItemList, CustomEvent event) {
        this.event = event;
        if (funcItemList == null || funcItemList.isEmpty()) {
            return;
        }

        for (FuncItem item : funcItemList) {
            addFuncItem(item.getIcon(), item.getText(), item.getIndex());
        }
    }

    public void addFuncItem(String icon, String text, int index) {
        FuncItemBtn item = new FuncItemBtn(index);
        item.setFont(item.getFont().deriveFont(Font.PLAIN, 14));
        ImageIcon sideBaricon = new ImageIcon(new ImageIcon(getClass().getResource("/assets/" + icon + ".png")).getImage().getScaledInstance(28, 28, Image.SCALE_SMOOTH));
        item.setIcon(sideBaricon);
        item.setText(" " + text);
        setBounds(100, 100, 100, 30);
        setForeground(new Color(255, 255, 255));

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    if (item != selectedItem) {
                        unSelectedItem = selectedItem;
                        selectedItem = item;
                        animator.start();
                        event.funcItemSelected(index);
                    }
                }
            }
        });
        menuPanel.add(item, "growx");
    }

    public void setSelected(int index) {
        for (Component com : menuPanel.getComponents()) {
            FuncItemBtn menu = (FuncItemBtn) com;
            if (menu.getIndex() == index) {
                if (menu != selectedItem) {
                    unSelectedItem = selectedItem;
                    selectedItem = menu;
                    animator.start();
                    event.funcItemSelected(index);
                }
                break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avatarPanel = new ui.component.AvatarPanel(curPerson.getAccount(), curPerson.getRoleType());
        menuPanel = new javax.swing.JPanel();
        exitBtn1 = new javax.swing.JLabel();

        setOpaque(false);

        menuPanel.setOpaque(false);

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );

        exitBtn1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        exitBtn1.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/exit.png"))); // NOI18N
        exitBtn1.setText("exit");
        exitBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitBtn1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitBtn1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(avatarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(exitBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(avatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(exitBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_exitBtn1MouseClicked

    private void exitBtn1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtn1MousePressed
        // TODO add your handling code here:
        exitEvent.labelClick();
    }//GEN-LAST:event_exitBtn1MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ui.component.AvatarPanel avatarPanel;
    private javax.swing.JLabel exitBtn1;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
