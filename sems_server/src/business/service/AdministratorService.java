package business.service;

import data.repositorydb.*;
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
    private Repository<Course> courseRepo = CourseRepository.getInstance();

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
    //by bsk
    public void addStudent(Student student){
        //md5- pasword
        studRepo.add(student);
        System.out.println("Adaugam un student nou" + student);
    }
    public void addFaculty(Faculty faculty){
        facultyRepo.add(faculty);
        System.out.println("Am adaugat o noua facultate: " + faculty);
    }
    public void addAdministrator(Administrator administrator){
        adminRepo.add(administrator);
        System.out.println("Am adaugat un admin: " + administrator);
    }
    public void addProfesor(Professor professor){
        profRepo.add(professor);
        System.out.println("Am adaugat un prof:  " + professor);
    }
    public void deleteAdministrator(Administrator administrator){
        System.out.println("Vom sterge adminul:" + administrator);
        adminRepo.delete(administrator);
    }
    public void deleteCourse(Course course){
        courseRepo.delete(course);
    }
    public void deleteProfessor(Professor professor){
        profRepo.delete(professor);
    }
    public void addCourse(Course course){
        courseRepo.add(course);
         System.out.println("add_curs :" + course);
    }

    public void updateProfessor(Professor professor) {
        profRepo.update(professor);
    }

    public void updateCourse(Course course) {
        courseRepo.update(course);
    }

}
