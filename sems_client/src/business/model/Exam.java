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
	 * @param d este data la care se da examenul
	 * @param t este tipul examenului
	 * @param c este cursul la care se da examenul
	 */
	public Exam(Date d, String t, Course c) {
		grades = new ArrayList<Grade>();
		date = d;
		type = t;
		course = c;
	}
	
	/**
	 * 
	 * @param d este data examenului
	 */
	public void setData(Date d) {
		date = d;
	}
	
	/**
	 * 
	 * @param t este tipul examenului 
	 */
	public void setTip(String t) {
		type = t;
	}
	
	/**
	 * 
	 * @return data la care se da examenul
	 */
	public Date getData() {
		return date;
	}
	
	/**
	 * 
	 * @return ripul examenului
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 
	 * @param n este nota care se adauga la acest examen
	 */
	public void addGrade(Grade n) {
		grades.add(n);
	}
	
	/**
	 * 
	 * @return o lista cu rezultatele acestui examen
	 */
	public ArrayList<Grade> getGrades() {
		return grades;
	}

	/**
	 * @param seteaza cursul pt care se da examen
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return cursul la care se da examen
	 */
	public Course getCourse() {
		return course;
	}
	
	/**
	 * @return un string continand cursul si data
	 */
	@Override
	public String toString() {
		return course+" "+type+" "+date;
	}
}
