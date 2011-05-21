/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.Course;
import business.model.Professor;
import javax.swing.DefaultListModel;
import ui.*;
/**
 *
 * @author snoopy
 */
public class ControllerProfesor {
    private final Professor p;

    public ControllerProfesor(Professor pr) {
        this.p=pr;
    }
    
    /** 
     * Metode folosite in frame-ul frameProfMain
     */

    public void mainSetButtonState(frameProfMain f, boolean state) {
        f.getButEvaluari().setEnabled(state);
        f.getButTeme().setEnabled(state);
        f.getButCatalog().setEnabled(state);
        f.getButAddCurs().setEnabled(state);
        f.getButDelCurs().setEnabled(state);
        f.getButModCurs().setEnabled(state);
    }


    /**
     * Metode folosite pentru deschiderea altor frame-uri
     */
    public void openAnnouncements() {
        frameProfAnunturi anunt = new frameProfAnunturi(this);
        anunt.setVisible(true);
        anunt.setTitle("SEMS :: Anunturi");
        anunt.setResizable(false);
    }

    public void openStudentGroups() {
        frameProfGrupeStud grupe = new frameProfGrupeStud(this);
        grupe.setVisible(true);
        grupe.setResizable(false);
        grupe.setTitle("SEMS :: Grupe Studenti");

    }

    public void openEvaluations() {
        frameProfEvaluari evaluari = new frameProfEvaluari(this);
        evaluari.setVisible(true);
        evaluari.setResizable(false);
        evaluari.setTitle("SEMS :: Evaluari");
    }

    public void openTeme() {
        frameProfTeme teme = new frameProfTeme(this);
        teme.setVisible(true);
        teme.setResizable(false);
        teme.setTitle("SEMS :: Alocari teme");
    }

    public void openCatalog() {
        frameProfCatalog catalog = new frameProfCatalog(this);
        catalog.setVisible(true);
        catalog.setTitle("SEMS :: Catalog");
    }

    // to-do-s
    public void addCourseComponents() {

    }
    public void delCourseComponents() {
        
    }
    public void modCourseComponents() {

    }
    // end of to-do-s

    /**
     * end of frame openings
     */

    /**
     * Start of Professor's methods
     */
    public void loadCourses(frameProfMain f){
            DefaultListModel dlm = new DefaultListModel();
            dlm.addElement("TEST");
            for (Course  c : p.getCourses()){
                dlm.addElement(c.getName());
            }
            f.getListCursuri().setModel(dlm);
        }
}
