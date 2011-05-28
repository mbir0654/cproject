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

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import business.serviceinterface.InterfaceProfessorService;
import ui.*;
/**
 *
 * @author snoopy
 */
public class ControllerProfesor {
    private final Professor p;
    private final InterfaceProfessorService professorService;
    public ControllerProfesor(Professor pr, InterfaceProfessorService service) {
        this.p = pr;
        professorService = service;
    }

   
}
