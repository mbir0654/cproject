/**
 * 
 */
package data.repositorydb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.model.*;
import data.dbutil.DbUtil;
import data.repositoryinterface.*;

/**
 * @author otniel
 *
 */
public class StudentRepository implements Repository<Student>{
	
	private List<Student> l;
	
	private static final StudentRepository theStudents = new StudentRepository();
	
	private StudentRepository (){
		l = new ArrayList<Student>();
		Student s;
		try {
			DbUtil dbu = new DbUtil();
			String str = "select * from users where role = 'stud'";
			ResultSet rs = dbu.getDate(str);
			while (rs.next()){
				s = new Student();
				s.setFirstName(rs.getString("firstName"));
				s.setLastName(rs.getString("lastName"));
				s.setUserName(rs.getString("userName"));
				s.setPassword(rs.getString("password"));
				l.add(s);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static StudentRepository getInstance(){
		return theStudents;
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Student item) {
		l.add(item);		
		DbUtil dbu;
		try {
			dbu = new DbUtil();
			String str = "insert into users values('"+item.getFirstName()+"','"+
			item.getLastName()+"','"+item.getUserName()+"','"+item.getPassword()+
			"','stud')";
			dbu.makeUpdate(str);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Student> getAll() {
		List<Student> r = new ArrayList<Student>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#findByName(java.lang.String)
	 */
	@Override
	public Student findByName(String id) {
		for(Student s : l){
			if(s.getUserName().equalsIgnoreCase(id))
				return s;
		}
		return null;
	}

	/**
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Student item) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Student item) {
		l.remove(item);
		DbUtil dbu;
		try {
			dbu = new DbUtil();
			String str  = "delete from users where userName = "+item.getUserName();
			dbu.makeUpdate(str);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
