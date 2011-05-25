/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.Announcement;
import business.model.Assignment;
import business.model.Course;
import business.model.Exam;
import business.model.Grade;
import business.model.Student;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.*;
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

        /*
         * METHODS for opening the student's frames
         */
         public void openMainFrame() {
             
            frameStudMain mainFrame = new frameStudMain(this);
            mainFrame.setVisible(true);
            mainFrame.setTitle("SEMS :: Student " + s.getFirstName()+" "+s.getLastName());
            mainFrame.setResizable(false);
            
            // populam lista de cursuri la care e inscris studentul
            DefaultListModel dlm = new DefaultListModel();
           // for(Course c : s.getContract().getCourses()) {
            //    dlm.addElement(c);
            //}
            // de sters
            Course ct = new Course("TEST",2);
            dlm.addElement(ct);
            ///////////////////
            mainFrame.getListCursuri().setModel(dlm);

             //f.setVisible(false); //lasa linia asta comentata!!!
         }

	public void openContracts(){
		frameStudContracte contract = new frameStudContracte(this);
                contract.setTitle("SEMS :: Contracte");
                contract.setResizable(false);
                contract.getButContracteaza().setEnabled(false);
                contract.getPanouInfoCurs().setVisible(false);
                contract.setVisible(true);
	}
        
	public void openAssignments(frameStudMain main){
                 /*
                 * Incarcam lista de teme pentru cursul selectat din mainFrame
//                 */
                DefaultListModel dlm = new DefaultListModel();
                Course c = (Course) main.getListCursuri().getSelectedValue();
                    for(Assignment a : c.getAssignments()) {
                        dlm.addElement(a);
                    }
                dlm.addElement("TEST");


		frameStudTeme teme = new frameStudTeme(this);
                teme.getListTeme().setModel(dlm);
                teme.setVisible(true);
                teme.setTitle("SEMS :: Teme");
                teme.setResizable(false);
                teme.getLabelInfoTeme().setVisible(false);
                teme.getTemaDetalii().setEditable(false);
                teme.getLabelCursSelectat().setText(c.getName());

	}
        
        public void openCourseComponents(frameStudMain main){

                Course c = (Course) main.getListCursuri().getSelectedValue();
                

		frameStudMaterialeCurs materiale = new frameStudMaterialeCurs(this);
                materiale.setVisible(true);
                materiale.setTitle("SEMS :: Materiale");
                materiale.setResizable(false);
                materiale.getMaterialText().setEditable(false);
                materiale.getMaterialInfo().setVisible(false);
                materiale.getLabelCursSelected().setText(c.getName());
	}

        /*
         * Metoda folosita pentru a deschide frame-ul de note al studentului
         */
        public void openGrades(frameStudMain main) {

                Course selectedCourse = (Course) main.getListCursuri().getSelectedValue();

                
		frameStudNote note = new frameStudNote(this);
                note.setVisible(true);
                note.setTitle("SEMS :: Note");
                note.setResizable(false);
                // afisam informatia pentru cursul selectat

                            // populam lista de cursuri la care e inscris studentul
            DefaultComboBoxModel dlm = new DefaultComboBoxModel();
            for(Course c : s.getContract().getCourses())
                dlm.addElement(c);


            note.getComboCursuri().setSelectedItem(selectedCourse);
            note.getComboCursuri().setModel(dlm);
	}
        /*
         * Metoda folosita pentru a repopula tabelul de note al unui student
         * in functie de cursul selectat.
         */
         public void getGradeInfo(frameStudNote f, Course selectedCourse) {
             DefaultTableModel dtm = new DefaultTableModel();
             for(Exam e : selectedCourse.getExams()) {
                 for(Grade g : e.getGrades()) {
                      // de completat
                 }
             }
         }

        /**
         *  Metoda folosita pentru a activa/deactiva butoanele la
         *  selectarea unui curs in frame-ul principal al studentului.
         */
	public void setStudMainButtons(boolean var, frameStudMain f) {
                f.getButTrimiteTeme().setEnabled(var);
                f.getButMaterialeCurs().setEnabled(var);
                f.getButNote().setEnabled(var);
        }

        /*
         * Metode folosite in frame-ul frameStudContracte
         */
          
    	public void enableContractButtons(frameStudContracte f){
		f.getButContracteaza().setEnabled(true);
	//	f.getPanouInfoCurs().setEnabled(true);
                f.getPanouInfoCurs().setVisible(true);
	}

        /**
         *  Seteaza informatiile despre un curs, o data la selectarea acestuia
         */
       public void getContractInfo(frameStudContracte f) {
                int selectedContractIndex = f.getListCursuri().getSelectedIndex();
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
                f.getLabelMaterialText().setText("TEXTUL materialului");
                f.getLabelTitlu().setText("Titlu materialului");
                
	}
        /**
         * Metode folosite in frame-ul frameStudNote
         */
        public void enableTestList(frameStudNote f){
		//f.getListTeste().setVisible(true);
	}

        public void enableTestInfo(frameStudNote f){
		//f.getInfoTest().setVisible(true);
             //   f.getLabelTitlu().setText("TITLU");
            //    f.getLabelData().setText("12/23/2322");
            //    f.getLabelNota().setText("10");
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
