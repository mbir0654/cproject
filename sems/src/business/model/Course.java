package business.model;

import java.util.ArrayList;

	/**
	 * 
	 * @author byskis
	 *
	 */
public class Course {
	private ArrayList<Exam> exams;
	private ArrayList<Announcement> announcements;
	private ArrayList<Assignment> assignments;
	private String syllabus;
	private String name;
	private int numberOfCredits;
	
	/**
	 * Constructorul implicit
	 */
	public Course(){
		exams = new ArrayList<Exam>();
		announcements = new ArrayList<Announcement>();
		assignments = new ArrayList<Assignment>();
		syllabus = "";
		name = "";
		numberOfCredits = 0;
	}
	
	/**
	 * Constructorul parametrizat
	 * 
	 * @param n este...
	 * @param nC este...
	 */
	public Course(String n, int nC) {
		name = n;
		numberOfCredits = nC;
	}
	
	/**
	 * verifica daca 2 cursuri sunt identice
	 * 
	 * @param c este cursul cu care comparam
	 * 
	 * @return true daca cele 2 cursuri sunt identice
	 */
	public boolean equals(Course c){
		if(name.equalsIgnoreCase(c.getName()) &&
		   numberOfCredits == c.getNumberOfCredits() &&
		   syllabus.equalsIgnoreCase(c.getSyllabus()))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param d va fi ...
	 */
	public void setName(String d) {
		name = d;
	}
	
	/**
	 * 
	 * @param nc va fi numarul de credite
	 */
	public void setNumberOfCredits(int nc) {
		numberOfCredits = nc;
	}
	
	/**
	 * 
	 * @return ...
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return numarul de credite
	 */
	public int getNumberOfCredits() {
		return numberOfCredits;
	}
	
	/**
	 * 
	 * @param e va fi ...
	 */
	public void addExam(Exam e) {
		exams.add(e);
	}
	
	/**
	 * 
	 * @param a este ...
	 */
	public void addAnnouncement(Announcement a) {
		announcements.add(a);
	}
	
	/**
	 * 
	 * @param t este ... 
	 */
	public void addAssignment(Assignment t) {
		assignments.add(t);
	}
	
	/**
	 * 
	 * @param e este examenul care trebuie sters
	 */
	public void deleteExam(Exam e) {
		exams.remove(e);
	}
	
	/**
	 * 
	 * @param a este anuntul care trebuie sters
	 */
	public void deleteAnnouncement(Announcement a) {
		announcements.remove(a);
	}
	
	/**
	 * 
	 * @param t este tema care trebuie stearsa
	 */
	public void deleteAssignment(Assignment t) {
		assignments.remove(t);
	}

	/**
	 * @param syllabus va fi numele fisierului cu syllabusul
	 */
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}

	/**
	 * @return numele fisierului cu syllabusul
	 */
	public String getSyllabus() {
		return syllabus;
	}
	
}
