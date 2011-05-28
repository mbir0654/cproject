/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.*;

import business.serviceinterface.InterfaceStudentService;
import ui.*;

import java.util.List;

/**
 *
 * @author snoopy
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

        loadAnnouncement();
        studentFrame.setVisible(true);
     }

     public void loadAnnouncement(){
        List<Announcement> announcements = studentService.getAnnouncements(student);
        DefaultListModel model = new DefaultListModel();
        for (Announcement announcement:announcements) {
            model.addElement(announcement);
            System.out.println(announcement);
        }
        studentFrame.setAnnouncement(model);
     }



}
