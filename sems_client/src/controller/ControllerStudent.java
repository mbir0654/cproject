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

import business.serviceinterface.InterfaceStudentService;
import ui.*;
/**
 *
 * @author snoopy
 */
public class ControllerStudent {
    private final Student s;
    private final InterfaceStudentService studentService;

    public ControllerStudent(Student s, InterfaceStudentService service) {
        this.s = s;
        studentService = service;
    }

        /*
         * METHODS for opening the student's frames
         */
         public void openMainFrame() {
             
            FrameStudMain mainFrame = new FrameStudMain(this);
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
          //  mainFrame.getListCursuri().setModel(dlm);

             //f.setVisible(false); //lasa linia asta comentata!!!
         }


        
	public void openAssignments(FrameStudMain main){
                 /*
                 * Incarcam lista de teme pentru cursul selectat din mainFrame
//                 */

        DefaultListModel dlm = new DefaultListModel();
      //  Course c = (Course) main.getListCursuri().getSelectedValue();
     //   for(Assignment a : c.getAssignments()) {
      //      dlm.addElement(a);
      //  }
        dlm.addElement("TEST");
	
	}
        
    public void openCourseComponents(FrameStudMain main){

      //  Course c = (Course) main.getListCursuri().getSelectedValue();
               
	}

        /*
         * Metoda folosita pentru a deschide frame-ul de note al studentului
         */
    public void openGrades(FrameStudMain main) {
    //    Course selectedCourse = (Course) main.getListCursuri().getSelectedValue();

	}
        /*
         * Metoda folosita pentru a repopula tabelul de note al unui student
         * in functie de cursul selectat.
         */
         public void getGradeInfo(Course selectedCourse) {
             DefaultTableModel dtm = new DefaultTableModel();
             for(Exam e : selectedCourse.getExams()) {
                 for(Grade g : e.getGrades()) {
                      // de completat
                 }
             }
         }


        public void loadAnnounces(FrameStudMain f) {
            DefaultListModel dlm = new DefaultListModel();
            dlm.addElement("TEST");
            for(Course c : s.getContract().getCourses()) {
                for(Announcement a : c.getAnnouncements()) {
                    dlm.addElement(a.getSubiect()+" ("+a.getProf()+")");
                }
            }
         //   f.getListAnunturi().setModel(dlm);
        }
        public void showMainAnnounce(FrameStudMain f) {
            
       //     f.getLabelAnuntCurs().setText("Titlu anunt");
       ///    f.getLabelAnuntProf().setText("Bufny");
       //     f.getLabelAnuntText().setText("textul anuntului");
       //     f.getLabelAnuntTitlu().setText("Titlu anuntului");
        }

        public void loadCursuri(FrameStudMain f){
            DefaultListModel dlm = new DefaultListModel();
            dlm.addElement("TEST");
            for (Course  c : s.getContract().getCourses()){
                dlm.addElement(c.getName());
            }
        //    f.getListCursuri().setModel(dlm);
        }

}
