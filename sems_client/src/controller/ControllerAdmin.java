/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.Administrator;
import javax.swing.DefaultListModel;

import business.model.Faculty;
import business.model.Specialty;
import business.serviceinterface.InterfaceAdministratorService;
import ui.*;

import java.util.List;

/**
 *
 * @author myh
 */
public class ControllerAdmin {
    private final Administrator administrator;
    private final InterfaceAdministratorService administratorService;
    private FrameAdminMain adminMain;

    public ControllerAdmin(Administrator admin, InterfaceAdministratorService service) {
        this.administrator = admin;
        this.administratorService = service;
    }

    public void openAdminFrame() {
        adminMain = new FrameAdminMain(this);
        adminMain.setVisible(true);
        loadFaculties();
        loadAdministrators();
        adminMain.setLabelNumeAdmin(administrator);
        adminMain.setLabelUserAdmin(administrator);
    }

    public void loadFaculties() {
        List<Faculty> faculties = administratorService.getFaculties();
        DefaultListModel model = new DefaultListModel();
        for (Faculty f:faculties) {
            model.addElement(f);
        }
        adminMain.setFaculties(model);
    }

    public void loadAdministrators() {
        List<Administrator> administrators = administratorService.getAdministrators();
        DefaultListModel model = new DefaultListModel();
        for (Administrator a:administrators) {
            model.addElement(a);
        }
        adminMain.setAdministrators(model);
    }

    public void loadSpecialties(Faculty faculty) {
        List<Specialty> specialties = faculty.getSpecialties();
        DefaultListModel model = new DefaultListModel();
        for (Specialty s:specialties) {
            model.addElement(s);
        }
        adminMain.setSpecialties(model);
    }
}
