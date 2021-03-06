/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameLogin.java
 *
 * Created on Apr 7, 2011, 3:23:08 PM
 */

package ui;
import java.awt.event.ActionEvent;
import javax.swing.*;

import controller.Controller;


import java.awt.*;

/**
 *
 * @author Snoopy
 * <p>updated by othniel to controller</p>
 */

public class FrameLogin extends javax.swing.JFrame {
	private final Controller c;

    /** Creates new form FrameLogin */
    public FrameLogin(Controller controller) {
        initComponents();
        infoText.setVisible(false);
        c = controller;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SEMS = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        butLogin = new javax.swing.JButton();
        infoText = new javax.swing.JLabel();
        inputPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("Login"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setForeground(new java.awt.Color(0, 51, 153));

        SEMS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        SEMS.setIcon(new javax.swing.ImageIcon("C:\\Users\\snoopy\\Desktop\\SEMS.png")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Username");

        inputUser.setForeground(new java.awt.Color(0, 51, 102));
        inputUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUserActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 153));
        jLabel3.setText("Password");

        butLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        butLogin.setForeground(new java.awt.Color(0, 0, 102));
        butLogin.setText("Autentificare");
        butLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLoginActionPerformed(evt);
            }
        });

        infoText.setForeground(new java.awt.Color(204, 0, 0));
        infoText.setText("label pt erori");

        inputPass.setForeground(new java.awt.Color(0, 51, 102));
        inputPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SEMS)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(infoText)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(butLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputPass)
                                .addComponent(inputUser, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                        .addGap(48, 48, 48)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(SEMS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoText)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUserActionPerformed
    c.checkLogin();
    }//GEN-LAST:event_inputUserActionPerformed

    private void inputPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPassActionPerformed
    c.checkLogin();
    }//GEN-LAST:event_inputPassActionPerformed

    private void butLoginActionPerformed(java.awt.event.ActionEvent evt) {
    c.checkLogin();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SEMS;
    private javax.swing.JButton butLogin;
    private javax.swing.JLabel infoText;
    private javax.swing.JPasswordField inputPass;
    private javax.swing.JTextField inputUser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public JLabel getInfoText() {
        return infoText;
    }

    public JPasswordField getInputPass() {
        return inputPass;
    }

    public JTextField getInputUser() {
        return inputUser;
    }

    
}
