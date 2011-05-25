/**
 * 
 */
package business.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CLJ
 *
 */
public class Group {
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
		return group+" "+specialty;
	}

}
