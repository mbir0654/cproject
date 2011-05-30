/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import business.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business.serviceinterface.InterfaceAdministratorService;
import ui.*;

import java.security.KeyStore;
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
        DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
        modelCombo.addElement(null);
        for (Faculty f:faculties) {
            model.addElement(f);
            modelCombo.addElement(f);
        }
        adminMain.setFaculties(model);
        adminMain.setComboListFacultati(modelCombo);
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

    public DefaultComboBoxModel loadSpecialties_combo(Faculty faculty){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(null);
        if(faculty != null){
            List<Specialty> specialties = faculty.getSpecialties();
            for (Specialty s:specialties) {
                model.addElement(s);
            }
        }
        return model;
    }

    public DefaultComboBoxModel loadGrupe_combo(Specialty specialty){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(null);
        if(specialty != null){
            List<Group> groups = specialty.getGroups();
            for (Group group:groups){
                model.addElement(group);
            }
        }
        return model;
    }

    public DefaultComboBoxModel loadStudenti_combo(Specialty specialty){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(null);
        if(specialty != null){
            List<Group> groups = specialty.getGroups();
            for (Group group:groups){
                List<Student> students = group.getStudents();
                for(Student s:students){
                    model.addElement(s);
                }
            }
        }
        return model;
    }

    public DefaultComboBoxModel loadCursuri_combo(Specialty specialty){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(null);
        if(specialty != null){
            List<Course> courses = specialty.getCourses();
            for (Course course:courses){
                model.addElement(course);

            }
        }
        return model;
    }
    public DefaultComboBoxModel loadStudentByGrupa_combo(Group group){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(null);
        if(group != null){
            List<Student> students = group.getStudents();
            for(Student s:students){
                model.addElement(s);
            }
        }
        return model;
    }

    public DefaultTableModel  loadTable_genDupaStud(Student student){
        DefaultTableModel model = new DefaultTableModel(
                new Object [][] {} ,
                new String [] { "Curs", "Credite", "Nota finala" }
            ){
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            };

        if(student != null){
            List<Course> courses = student.getContract().getCourses();
            for(Course course:courses){
                Integer nota_finala = null;
                for(Exam exam:course.getExams()){
                    if(exam.getCourse().equals(course)){
                        for(Grade grade:exam.getGrades()){
                            if(grade.getStud().equals(student))
                                nota_finala = grade.getGrade();
                        }
                    }
                }
                Object [] obj = new Object [] {course.getName(), course.getNumberOfCredits(), nota_finala };
                System.out.println("Obj: " + course.getName() +  course.getNumberOfCredits() + nota_finala );
                model.addRow(obj);
            }
        }
        return model;
    }



    public void loadInmatriculeazaStudentSpecialties(Faculty faculty){
        if(faculty!= null){
            List<Specialty> specialties = faculty.getSpecialties();
            System.out.println("Facultate: " + faculty + "Specializari: "+faculty.getSpecialties());
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement(null);
            for(Specialty specialty:specialties){
                model.addElement(specialty);
            }
            adminMain.setInmatriculeazaStudentSpecialties(model);
        }
    }
    public void loadInmatriculeazaStudentAnStudiu(Specialty specialty){
        if(specialty != null){
            int nrofyears = specialty.getNumberOfYears();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for(int i=1;i<=nrofyears;i++){
                model.addElement(i);
            }
            adminMain.setInmatriculeazaStudentAnStudiu(model);
        }
    }
    public void loadInmatriculeazaStudentGrupa(Specialty specialty){
        if(specialty != null){
            List<Group> groups = specialty.getGroups();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for(Group group:groups){
                model.addElement(group);
            }
            adminMain.setInmatriculeazaStudentGrupe(model);
        }
    }
    public void addInmatriculeazaStudent(){
        Student student = new Student();
        student.setFirstName(adminMain.getInmatriculareStudentNume());
        student.setLastName(adminMain.getInmatriculareStudentPrenume());
        student.setCnp(adminMain.getInmatriculareStudentCnp());

        student.setSpecialty(adminMain.getInmatriculareStudentSpecializare());
        student.setYear(adminMain.getInmatriculareStudentAnStudiu());
        student.setGroup(adminMain.getInmatriculareStudentGrupa());
        student.setNrMat(adminMain.getInmatriculareStudentNrMat());

        student.setUserName(adminMain.getInmatriculareStudentUsername());
        student.setPassword(adminMain.getInmatriculareStudentParola());

        administratorService.addStudent(student);
    }
    public void loadCourses(Faculty faculty) {
        List<Specialty> specialties = faculty.getSpecialties();
        DefaultListModel model = new DefaultListModel();
        for (Specialty s:specialties) {
            for (Course c:s.getCourses()) {
                model.addElement(c);
            }
        }
        adminMain.setListCursuri(model);
    }
}
