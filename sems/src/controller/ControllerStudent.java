/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.Announcement;
import business.model.Course;
import business.model.Student;
import javax.swing.DefaultListModel;
import ui.*;
/**
 *
 * @author snoopy
 */
public class ControllerStudent {
        private final Student s;

    public ControllerStudent(Student s) {
        this.s = s;
    }

        

	public void openContracts(){
		frameStudContracte contract = new frameStudContracte(this);
        contract.setTitle("SEMS :: Contracte");
        contract.setResizable(false);
        contract.getButContracteaza().setEnabled(false);
        contract.getPanouInfoCurs().setVisible(false);
        contract.setVisible(true);
	}

	public void setStudMainButtons(boolean var, frameStudMain f) {
        f.getButTrimiteTeme().setEnabled(var);
        f.getButMaterialeCurs().setEnabled(var);
        f.getButNote().setEnabled(var);

        }
        
	public void openAssignments(){
		frameStudTeme teme = new frameStudTeme(this);
        teme.setVisible(true);
        teme.setTitle("SEMS :: Teme");
        teme.setResizable(false);
        teme.getLabelInfoTeme().setVisible(false);
        teme.getTemaDetalii().setEditable(false);
	}
        
        public void openCourseComponents(){
		frameStudMaterialeCurs materiale = new frameStudMaterialeCurs(this);
        materiale.setVisible(true);
        materiale.setTitle("SEMS :: Materiale");
        materiale.setResizable(false);
        materiale.getMaterialText().setEditable(false);
        materiale.getMaterialInfo().setVisible(false);
	}

        public void openGrades(){
		frameStudNote note = new frameStudNote(this);
        note.setVisible(true);
        note.setTitle("SEMS :: Note");
        note.setResizable(false);
        note.getListTeste().setVisible(false);
        note.getInfoTest().setVisible(false);
	}


        /**
         * Metode folosite in frame-ul frameStudContracte
         */
    	public void enableContractButtons(frameStudContracte f){
		f.getButContracteaza().setEnabled(true);
	//	f.getPanouInfoCurs().setEnabled(true);
                f.getPanouInfoCurs().setVisible(true);
	}
        
        public void getContractInfo(frameStudContracte f) {
            f.getLabelDenumire().setText("Denumire");
            f.getLabelCod().setText("cod223");
            f.getLabelCredite().setText("5");
            f.getLabelOre().setText("1S + 2P");
            f.getLabelAnPredare().setText("2");
            f.getLabelPredatDe().setText("lolus mihailus");
        }

        /**
         *  Metode folosite in frame-ul frameStudTeme
         */
        public void enableAssignmentActions(frameStudTeme f){
		f.getLabelInfoTeme().setVisible(true);
                f.getLabelTemaCurs().setText("nume curs");
                f.getLabelTemaData().setText("12/04/2011");
                f.getLabelTemaDetalii().setText("detalii despre tema");
                f.getLabelTemaNota().setText("10");
                f.getLabelTemaTermen().setText("2 sapt");
                f.getLabelTemaTitlu().setText("titlu tema");
                // aici un if , daca exista sau nu data, pentru a
                // da enable la butonul de incarca tema, sau nu
                f.getButIncarca().setEnabled(false);
	}

        /**
         * Metode folosite in frame-ul frameStudMaterialeCurs
         */
        public void showComponentInfo(frameStudMaterialeCurs f){
		f.getMaterialInfo().setVisible(true);
                f.getLabelAdaugatDe().setText("Bufny");
                f.getLabelMaterialText().setText("TEXTUL materialului");
                f.getLabelTitlu().setText("Titlu materialului");
                
	}
        /**
         * Metode folosite in frame-ul frameStudNote
         */
        public void enableTestList(frameStudNote f){
		f.getListTeste().setVisible(true);
	}

        public void enableTestInfo(frameStudNote f){
		f.getInfoTest().setVisible(true);
                f.getLabelTitlu().setText("TITLU");
                f.getLabelData().setText("12/23/2322");
                f.getLabelNota().setText("10");
	}

        /**
         * Metode folosite in frame-ul frameStudMain
         */
        public void loadAnnounces(frameStudMain f) {
            DefaultListModel dlm = new DefaultListModel();
            dlm.addElement("TEST");
            for(Course c : s.getContract().getCourses()) {
                for(Announcement a : c.getAnnouncements()) {
                    dlm.addElement(a.getSubiect()+" ("+a.getProf()+")");
                }
            }
            f.getListAnunturi().setModel(dlm);
            
        }
        public void showMainAnnounce(frameStudMain f) {
            
            f.getLabelAnuntCurs().setText("Titlu anunt");
            f.getLabelAnuntProf().setText("Bufny");
            f.getLabelAnuntText().setText("textul anuntului");
            f.getLabelAnuntTitlu().setText("Titlu anuntului");
        }

        public void loadCursuri(frameStudMain f){
            DefaultListModel dlm = new DefaultListModel();
            dlm.addElement("TEST");
            for (Course  c : s.getContract().getCourses()){
                dlm.addElement(c.getName());
            }
            f.getListCursuri().setModel(dlm);
        }

}
