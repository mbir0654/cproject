/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.Announcement;
import business.model.Course;
import business.model.Group;
import business.model.Professor;
import business.model.Student;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
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
    }

    public void mainLoadCourses(frameProfMain f) {
        DefaultListModel dlm = new DefaultListModel();
        for(Course c : this.p.getCourses()) {
            dlm.addElement(c);
        }

        // DE STERS
        dlm.addElement(new Course("TEST",2));
        f.getListCursuri().setModel(dlm);
    }

    /**
     * Metode folosite pentru deschiderea altor frame-uri
     */
    public void openMainFrame() {
       frameProfMain main = new frameProfMain(this);
       main.setVisible(true);
       main.setTitle("SEMS :: Profesor");
       main.setResizable(false);
       this.mainSetButtonState(main, false);
       // si ne incarcam cursurile unui profesor in lista.
       this.mainLoadCourses(main);
       //f.setVisible(false); //lasa linia asta comentata!!!
    }
    public void openAnnouncements() {
        frameProfAnunturi anunt = new frameProfAnunturi(this);
        anunt.setVisible(true);
        anunt.setTitle("SEMS :: Anunturi");
        anunt.setResizable(false);
        anunt.getInfoText().setVisible(false);
        this.loadAnunturi(anunt);
        this.loadAnuntCursuri(anunt);
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
        this.loadCatalogCursuri(catalog);
        catalog.getListGrupe().setEnabled(false);
        this.loadCatalogGroups(catalog);
    }

    // to-do-s
    public void addCourseComponents() {

    }
    public void delCourseComponents() {
        
    }
    public void modCourseComponents() {

    }

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

    /*
     * Start of Professor Announcements methods
     */
    public void loadAnunturi(frameProfAnunturi f) {
        DefaultListModel dlm = new DefaultListModel();
        for(Announcement a : p.getAnnouncements())
            dlm.addElement(a);

        // DE STERS
        dlm.addElement(new Announcement("TEST mesaj","TEST SUBJECT",new Date(),
        		new Course()));
        
        //////////
        f.getListAnunturi().setModel(dlm);
    }

    /*
     * Metoda pentru a incarca lista de cursuri valabile
     */
    public void loadAnuntCursuri(frameProfAnunturi f) {
        DefaultComboBoxModel dlm = new DefaultComboBoxModel();
        for(Course c : p.getCourses())
            dlm.addElement(c);
        
        // DE STERS
        dlm.addElement(new Course("TEST",2));
        //////////
        f.getComboCursuri().setModel(dlm);
    }
    /*
     * Metoda pentru a afisa un anunt selectat
     */
    public void showAnunt(frameProfAnunturi f) {
        Announcement a = (Announcement) f.getListAnunturi().getSelectedValue();
        f.getPanouAnunt().setVisible(true);
        f.getPanouTitlu().setText(a.getSubiect());
        f.getPanouData().setText(a.getData().toString());
        f.getPanouMesaj().setText(a.getAnnouncement());
    }
    /*
     * Metoda de adaugare a unui anunt la un curs.
     */
    public void addAnunt(frameProfAnunturi f) {
        Announcement a = new Announcement(
        		f.getAddMesaj().getText(),f.getAddTitlu().getText(),
        		new Date(),(Course) f.getComboCursuri().getSelectedItem());
        a.setProf(p);
        p.addAnnouncement(a);
        f.getInfoText().setVisible(true);
        f.getAddMesaj().setText("");
        f.getAddTitlu().setText("");
        this.loadAnunturi(f);
    }
        /*
         * Metoda pentru a sterge anuntul selectat
         */
     public void delAnunt(frameProfAnunturi f) {
         Announcement a = (Announcement) f.getListAnunturi().getSelectedValue();
         p.getAnnouncements().remove(a);
         this.loadAnunturi(f);
         f.getPanouAnunt().setVisible(false);
     }

         /**
     * Metode folosite in frame-ul frameProfCatalog
     */
     public void loadCatalogCursuri(frameProfCatalog f) {
         DefaultComboBoxModel dlm = new DefaultComboBoxModel();
         for(Course c : p.getCourses())
             dlm.addElement(c);

        // DE STERS
        dlm.addElement(new Course("TEST",2));
        //////////
        f.getComboCursuri().setModel(dlm);
     }

     public void loadCatalogGroups(frameProfCatalog f) {
         Course c = (Course)f.getComboCursuri().getSelectedItem();
         DefaultListModel dlm = new DefaultListModel();
         for(Group g : p.getGroups()){
            if(g.getSpecialty().getCourses().equals(c)){
                dlm.addElement("Grupa "+g.getGroup()+" ("+g.getStudentNr()+")");
            }
         }
         // DE STERS
         Group t = new Group();
         t.setGroup("221");
         dlm.addElement("Grupa "+t.getGroup()+" ("+t.getStudentNr()+")");
         /////////////////
         f.getListGrupe().setModel(dlm);
         f.getListGrupe().setEnabled(true);
     }
}
