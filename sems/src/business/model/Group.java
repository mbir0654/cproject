/**
 * 
 */
package business.model;

import java.util.List;

/**
 * @author CLJ
 *
 */
public class Group {
	private List<Student> student;
	private String group;
	private Specialty specialty;
	
	/**
	 * @param student the student to set
	 */
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	/**
	 * @return the student
	 */
	public List<Student> getStudent() {
		return student;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	/**
	 * @return the group
	 */
	public String getGroup() {
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

}
