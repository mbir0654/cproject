package business.model;

import java.util.Date;

public class Grade {
	private int grade = 0;
	private Date date = null;
	
	public Grade(Grade n){
		grade = n.grade;
		date = n.date;
	}
	public Grade(int n, Date d){
		grade = n;
		date = d;
	}
	public Grade(int n){
		grade = n;
		date = null;
	}
	public void setGrade(int n){
		grade=n;
	}
	public void setDate(Date d){
		date = d;
	}
	public int getGrade(){
		return grade;
	}
	public Date getDate(){
		return date;
	}
}
