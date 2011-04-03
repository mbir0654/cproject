package business.model;

import java.util.ArrayList;
import java.util.Date;

public class Exam {
	private Date date;
	private String type;
	private ArrayList<Grade> grades;
	
	public Exam(Exam e) {
		date = e.date;
		type = e.type;		
		grades = e.grades;
	}
	public Exam(Date d, String t, Grade n) {
		date = d;
		type = t;
		grades.add(n);
	}
	public Exam(Date d, String t) {
		date = d;
		type = t;
		grades = null;
	}
	
	public void setData(Date d) {
		date = d;
	}

	public void setTip(String t) {
		type = t;
	}
	
	public Date getData() {
		return date;
	}
	
	public String getType() {
		return type;
	}
	
	public void addGrade(Grade n) {
		grades.add(n);
	}
	
	public ArrayList<Grade> getGrade() {
		return grades;
	}
	
}
