/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameAdminConfirm.java
 *
 * Created on Apr 8, 2011, 1:18:36 PM
 */

package ui;

/**
 *
 * @author snoopy
 */
public class frameAdminConfirm extends javax.swing.JFrame {

    /** Creates new form frameAdminConfirm */
    public frameAdminConfirm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        semsResurse = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        semsResurse.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEMS :: Confirmare", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 51, 153))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setText("Da");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Sunteti sigur?");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton2.setText("Nu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout semsResurseLayout = new javax.swing.GroupLayout(semsResurse);
        semsResurse.setLayout(semsResurseLayout);
        semsResurseLayout.setHorizontalGroup(
            semsResurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semsResurseLayout.createSequentialGroup()
                .addGroup(semsResurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(semsResurseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(semsResurseLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        semsResurseLayout.setVerticalGroup(
            semsResurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semsResurseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(semsResurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(semsResurse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(semsResurse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // de completat

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel semsResurse;
    // End of variables declaration//GEN-END:variables

}
