package business.serviceinterface;

import business.model.*;

import java.util.*;

/**
 * @author biskis
 * 	
 */

public interface InterfaceAdministratorService {
    public String hello();
	public void exitSystem() ;
	public void registerStudent();
	public void manageResources() ;
	public void manageFaculties();
	public void manageSpecializations();
	public void manageCourses() ;
	public void manageProfessors();
	public void manageAdministrators();
	public void approveContracts();
	public void generateReports();
    public List<Administrator> getAdministrators();
    public List<Faculty> getFaculties();
    public void addStudent(Student student);
    public void addFaculty(Faculty faculty);
    public void addAdministrator(Administrator administrator);
    public void addProfesor(Professor professor);
    public void deleteAdministrator(Administrator administrator);
    public void deleteCourse(Course course);
    public void deleteProfessor(Professor professor);
    public void updateProfessor(Professor professor);
    public void updateCourse(Course course);
}
