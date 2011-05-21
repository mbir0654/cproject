/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameProfGrupeStud.java
 *
 * Created on Apr 9, 2011, 7:48:04 AM
 */

package ui;

import controller.ControllerProfesor;

/**
 *
 * @author snoopy
 */
public class frameProfGrupeStud extends javax.swing.JFrame {
     private ControllerProfesor c;
    /** Creates new form frameProfGrupeStud */
    public frameProfGrupeStud(ControllerProfesor cp) {
        initComponents();
        this.c=cp;
        panouTransfer.setVisible(false);
        panouAdauga.setVisible(false);
        butTransferStud.setEnabled(false);
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listGrupe = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        butTransferStud = new javax.swing.JButton();
        butAddStud = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listStudenti = new javax.swing.JList();
        panouTransfer = new javax.swing.JPanel();
        labelStudNume = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelStudGrupa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        butTransfera = new javax.swing.JButton();
        panouAdauga = new javax.swing.JPanel();
        dropDownStudent = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        butAdd = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEMS :: Grupe studenti", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista grupelor"));

        listGrupe.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Grupa 221 (5 membrii)", "Grupa 223 (10 membrii)", "Grupa 666 (1 membru)" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listGrupe.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listGrupe.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listGrupeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listGrupe);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Optiuni grupa"));

        butTransferStud.setText("Transfera student");
        butTransferStud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTransferStudActionPerformed(evt);
            }
        });

        butAddStud.setText("Adauga student");
        butAddStud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddStudActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butAddStud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butTransferStud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(butAddStud)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butTransferStud)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista studentilor"));

        listStudenti.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Bunta Adrian", "Mihut Bogdan", "Varvi" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listStudenti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listStudentiValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listStudenti);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panouTransfer.setBorder(javax.swing.BorderFactory.createTitledBorder("Transfera student"));

        labelStudNume.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelStudNume.setText("Bunta Adrian");

        jLabel1.setText("din grupa");

        labelStudGrupa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelStudGrupa.setText("221");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Grupa destinatie");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Grupa 666", "Grupa 667", "Grupa 220" }));

        butTransfera.setText("Transfera");
        butTransfera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTransferaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panouTransferLayout = new javax.swing.GroupLayout(panouTransfer);
        panouTransfer.setLayout(panouTransferLayout);
        panouTransferLayout.setHorizontalGroup(
            panouTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panouTransferLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panouTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(butTransfera)
                    .addGroup(panouTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addGroup(panouTransferLayout.createSequentialGroup()
                            .addComponent(labelStudNume)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelStudGrupa))
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panouTransferLayout.setVerticalGroup(
            panouTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panouTransferLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panouTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelStudNume)
                    .addComponent(labelStudGrupa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butTransfera)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panouAdauga.setBorder(javax.swing.BorderFactory.createTitledBorder("Adauga student"));

        dropDownStudent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Apintei Ioana", "Cristian Bostan", "Sardabagiu Mihai" }));

        jLabel3.setText("Grupa destinatie");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Grupa 221", "Grupa 223", "Grupa 666" }));

        butAdd.setText("Adauga");
        butAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panouAdaugaLayout = new javax.swing.GroupLayout(panouAdauga);
        panouAdauga.setLayout(panouAdaugaLayout);
        panouAdaugaLayout.setHorizontalGroup(
            panouAdaugaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panouAdaugaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panouAdaugaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dropDownStudent, 0, 147, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, 0, 147, Short.MAX_VALUE)
                    .addComponent(butAdd, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panouAdaugaLayout.setVerticalGroup(
            panouAdaugaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panouAdaugaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dropDownStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panouTransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panouAdauga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, 0, 243, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panouTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panouAdauga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listGrupeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listGrupeValueChanged

}//GEN-LAST:event_listGrupeValueChanged

    private void butTransferaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTransferaActionPerformed

        panouTransfer.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_butTransferaActionPerformed

    private void butAddStudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddStudActionPerformed

        panouAdauga.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_butAddStudActionPerformed

    private void butAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActionPerformed

        panouAdauga.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_butAddActionPerformed

    private void butTransferStudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTransferStudActionPerformed

        panouTransfer.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_butTransferStudActionPerformed

    private void listStudentiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listStudentiValueChanged

        butTransferStud.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_listStudentiValueChanged

    /**
    * @param args the command line arguments
    */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAdd;
    private javax.swing.JButton butAddStud;
    private javax.swing.JButton butTransferStud;
    private javax.swing.JButton butTransfera;
    private javax.swing.JComboBox dropDownStudent;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelStudGrupa;
    private javax.swing.JLabel labelStudNume;
    private javax.swing.JList listGrupe;
    private javax.swing.JList listStudenti;
    private javax.swing.JPanel panouAdauga;
    private javax.swing.JPanel panouTransfer;
    // End of variables declaration//GEN-END:variables

}
