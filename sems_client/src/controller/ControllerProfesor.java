/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.*;
import java.text.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import business.serviceinterface.InterfaceProfessorService;
import com.sun.rowset.internal.Row;
import java.util.Calendar;
import ui.*;
/**
 *
 * @author bsk
 */
public class ControllerProfesor {
    private final Professor professor;
    private final InterfaceProfessorService professorService;
    private FrameProfMain profesorFrame;

    public ControllerProfesor(Professor pr, InterfaceProfessorService service) {
        this.professor = pr;
        professorService = service;
    }

    public void openProfesorFrame(){
        profesorFrame = new FrameProfMain(this);
        profesorFrame.setUserName(professor.getUserName());
        profesorFrame.setFullName(professor.getFirstName() + " " + professor.getLastName());
        loadAnnouncements();
        loadAddAnnouncements();
        profesorFrame.setVisible(true);
    }

    public void loadAnnouncements(){
        List<Announcement> announcements = professorService.getAnnouncements(professor);
        DefaultListModel model = new DefaultListModel();
        for(Announcement announcement:announcements){
            model.addElement(announcement);
        }
        profesorFrame.setAnnouncements(model);
    }

    public void loadComboListGrupe(Course c){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Group g : professorService.getGroups(professor)){
            /*if(g.getStudents().get(0) != null){
                for(Course cc : g.getStudents().get(0).getContract().getCourses())
                    if(cc.getCod().equals(cc.getCod()))*/
                    model.addElement(g);
            //}
        }
        profesorFrame.setCatalogListGrupa(model);
    }

    public  void loadComboListCursuri(){
        List<Course> courses = professorService.getCourses(professor);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Course course:courses){
            model.addElement(course);
        }
        profesorFrame.setComboListCurs(model);
    }

    public void loadAddAnnouncements(){
        loadComboListCursuri();
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter=
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateNow = formatter.format(currentDate.getTime());
        profesorFrame.setAnuntAddData(dateNow);
    }

    public void addAnnouncement(){
        Announcement announcement = new Announcement();
        announcement.setAnnouncement(profesorFrame.getAnuntAddMesaj());
        announcement.setCourse(profesorFrame.getAnuntAddCurs());
        announcement.setDate(Calendar.getInstance().getTime());
        announcement.setSubject(profesorFrame.getAnuntAddTitlu());
        professor.addAnnouncement(announcement);
        professorService.addAnnouncement(professor, announcement);
        loadAnnouncements();
    }

    public void deleteAnnouncement(Announcement announcement){
       professorService.deleteAnnouncemnt(announcement);
    }

    public void loadCatalogByCurs(Course course){
        List<Student> students = professorService.getStudentsByCourse(course);
        DefaultTableModel model = new DefaultTableModel();
        for(Student student:students){
            model.addRow(new Object [] {student.getFirstName() + " " + student.getLastName(), "aiz", 5});
        }
    }
}
