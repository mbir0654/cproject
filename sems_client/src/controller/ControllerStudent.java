/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import business.serviceinterface.InterfaceStudentService;
//import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import org.apache.commons.daemon.support.DaemonLoader;
import ui.*;

import java.util.List;

/**
 *
 * @author bsk
 */
public class ControllerStudent {
    private final Student student;
    private final InterfaceStudentService studentService;
    private FrameStudMain studentFrame;

    public ControllerStudent(Student s, InterfaceStudentService service) {
        this.student = s;
        studentService = service;
    }


    /*
     * METHODS for opening the student's frames
     */
     public void openStudentFrame() {
         studentFrame = new FrameStudMain(this);
         studentFrame.setNameStudent(student.getFirstName() + " " + student.getLastName());
         studentFrame.setUsernameStudent(student.getUserName());
         loadAnnouncements();
         loadTemeCourses();
         loadNoteListCursuri();
         loadMaterialeListCursuri();
         loadTabelCursuriContractate();
         loadTabelCursuriDisponibile();
         studentFrame.setIconImages(Controller.icons);
         studentFrame.setVisible(true);
     }


     public void loadAnnouncements(){
        List<Announcement> announcements = studentService.getAnnouncements(student);
        DefaultListModel model = new DefaultListModel();
        for (Announcement announcement:announcements) {
            model.addElement(announcement);
            System.out.println(announcement);
        }
        studentFrame.setAnnouncement(model);
     }

     public  void loadTemeCourses(){
         List<Course> courses = student.getContract().getCourses();
         DefaultComboBoxModel model = new DefaultComboBoxModel();
         for(Course course:courses){
             model.addElement(course);
         }
         studentFrame.setTemeListCursuri(model);
     }

    public void loadNoteListCursuri() {
        studentFrame.setNoteListCursuri(new DefaultComboBoxModel(student.getContract().getCourses().toArray()));
    }

    public void loadMaterialeListCursuri() {
        studentFrame.setMaterialeListCursuri(new DefaultComboBoxModel(student.getContract().getCourses().toArray()));
    }

    public void loadTabelExamene(Course course) {
        String [] columnNames = {"Data", "Tip examinare", "Nota obtinuta"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        for (Exam e:course.getExams()) {
            Object [] row = {e.getData(), e.getType(), e.getGrades()};
            model.addRow(row);
        }
        studentFrame.setTabelExamene(model);
    }

    public void loadTabelCursuriContractate(){
        String [] columnNames = {"Cod", "Nume", "Nr. credite", "Semestru"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        for (Course c:student.getContract().getCourses()) {
            Object [] row = {c.getCod(), c.getName(), c.getNumberOfCredits(), c.getSemestrul()};
            model.addRow(row);
        }
        studentFrame.setTableCursuriContractate(model);
    }

    public void loadTabelCursuriDisponibile() {
        String [] columnNames = {"Cod", "Nume", "Nr. credite", "Semestru"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        for (Course c:student.getSpecialty().getCourses()) {
            Object [] row = {c.getCod(), c.getName(), c.getNumberOfCredits(), c.getSemestrul()};
            model.addRow(row);
        }
        studentFrame.setTabelCursuriDisponibile(model);
    }

    public void loadListMaterialeCurs(Course course) {
        DefaultListModel model = new DefaultListModel();
        for (CourseMaterial m:course.getMaterialeDeCurs()) {
            model.addElement(m);
        }
        studentFrame.setMaterialeList(model);
    }

    public void loadTeme(Course course) {
        DefaultListModel model = new DefaultListModel();
        for (Assignment a:course.getAssignments()) {
            model.addElement(a);
        }
        studentFrame.setTemeList(model);
    }
}
