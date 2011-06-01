/**
 * 
 */
package business.model;

import data.dbutil.DbObject;
import data.dbutil.DbUtil;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CLJ
 *
 */
public class Group implements Serializable {
	private List<Student> students;
	private String group;
	private Specialty specialty;

	/**
	 * Constructor implicit
	 */
    public Group() {
    	group="";
        students = new ArrayList<Student>();
    }
    
    /**
     * Constructor parametrizat
     * @param gr
     */
    public Group(String gr) {
    	this.group=gr;
        students=new ArrayList<Student>();
    }
        
	/**
	 * @param student the student to set
	 */
	public void addStudent(Student s) {
		this.students.add(s);
	}
	
	/**
	 * @return the student
	 */
	public List<Student> getStudents() {
		return students;
	}
	
	/**
	 * @param group the group to set
	 */
	public void setGroupName(String group) {
		this.group = group;
	}
	
	/**
	 * @return the group
	 */
	public String getGroupName() {
		return group;
	}
	
	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	
	/**
	 * @return the specialty
	 */
	public Specialty getSpecialty() {
		return specialty;
	}
    
	/**
	 * 
	 * @return numarul de studenti din grupa
	 */
	public int getStudentNr() {
        return this.students.size();
    }
	
	
	@Override
	public String toString() {
		return group+" - "+specialty;
	}

        public List<DbObject> toDbObjectList() throws SQLException{
            List<DbObject> l = new ArrayList<DbObject>();
            DbObject db1 = new DbObject("name", group);
            DbUtil dbu = new DbUtil();
            ResultSet rs = dbu.getDate("select spId from specializations" +
                    " where spName = '"+specialty.getName()+"'");
            if(rs.next()){
                Integer spid = rs.getInt(1);
                DbObject db2 = new DbObject("spId", spid.toString());
                l.add(db1);l.add(db2);
            }
            dbu.close();
            return l;
        }

        public List<DbObject> toDbObjectListStudents() throws SQLException{
        List<DbObject> l = new ArrayList<DbObject>();
        DbUtil dbu = new DbUtil();
        ResultSet rs = dbu.getDate("select groupId from groups" +
                " where name = '"+group+"'");
        if(rs.next()){
            Integer grid = rs.getInt(1);
            DbObject db1 = new DbObject("name", grid.toString());
            rs = dbu.getDate("select spId from specializations" +
                    " where spName = '"+specialty.getName()+"'");
            if(rs.next()){
                Integer spid = rs.getInt(1);
                DbObject db2 = new DbObject("spId", spid.toString());
                l.add(db1);l.add(db2);
            }
        }
        dbu.close();
        return l;
        }

}
