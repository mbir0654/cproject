package business.serviceinterface;

import java.util.*;
import business.model.*;
/**
 * @author Biskis
 *
 */
public interface InterfaceAppService {
	
	public User ValidateUser(String username, String password);
	
	public List<Course> getContractCourses(Student student);

	public List<Course> getAllCourses(Student student);
	
	public List<Announcement> getAnnouncements(Course course);

	public List<Announcement> getAnnouncements(Professor prof);
	
	/** 
	 * prof adauga o tema
	 * @param prof profu carea adauga
	 * @param course la ce curs adauga
	 * @return daca s-a putut adauga sau nu in lista de assignments
	 */
	public boolean addAssignment(Professor prof, Course course);

	/**
	 * Returneaza toate examenele care le-a dat studentul
	 * @param student
	 * @return
	 */
	public List<Exam> getExams(Student student);
	
	/**
	 * Returneaza o lista de node a unui student
	 * @param student
	 * @return
	 */
	public List<Grade> getGrades(Student student);
	
	
}
