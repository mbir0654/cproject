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

    private Repository<Professor> profRepo = ProfessorRepository.getInstance();
	private Repository<Student> studRepo = StudentRepository.getInstance();
	private Repository<Faculty> facultyRepo = FacultyRepository.getInstance();
	private Repository<Administrator> adminRepo = AdministratorRepository.getInstance();

	public String hello() {
        return "greetings, from admin";
    }
	
	@SuppressWarnings("unused")

    /**
     * TODO
     * logout and save data
     */
	public void exitSystem() {
	}

    /**
     * TODO
     * inmatricularea unui student nou
     */
	public void registerStudent() {
	}

    /**
     * TODO
     * administreaza resurse (facultati, profesori, cursuri, specializari)
     */
    public void manageResources() {
	}

    /**
    * TODO
    * gestionare de facultati
    */
	public void manageFaculties() {
	}

    /**
    * TODO
    * gestionare de specializari
    */
    public void manageSpecializations() {
	}

    /**
     * TODO
     * gestionare de cursuri
     */
	public void manageCourses() {
	}

    /**
     * TODO
     * gestionare de profesori
     */
	public void manageProfessors() {
	}

    /**
     * TODO
     * gestionare de administratori
     */
	public void manageAdministrators() {
	}

    /**
     * TODO
     * aprobare si salvare contract de stdiu
     */
	public void approveContracts() {
	}

    /**
     * TODO
     * generare de rapoarte
     */
	public void generateReports() {
	}

    public List<Administrator> getAdministrators() {
        return adminRepo.getAll();
    }

    public List<Faculty> getFaculties() {
        return facultyRepo.getAll();
    }
}
