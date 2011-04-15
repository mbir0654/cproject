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
	 * @param d este...
	 * @param nC este...
	 */
	public Course(String d, int nC) {
		name = d;
		numberOfCredits = nC;
	}
	
	/**
	 * 
	 * @param d este ...
	 */
	public void setName(String d) {
		name = d;
	}
	
	/**
	 * 
	 * @param nc este numarul de credite
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
	 * @param e este ...
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
	 * @param e este ... care tb sters
	 */
	public void deleteExam(Exam e) {
		exams.remove(e);
	}
	
	/**
	 * 
	 * @param a este ... care trebuie sters
	 */
	public void deleteAnnouncement(Announcement a) {
		announcements.remove(a);
	}
	
	/**
	 * 
	 * @param t este ... care tb sters
	 */
	public void deleteAssignment(Assignment t) {
		assignments.remove(t);
	}

	/**
	 * @param syllabus este numele fisierului cu syllabusul
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
