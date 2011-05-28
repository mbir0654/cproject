/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.Announcement;
import business.model.Course;
import business.model.Group;
import business.model.Professor;

import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import business.serviceinterface.InterfaceProfessorService;
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

    public void loadCourses_combo(){
        List<Course> courses = professorService.getCourses(professor);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for(Course course:courses){
            model.addElement(course);
        }
        profesorFrame.setAnuntAddCurs(model);
    }

    public void addAnnouncement(){
        Announcement announcement = new Announcement();
        announcement.setAnnouncement(profesorFrame.getAnuntAddMesaj());
        announcement.setCourse(profesorFrame.getAnuntAddCurs());
        announcement.setData(new Date(profesorFrame.getAnuntAddData()));
        announcement.setSubject(profesorFrame.getAnuntAddTitlu());
        professor.addAnnouncement(announcement);
        professorService.addAnnouncement(professor, announcement);
    }

    /*public void deleteAnnouncement(Announcement an){

    } */
   
}
