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
import data.dbutil.MySqlException;
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
                        dbu.close();
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
                    DbUtil dbu = new DbUtil();
                    List<DbObject> data1 = item.toDbObjectList();
                    SqlFunctions.insert("users", data1,dbu);
                    List<DbObject> data2 = item.toDbObjectListStud();
                    SqlFunctions.insert("students", data2,dbu);
                    List<DbObject> data3 = item.toDbObjectListSS();
                    SqlFunctions.insert("students_specializations", data3,dbu);
                    List<DbObject> data4 = item.toDbObjectListContract();
                    SqlFunctions.insert("contracts", data4,dbu);
                    dbu.close();
		} catch (MySqlException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
            try     {
                DbUtil dbu =  new DbUtil();
                List<DbObject> data1 = item.toDbObjectList();
                List<DbObject> data2 = item.toDbObjectListStud();
                SqlFunctions.update("users", data1, "userName = '"
                    +item.getUserName()+"'");
                SqlFunctions.update("students", data2, "userName = '"
                    +item.getUserName()+"'");
                ResultSet rs1 = dbu.getDate("select c.contractId from " +
                               "contracts c inner join students_specializations"
                               +" ss on c.ssId = ss.ssId inner join students s"
                               +" on ss.studentId = s.studentId where " +
                               "s.userName = '"+item.getUserName()+"'");
                if(rs1.next()){
                    Integer ctid = rs1.getInt(1);
                    SqlFunctions.delete("contracts_data", "contractId="
                            +ctid);
                    System.out.println("Sters toate cursurile " +
                            "din contract");
                }
                rs1 = dbu.getDate("select ssId from students_" +
                "specializations where studentId in(select studentId from" +
                " students where userName='"+item.getUserName()+"') limit 1");
                if(rs1.next()){
                Integer ssid = rs1.getInt(1);
                SqlFunctions.delete("solutions","assignmentId = "+ssid);
                }
                for (Course c : item.getContract().getCourses()){
                    List<DbObject> data4 = item.toDbObjectListContractCourses(c);
                    try{
                        SqlFunctions.insert("contracts_data", data4,dbu);
                    }catch(MySqlException e){
                        e.getMessage();
                    }
                    for(Assignment a : c.getAssignments()){
                        ResultSet rs = dbu.getDate("SELECT assignmentId FROM " +
                                "assignments where text = '"+a.getText()+"'");
                        if(rs.next()){
                            Integer asid = rs.getInt(1);
                            for(AssignmentSolution as : item.getSolutions()){
                                List<DbObject> data5 = item.
                                        toDbObjectListSolutions(c,as, asid);
                                try{
                                    SqlFunctions.insert("solutions", data5, dbu);
                                }catch (MySqlException e){
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }
                }
                dbu.close();
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
                    if(!SqlFunctions.delete("users", "userName = '"+
                            item.getUserName()+"'"))
                        System.err.println("no students deleted!");
                    System.out.println(item.getUserName()+" - deleted");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
