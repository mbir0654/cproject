package business.service;

import business.model.Administrator;
import business.serviceinterface.InterfaceAdministratorService;


/**
 * @author myh
 * 	
 */
public final class AdministratorService implements InterfaceAdministratorService {

    public String hello() {
        return "greetings, from admin";
    }
	
	@SuppressWarnings("unused")
	private Administrator a;
	
	public void exitSystem() {
		/**
		 * TODO
		 * logout and save data
		 */
	}
	public void registerStudent() {
		/**
		 * TODO
		 * inmatricularea student nou
		 */
	}
	public void manageResources() {
		/**
		 * TODO
		 * administreaza resurse (facultati, profesori, cursuri, specializari)
		 */
	}
	public void manageFaculties() {
		/**
		 * TODO
		 * gestionare de facultati
		 */
	}
	public void manageSpecializations() {
		/**
		 * TODO
		 * gestionare de specializari
		 */
	}
	public void manageCourses() {
		/**
		 * TODO 
		 * gestionare de cursuri
		 */
	}
	public void manageProfessors() {
		/**
		 * TODO
		 * gestionare de profesori
		 */
	}
	public void manageAdministrators() {
		/**
		 * TODO
		 * gestionare de administratori
		 */
	}
	public void approveContracts() {
		/**
		 * TODO
		 * aprobare si salvare contract de stdiu
		 */
	}
	public void generateReports() {
		/** 
		 * TODO
		 * generare de rapoarte
		 */
	}
}
