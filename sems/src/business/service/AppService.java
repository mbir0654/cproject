/**
 * 
 */
package business.service;
import java.util.*;
import business.model.*;
/**
 * @author myh
 *
 */
public class AppService {
	/**
	 * atribut privat pentru singleton
	 */
	private static AppService apps = new AppService();
	
	/**
	 *  cvonstuctor privat pentru singleton
	 */
	private AppService(){
		
	}
	
	/**
	 * permite accesul la singura instanta existenta a clasei
	 * 
	 * @return atributul privat <b>apps</b>, pentru a asigura unicitatea 
	 * 		   serviciului in toata aplicatia 
	 */
	public static AppService getInstance(){
		return apps;
	}
	
	public User ValidateUser(String username, String password, String type) {
		return null;
	}
	
	public List<Course> getContractCourses(Student student) {
		return null;
	}

	public List<Course> getAllCourses(Student student) {
		return null;
	}
	
	public List<Announcement> getAnnouncements(Course course) {
		return null;
	}

	public List<Announcement> getAnnouncements(Professor prof) {
		return null;
	}
	
	/** 
	 * prof adauga o tema
	 * @param prof profu carea adauga
	 * @param course la ce curs adauga
	 * @return daca s-a putut adauga sau nu in lista de assignments
	 */
	public boolean addAssignment(Professor prof, Course course) {
		return true;
	}

	/**
	 * Returneaza toate examenele care le-a dat studentul
	 * @param student
	 * @return
	 */
	public List<Exam> getExams(Student student) {
		return null;
	}
	
	/**
	 * Returneaza o lista de node a unui student
	 * @param student
	 * @return
	 */
	public List<Grade> getGrades(Student student) {
		return null;
	}
	
	
}
