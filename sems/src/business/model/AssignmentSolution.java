package business.model;

import java.util.Date;

public class AssignmentSolution {
	private String solution = "";
	private Date date = null;
	private Student author;
	
	/**
	 * Constructorul implicit
	 */
	public AssignmentSolution() {
		author = new Student();
	}	
	
	/**
	 * Constructorul parametrizat
	 * 
	 * @param r este textul rezolvarii
	 * 
	 * @param d este data la care a fost adaugata rezolvarea
	 * 
	 * @param s este Studentul care a adaugat rezolvarea
	 */
	public AssignmentSolution(String r, Date d, Student s) {
		solution = r;
		date = d;
		s = new Student(s);
	}
	
	/**
	 * verifica daca doua rezolvari sunt identice
	 * 
	 * @param as rezolvarea cu care comparam
	 * 
	 * @return true daca cele 2 rezolvari au acelasi text
	 */
	public boolean equals(AssignmentSolution as){
		if(solution.equalsIgnoreCase(as.getSolution()))
			return true;
		return false;
	}
	/**
	 * @param solution este rezolvarea temei
	 */
	public void setSolution(String solution) {
		this.solution = solution;
	}
	/**
	 * @return rezolvarea temei
	 */
	public String getSolution() {
		return solution;
	}
	/**
	 * @param date este data la care a fost predata rezolvarea
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return data la care a fost predata rezolvarea
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param author este autorul rezolvarii
	 */
	public void setAuthor(Student author) {
		this.author = author;
	}
	/**
	 * @return autorul rezolvarii
	 */
	public Student getAuthor() {
		return author;
	}
}
