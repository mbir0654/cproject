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
	private List<Student> student;
	private String group;
	private Specialty specialty;

        public Group() {
            group="";
            student = new ArrayList<Student>();
        }
        public Group(String gr) {
            this.group=gr;
            student=new ArrayList<Student>();
        }
	/**
	 * @param student the student to set
	 */
	public void addStudent(Student s) {
		this.student.add(s);
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
        public int getStudentNr() {
            return this.student.size();
        }

}
