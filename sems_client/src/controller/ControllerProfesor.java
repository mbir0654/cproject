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


    
    /** 
     * Metode folosite in frame-ul FrameProfMain
     */

    public void mainSetButtonState(FrameProfMain f, boolean state) {
        f.getButEvaluari().setEnabled(state);
        f.getButTeme().setEnabled(state);
        f.getButCatalog().setEnabled(state);
        f.getButAddCurs().setEnabled(state);
        f.getButDelCurs().setEnabled(state);
    }

    public void mainLoadCourses(FrameProfMain f) {
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
       FrameProfMain main = new FrameProfMain(this);
       main.setVisible(true);
       main.setTitle("SEMS :: Profesor");
       main.setResizable(false);
       this.mainSetButtonState(main, false);
       // si ne incarcam cursurile unui profesor in lista.
       this.mainLoadCourses(main);
       //f.setVisible(false); //lasa linia asta comentata!!!
    }
    public void openAnnouncements() {
        FrameProfAnunturi anunt = new FrameProfAnunturi(this);
        anunt.setVisible(true);
        anunt.setTitle("SEMS :: Anunturi");
        anunt.setResizable(false);
        anunt.getInfoText().setVisible(false);
        this.loadAnunturi(anunt);
        this.loadAnuntCursuri(anunt);
    }

    public void openStudentGroups() {
        FrameProfGrupeStud grupe = new FrameProfGrupeStud(this);
        grupe.setVisible(true);
        grupe.setResizable(false);
        grupe.setTitle("SEMS :: Grupe Studenti");

    }

    public void openEvaluations() {
        FrameProfEvaluari evaluari = new FrameProfEvaluari(this);
        evaluari.setVisible(true);
        evaluari.setResizable(false);
        evaluari.setTitle("SEMS :: Evaluari");
    }

    public void openTeme() {
        FrameProfTeme teme = new FrameProfTeme(this);
        teme.setVisible(true);
        teme.setResizable(false);
        teme.setTitle("SEMS :: Alocari teme");
    }

    public void openCatalog() {
        FrameProfCatalog catalog = new FrameProfCatalog(this);
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
    public void loadCourses(FrameProfMain f){
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
    public void loadAnunturi(FrameProfAnunturi f) {
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
    public void loadAnuntCursuri(FrameProfAnunturi f) {
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
    public void showAnunt(FrameProfAnunturi f) {
        Announcement a = (Announcement) f.getListAnunturi().getSelectedValue();
        f.getPanouAnunt().setVisible(true);
        f.getPanouTitlu().setText(a.getSubiect());
        f.getPanouData().setText(a.getData().toString());
        f.getPanouMesaj().setText(a.getAnnouncement());
    }
    /*
     * Metoda de adaugare a unui anunt la un curs.
     */
    public void addAnunt(FrameProfAnunturi f) {
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
     public void delAnunt(FrameProfAnunturi f) {
         Announcement a = (Announcement) f.getListAnunturi().getSelectedValue();
         p.getAnnouncements().remove(a);
         this.loadAnunturi(f);
         f.getPanouAnunt().setVisible(false);
     }

         /**
     * Metode folosite in frame-ul FrameProfCatalog
     */
     public void loadCatalogCursuri(FrameProfCatalog f) {
         DefaultComboBoxModel dlm = new DefaultComboBoxModel();
         for(Course c : p.getCourses())
             dlm.addElement(c);

        // DE STERS
        dlm.addElement(new Course("TEST",2));
        //////////
        f.getComboCursuri().setModel(dlm);
     }

     public void loadCatalogGroups(FrameProfCatalog f) {
         Course c = (Course)f.getComboCursuri().getSelectedItem();
         DefaultListModel dlm = new DefaultListModel();
         for(Group g : p.getGroups()){
            if(g.getSpecialty().getCourses().equals(c)){
                dlm.addElement("Grupa "+g.getGroupName()+" ("+g.getStudentNr()+")");
            }
         }
         // DE STERS
         Group t = new Group();
         t.setGroupName("221");
         dlm.addElement("Grupa "+t.getGroupName()+" ("+t.getStudentNr()+")");
         /////////////////
         f.getListGrupe().setModel(dlm);
         f.getListGrupe().setEnabled(true);
     }
}
