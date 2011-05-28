package business.service;

import business.model.Professor;
import business.serviceinterface.InterfaceProfessorService;

/**
 * @author myh
 *
 */
final class ProfessorService implements InterfaceProfessorService {
    public String hello() {
        return "hello, from prof";
    }

	@SuppressWarnings("unused")
	private Professor p;
	
	public void exitSystem() {
		/**
		 * TODO
		 * logout and save all data
		 */
	}
	public void mannageAnnouncements() {
		/**
		 * TODO
		 * gestionare anunturi pentru cursuri
		 */
	}
	public void viewCourses(){
		/**
		 * TODO 
		 * vizualizare cursuri la care participa
		 */
	}
	public void mannageStudentsGroups() {
		/**
		 * TODO
		 * gestionare grupe de studenti
		 */
	}
	public void generateCatalog() {
		/**
		 * TODO
		 * generare catalog
		 */
	}
	public void manageHomeworks() {
		/**
		 * TODO
		 * gestionare teme
		 */
	}
	public void manageTests() {
		/**
		 * TODO
		 * gestionare teste
		 */
	}
	public void manageExams() {
		/**
		 * TODO
		 * gestionare examene
		 */
	}
}
