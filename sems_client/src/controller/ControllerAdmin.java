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

import java.math.BigInteger;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author myh si bsk
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
        loadFaculties();
        loadAdministrators();
        adminMain.setLabelNumeAdmin(administrator);
        adminMain.setLabelUserAdmin(administrator);
        adminMain.setVisible(true);
    }


    //inmatriculeaza student
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
            //password
            String password = adminMain.getInmatriculareStudentParola();
            student.setPassword(md5(password));

            administratorService.addStudent(student);
        }

    //prima pagina
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

        public DefaultComboBoxModel loadGrupeByFaculta_combo (Faculty faculty){
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            model.addElement(null);
            if(faculty != null){
                for(Specialty specialty:faculty.getSpecialties()){
                    for(Group group:specialty.getGroups()){
                        model.addElement(group);
                    }
                }
            }
            return model;
        }
        public DefaultListModel loadStudentiByGrupa_list(Group group){
            DefaultListModel model = new DefaultListModel();
            model.addElement(null);
            if(group != null){
                List<Student> students = group.getStudents();
                for(Student s:students){
                    model.addElement(s);
                }
            }
            return model;
        }
        public DefaultListModel loadCursuriByFaculta_list (Faculty faculty){
            DefaultListModel model = new DefaultListModel();
            model.addElement(null);
            if(faculty != null){
                for(Specialty specialty:faculty.getSpecialties()){
                    for(Course course:specialty.getCourses()){
                        model.addElement(course);
                    }
                }
            }
            return model;
        }
        public DefaultListModel loadProgesoriByFaculta_list (Faculty faculty){
            DefaultListModel model = new DefaultListModel();
            model.addElement(null);
            if(faculty != null){
                List<Professor> professors = new ArrayList<Professor>();
                for(Specialty specialty:faculty.getSpecialties()){
                    for(Course course:specialty.getCourses()){
                        System.out.println(course.getProfessors());
                        for(Professor professor:course.getProfessors()){
                            if(!professors.contains(professor))
                                professors.add(professor);
                        }
                    }
                }

                for(Professor professor:professors){
                    model.addElement(professor);
                }
            }
            return model;
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
            DefaultListModel model = new DefaultListModel();
            if(faculty != null){
                if(!faculty.getSpecialties().isEmpty()){
                    List<Specialty> specialties = faculty.getSpecialties();
                    for (Specialty s:specialties) {
                        model.addElement(s);
                    }
                }
            }
            adminMain.setSpecialties(model);
        }

        //adauga
        public void addFaculty(){
            Faculty faculty = new Faculty();
            faculty.setName(adminMain.getAddFacultyName());
            faculty.setAddress(adminMain.getAddFacultyAdress());
            administratorService.addFaculty(faculty);
        }
        public void addAdministrator(){
            Administrator administrator = new Administrator();
            administrator.setLastName(adminMain.getAddAdminLastName());
            administrator.setFirstName(adminMain.getAddAdminLastName());
            administrator.setUserName(adminMain.getAddAdminUsername());
            administrator.setPassword(md5(adminMain.getAddAdminPassword()));
            administratorService.addAdministrator(administrator);
        }
        //sterge
        public void deleteAdministrator(Administrator administrator){
            administratorService.deleteAdministrator(administrator);
        }
        public void deleteCourse(Course course){
            DialogConfirm dialogConfirm = new DialogConfirm(adminMain,true);
            dialogConfirm.pack();

            administratorService.deleteCourse(course);
            loadFaculties();
            adminMain.reloadCursuriList();
        }
        public void deleteProfessor(Professor professor){
            administratorService.deleteProfessor(professor);
            loadFaculties();
        }

    //gestiune rapoarte (chestia aia din mijloc)
        //load Combo boxes
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
        //load lista
        public DefaultListModel loadProfesori_genDupaCurs(Course course){
            DefaultListModel model = new DefaultListModel();
            if(course != null){
                for(Professor professor:course.getProfessors()){
                    model.addElement(professor);
                }
            }
            return  model;
        }
        //load tabel
        public DefaultTableModel loadTableCourse_genDupaStud(Student student){
            DefaultTableModel model = new DefaultTableModel(
                    new Object [][] {},
                    new String [] {
                        "COD", "Nume curs", "Nr. Credite", "Sem."
                    }
                ) {
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                };

            if(student != null){
                for(Course course:student.getContract().getCourses()){
                    Object [] obj = new Object []
                        {
                            course.getCod(),
                            course.getName(),
                            course.getNumberOfCredits(),
                            course.getSemestrul()
                        };

                    model.addRow(obj);
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
        public DefaultTableModel  loadTableNote_genDupaCurs(Course course){
            DefaultTableModel model = new DefaultTableModel(
                    new Object [][] {},
                    new String [] {
                        "Grupa", "Nume", "Nota finala"
                    }
                ) {
                    boolean[] canEdit = new boolean [] {
                        false, false, true
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                };

            if(course != null){
                for(Exam exam:course.getExams()){
                    if(exam.getType().equals("final")){
                        for(Grade grade:exam.getGrades()){
                            Object [] obj = new Object [] {
                                    grade.getStud().getGroup(),
                                    grade.getStud().getFirstName() + " " + grade.getStud().getLastName(),
                                    grade.getGrade()
                                };
                            model.addRow(obj);
                        }
                    }
                }
            }
            return model;
        }

    public String md5(String var){
        String var_return = "";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] data = var.getBytes();
            m.update(data,0,data.length);
            BigInteger i = new BigInteger(1,m.digest());
            var_return = String.format("%1$032X", i);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return var_return;
    }

    public void addProfessor() {
        DialogAddProf dialog = new DialogAddProf(adminMain, true);
        dialog.pack();
        dialog.setVisible(true);
        Professor prof = new Professor();
        prof.setTitle(dialog.getTitlu());
        prof.setFirstName(dialog.getPrenume());
        prof.setLastName(dialog.getNume());
        prof.setUserName(dialog.getUser());
        prof.setPassword(md5(dialog.getParola()));
        administratorService.addProfesor(prof);
    }

    public void addCourse(Faculty faculty) {
        DialogAddCourse dialog = new DialogAddCourse(adminMain, true);
        dialog.pack();
        dialog.setSpecializari(loadSpecialties_combo(faculty));
        dialog.setSemestru(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2" }));
        dialog.setVisible(true);
        Course course = new Course();
        course.setCod(dialog.getCod());
        course.setName(dialog.getDenumire());
        //course.setSemestrul(dialog.getSemestru());
        course.setSpecializare(dialog.getSpecializare());
        course.setNumberOfCredits(dialog.getNrCredite());
        administratorService.addCourse(course);
        loadFaculties();
        adminMain.reloadCursuriList();
    }


}
