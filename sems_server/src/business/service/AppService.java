/**
 * 
 */
package business.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import data.dbutil.DbUtil;
import data.repositorydb.AdministratorRepository;
import data.repositoryinterface.Repository;
import business.model.*;
import business.serviceinterface.InterfaceAppService;

/**
 * @author BSK:D
 *
 */
public class AppService implements InterfaceAppService {
	/**
	 * atribut privat pentru singleton
	 */
	private static AppService apps = new AppService();
	
	private Repository<User> userRepo;
	
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
	
	/**
	 * Validam daca un username cu o parola exista. In caz afirmativ returnam userul respectiv
	 * @param username
	 * @param password
	 * @return User (Administratpr/Teacher/Student)
	 */
	public User ValidateUser(String username, String password) {
		String sql = "SELECT userId, rol FROM users " +
						"WHERE userName = '" + username + "' " +
						"AND password = '" + password + "' " +
						"LIMIT 1";
		DbUtil db;
		try {
			db = new DbUtil();
			ResultSet rs = db.getDate(sql);

			rs.last();
		    if(rs.getRow() == 1){
		    	String userId = rs.getString("userId");
		    	String rol = rs.getString("rol");
		    	User s;
		    	if(rol == "admin"){
		    		userRepo = AdministratorRepository.getInstance();
		    	} else if (rol == "prof") {
		    		userRepo = ProfessorRepository.getInstance();
		    	} else if (rol == "stud"){
		    		userRepo = StudentRepository.getInstance();
		    	}
		    	User u = userRepo.findByName(userId);
		    	return u;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
