/**
 * 
 */
package business.service;

import business.serviceinterface.InterfaceStudentService;
import data.repositorydb.StudentRepository;


/**
 * @author myh
 *
 */
final class StudentService implements InterfaceStudentService{

    public String hello() {
        return "greetings, from student";
    }
	
	/**
	 * The student for which we offer the services.
	 */
	
	@SuppressWarnings("unused")
	private StudentRepository sr = StudentRepository.getInstance();
	
	public StudentService(){		
	}
	
	public void viewCourses(){
		
	}
	
	public void viewAnnouncements(){
		/**TODO
		 * vizualizare anunturi pentru student s 
		 */
	}
	public void makeContract(){
		/**TODO
		 * load courses
		 * open makeContractDialog
		 */
	}
	public void viewAvailableCourses(){
		/**TODO
		 * load available courses from db and reload a jlist  
		 */
	}
	public void viewMatterials(){
		
	}
	public void viewGrades(){
	
	}
	public void sendHomeWork(){

	}
}
