package business.model;

import java.util.Date;

public class Grade {
	private int grade = 0;
	private Date date = null;
	
	/**
	 * Constructor de copiere
	 * 
	 * @param n este nota de copiat
	 */
	public Grade(Grade n){
		grade = n.grade;
		date = n.date;
	}
	
	/**
	 * 
	 * @param n este nota propriu-zisa
	 * @param d este data la care s-a acordat nota respectiva
	 */
	public Grade(int n, Date d){
		grade = n;
		date = d;
	}
	
	/**
	 * 
	 * @param n este nota care se acorda
	 */
	public Grade(int n){
		grade = n;
		/*
		 * date este deja initializata la null by default
		 */
	}
	
	/**
	 * 
	 * @param n este nota care trebuie modificata
	 */
	public void setGrade(int n){
		grade = n;
	}
	
	/**
	 * 
	 * @param d este data care trebuie modificata
	 */
	public void setDate(Date d){
		date = d;
	}
	
	/**
	 * 
	 * @return valoarea notei
	 */
	public int getGrade(){
		return grade;
	}
	
	/**
	 * 
	 * @return data la care a fost acordata nota
	 */
	public Date getDate(){
		return date;
	}
}
