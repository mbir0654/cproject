package business.service;

import data.repositorydb.AdministratorRepository;
import data.repositorydb.FacultyRepository;
import data.repositorydb.ProfessorRepository;
import data.repositorydb.StudentRepository;
import business.model.*;
import business.serviceinterface.InterfaceAdministratorService;
import data.repositoryinterface.Repository;
import java.util.List;


/**
 * @author myh
 * 	
 */
public final class AdministratorService implements InterfaceAdministratorService {

    @SuppressWarnings("unused")
	private Repository<Professor> profRepo = ProfessorRepository.getInstance();
	@SuppressWarnings("unused")
	private Repository<Student> studRepo = StudentRepository.getInstance();
	private Repository<Faculty> facultyRepo = FacultyRepository.getInstance();
	private Repository<Administrator> adminRepo = AdministratorRepository.getInstance();

	public String hello() {
        return "greetings, from admin";
    }

    /**
     * 
     * logout and save data
     */
	public void exitSystem() {
	}

    /**
     * 
     * inmatricularea unui student nou
     */
	public void registerStudent() {
	}

    /**
     * 
     * administreaza resurse (facultati, profesori, cursuri, specializari)
     */
    public void manageResources() {
	}

    /**
    * 
    * gestionare de facultati
    */
	public void manageFaculties() {
	}

    /**
    * 
    * gestionare de specializari
    */
    public void manageSpecializations() {
	}

    /**
     * 
     * gestionare de cursuri
     */
	public void manageCourses() {
	}

    /**
     * 
     * gestionare de profesori
     */
	public void manageProfessors() {
	}

    /**
     * 
     * gestionare de administratori
     */
	public void manageAdministrators() {
	}

    /**
     * 
     * aprobare si salvare contract de stdiu
     */
	public void approveContracts() {
	}

    /**
     * 
     * generare de rapoarte
     */
	public void generateReports() {
	}

	/**
	 * 
	 */
    public List<Administrator> getAdministrators() {
        return adminRepo.getAll();
    }

    /**
     * 
     */
    public List<Faculty> getFaculties() {
        return facultyRepo.getAll();
    }
}
