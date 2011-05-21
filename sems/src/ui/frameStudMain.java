/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frameStudMain.java
 *
 * Created on Apr 10, 2011, 3:36:32 PM
 */

package ui;
import java.awt.Color;
import javax.swing.*;
import controller.*;


/**
 *
 * @author snoopy
 * <p>updated by othniel to controller</p>
 */
public class frameStudMain extends javax.swing.JFrame {
	private ControllerStudent c;

    /** Creates new form frameStudMain */
    public frameStudMain(ControllerStudent cs) {
        this.c=cs;
        initComponents();
        c.setStudMainButtons(false, this);
        c.loadCursuri(this);
        c.loadAnnounces(this);
        }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcome = new javax.swing.JPanel();
        panouCursuriInscris = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCursuri = new javax.swing.JList();
        panouAnunturi = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        labelAnuntTitlu = new javax.swing.JLabel();
        labelAnuntProf = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        labelAnuntText = new javax.swing.JTextArea();
        titluAnunturi = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAnunturi = new javax.swing.JList();
        labelAnuntCurs = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        butMaterialeCurs = new javax.swing.JButton();
        butNote = new javax.swing.JButton();
        butTrimiteTeme = new javax.swing.JButton();
        butLogout = new javax.swing.JButton();

        welcome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Welcome to SEMS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 51, 255))); // NOI18N

        panouCursuriInscris.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursuri la care sunteti inscris"));

        listCursuri.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Analiza matematica", "Algebra", "Arhitectura Calculatoarelor", "Baze de date", "Proiect colectiv" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listCursuri.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCursuri.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCursuriValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listCursuri);

        javax.swing.GroupLayout panouCursuriInscrisLayout = new javax.swing.GroupLayout(panouCursuriInscris);
        panouCursuriInscris.setLayout(panouCursuriInscrisLayout);
        panouCursuriInscrisLayout.setHorizontalGroup(
            panouCursuriInscrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panouCursuriInscrisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        panouCursuriInscrisLayout.setVerticalGroup(
            panouCursuriInscrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panouCursuriInscrisLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panouAnunturi.setBorder(javax.swing.BorderFactory.createTitledBorder("Anunturi"));

        labelAnuntTitlu.setFont(new java.awt.Font("Tahoma", 1, 12));
        labelAnuntTitlu.setText("Anunt test 1");

        labelAnuntProf.setText("Prof. Mircea Badea");

        labelAnuntText.setColumns(20);
        labelAnuntText.setFont(new java.awt.Font("Arial", 0, 10));
        labelAnuntText.setRows(5);
        labelAnuntText.setText("aeq wqkjenljkqw njlkeqw\n eqwjkne qwlkjnej kqwe \nqw ejkqwnlkje qnwkenkqw \n eqw");
        labelAnuntText.setEnabled(false);
        jScrollPane3.setViewportView(labelAnuntText);

        titluAnunturi.setFont(new java.awt.Font("Tahoma", 1, 11));
        titluAnunturi.setText("Titlul anuntului");

        listAnunturi.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Anunt test 1 (Prof. Dan Stirb)", "In gura presei (Prof. Mircea Badea)", "Etc Etc (Dr. Ing. Mihai Gugu)" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listAnunturi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listAnunturi.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listAnunturiValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listAnunturi);

        labelAnuntCurs.setFont(new java.awt.Font("Tahoma", 1, 12));
        labelAnuntCurs.setText("Baze de date");

        javax.swing.GroupLayout panouAnunturiLayout = new javax.swing.GroupLayout(panouAnunturi);
        panouAnunturi.setLayout(panouAnunturiLayout);
        panouAnunturiLayout.setHorizontalGroup(
            panouAnunturiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panouAnunturiLayout.createSequentialGroup()
                .addGroup(panouAnunturiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panouAnunturiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panouAnunturiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(titluAnunturi)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)))
                    .addGroup(panouAnunturiLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(labelAnuntTitlu))
                    .addGroup(panouAnunturiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelAnuntCurs))
                    .addGroup(panouAnunturiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelAnuntProf)))
                .addContainerGap())
        );
        panouAnunturiLayout.setVerticalGroup(
            panouAnunturiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panouAnunturiLayout.createSequentialGroup()
                .addComponent(titluAnunturi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAnuntCurs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAnuntProf)
                .addGap(11, 11, 11)
                .addComponent(labelAnuntTitlu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Optiuni"));

        jButton1.setText("Completeaza contract");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        butMaterialeCurs.setText("Materiale de curs");
        butMaterialeCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMaterialeCursActionPerformed(evt);
            }
        });

        butNote.setText("Note");
        butNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butNoteActionPerformed(evt);
            }
        });

        butTrimiteTeme.setText("Trimite teme");
        butTrimiteTeme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTrimiteTemeActionPerformed(evt);
            }
        });

        butLogout.setText("Delogare");
        butLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(butLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(butNote, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(butMaterialeCurs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(butTrimiteTeme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butTrimiteTeme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butMaterialeCurs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butNote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout welcomeLayout = new javax.swing.GroupLayout(welcome);
        welcome.setLayout(welcomeLayout);
        welcomeLayout.setHorizontalGroup(
            welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panouCursuriInscris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panouAnunturi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        welcomeLayout.setVerticalGroup(
            welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeLayout.createSequentialGroup()
                .addGroup(welcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(welcomeLayout.createSequentialGroup()
                        .addComponent(panouCursuriInscris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panouAnunturi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listCursuriValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCursuriValueChanged
        c.setStudMainButtons(true, this);
    }//GEN-LAST:event_listCursuriValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	c.openContracts();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void butTrimiteTemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTrimiteTemeActionPerformed
    	c.openAssignments();
    }//GEN-LAST:event_butTrimiteTemeActionPerformed

    private void butMaterialeCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMaterialeCursActionPerformed
    	c.openCourseComponents();
    }//GEN-LAST:event_butMaterialeCursActionPerformed

    private void butNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butNoteActionPerformed
    	c.openGrades();
    }//GEN-LAST:event_butNoteActionPerformed

    private void butLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLogoutActionPerformed
        this.dispose();
    }//GEN-LAST:event_butLogoutActionPerformed

    private void listAnunturiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listAnunturiValueChanged

        c.showMainAnnounce(this);
        // TODO add your handling code here:
    }//GEN-LAST:event_listAnunturiValueChanged


    /**
	 * @param butNote the butNote to set
	 */
	public void setButNote(javax.swing.JButton butNote) {
		this.butNote = butNote;
	}


	/**
	 * @return the butNote
	 */
	public javax.swing.JButton getButNote() {
		return butNote;
	}


	/**
	 * @param butMaterialeCurs the butMaterialeCurs to set
	 */
	public void setButMaterialeCurs(javax.swing.JButton butMaterialeCurs) {
		this.butMaterialeCurs = butMaterialeCurs;
	}


	/**
	 * @return the butMaterialeCurs
	 */
	public javax.swing.JButton getButMaterialeCurs() {
		return butMaterialeCurs;
	}


	/**
	 * @param butTrimiteTeme the butTrimiteTeme to set
	 */
	public void setButTrimiteTeme(javax.swing.JButton butTrimiteTeme) {
		this.butTrimiteTeme = butTrimiteTeme;
	}


	/**
	 * @return the butTrimiteTeme
	 */
	public javax.swing.JButton getButTrimiteTeme() {
		return butTrimiteTeme;
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butLogout;
    private javax.swing.JButton butMaterialeCurs;
    private javax.swing.JButton butNote;
    private javax.swing.JButton butTrimiteTeme;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelAnuntCurs;
    private javax.swing.JLabel labelAnuntProf;
    private javax.swing.JTextArea labelAnuntText;
    private javax.swing.JLabel labelAnuntTitlu;
    private javax.swing.JList listAnunturi;
    private javax.swing.JList listCursuri;
    private javax.swing.JPanel panouAnunturi;
    private javax.swing.JPanel panouCursuriInscris;
    private javax.swing.JLabel titluAnunturi;
    private javax.swing.JPanel welcome;
    // End of variables declaration//GEN-END:variables

    public JList getListCursuri() {
        return listCursuri;
    }

    public JList getListAnunturi() {
        return listAnunturi;
    }

    public JLabel getLabelAnuntCurs() {
        return labelAnuntCurs;
    }

    public JLabel getLabelAnuntProf() {
        return labelAnuntProf;
    }

    public JTextArea getLabelAnuntText() {
        return labelAnuntText;
    }

    public JLabel getLabelAnuntTitlu() {
        return labelAnuntTitlu;
    }

    
}
