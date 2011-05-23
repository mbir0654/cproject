package business.model;

import java.util.ArrayList;
import java.util.Date;

public class Exam {
	private Date date;
	private String type;
	private ArrayList<Grade> grades;
	private Course course;
	
	/**
	 * 
	 * @param e este <b>Exam</b>enul care se copiaza
	 */
	public Exam(Exam e) {
		date = e.date;
		type = e.type;		
		grades = e.grades;
	}
	
	/**
	 * Constructorul parametrizat
	 * 
	 * @param d este ...
	 * @param t este ...
	 * @param n este ...
	 */
	public Exam(Date d, String t, Grade n) {
		date = d;
		type = t;
		grades.add(n);
	}
	
	/**
	 * 
	 * @param d este ...
	 * @param t este ...
	 */
	public Exam(Date d, String t) {
		date = d;
		type = t;
		grades = null;
	}
	
	/**
	 * 
	 * @param d este ...
	 */
	public void setData(Date d) {
		date = d;
	}
	
	/**
	 * 
	 * @param t este ...  
	 */
	public void setTip(String t) {
		type = t;
	}
	
	/**
	 * 
	 * @return ...
	 */
	public Date getData() {
		return date;
	}
	
	/**
	 * 
	 * @return ...
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 
	 * @param n este ...
	 */
	public void addGrade(Grade n) {
		grades.add(n);
	}
	
	/**
	 * 
	 * @return ...
	 */
	public ArrayList<Grade> getGrade() {
		return grades;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

    public ArrayList<Grade> getGrades() {
        return grades;
    }
        
	
}
