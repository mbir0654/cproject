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
}
