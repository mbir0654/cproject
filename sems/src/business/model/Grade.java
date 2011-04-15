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
	 * Constructor parametrizat
	 * 
	 * @param n este nota propriu-zisa
	 * 
	 * @param d este data la care s-a acordat nota respectiva
	 */
	public Grade(int n, Date d){
		grade = n;
		date = d;
	}
	
	/**
	 * Constructor parametrizat
	 * 
	 * data este setata la null
	 * 
	 * @param n este nota care se acorda
	 */
	public Grade(int n){
		grade = n;
		
	}
	
	/**
	 * 
	 * @param n va fi noua nota
	 */
	public void setGrade(int n){
		grade = n;
	}
	
	/**
	 * 
	 * @param d va fi noua data
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
