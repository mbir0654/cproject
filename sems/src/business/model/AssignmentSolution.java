package business.model;

import java.util.Date;

public class AssignmentSolution {
	private String solution = "";
	private Date date = null;
	private Student author;
	
	public AssignmentSolution() {
		// TODO: implement
	}	
	public AssignmentSolution(String r, Date d) {
		// TODO: implement
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
