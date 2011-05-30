/**
 * 
 */
package data.repositorydb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.model.*;
import data.dbutil.DbObject;
import data.dbutil.DbUtil;
import data.dbutil.SqlFunctions;
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
		try {
			List<DbObject> data1 = item.toDbObjectList();
			List<DbObject> data2 = item.toDbObjectListStud();
			List<DbObject> data3 = item.toDbObjectListSS();
			List<DbObject> data4 = item.toDbObjectListContract();
			SqlFunctions.insert("users", data1);
			SqlFunctions.insert("students", data2);
			SqlFunctions.insert("students_specializations", data3);
			SqlFunctions.insert("contracts", data4);
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
		try {
			List<DbObject> data1 = item.toDbObjectList();
			List<DbObject> data2 = item.toDbObjectListStud();
			//List<DbObject> data3 = item.toDbObjectListSS();
			//List<DbObject> data4 = item.toDbObjectListContract();
			SqlFunctions.update("users", data1, "userName = '"+item.getUserName()+"'");
			SqlFunctions.update("students", data2, "userName = '"+item.getUserName()+"'");
			//SqlFunctions.update("students_specializations", data3, "spId  = "+data3.get(1).getValue());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Student item) {
		l.remove(item);
		try {
			SqlFunctions.delete("users", "userName = '"+item.getUserName()+"'");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
