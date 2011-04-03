package business.model;

import java.util.ArrayList;

/*
 * 
 * Made by yo_biskis :))
 */
public class Course {
	private ArrayList<Exam> exams = new ArrayList<Exam>();
	private ArrayList<Announcement> announcements = new ArrayList<Announcement>();
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private String syllabus;
	private String name = "";
	private int numberOfCredits = 0;
	
	public Course(){
	}
	
	public Course(String d, int nC) {
		name = d;
		numberOfCredits = nC;
	}
	
	public void setName(String d) {
		name = d;
	}
	
	public void setNumberOfCredits(int nc) {
		numberOfCredits = nc;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberOfCredits() {
		return numberOfCredits;
	}
	
	public void addExam(Exam e) {
		exams.add(e);
	}
	
	public void addAnnouncement(Announcement a) {
		announcements.add(a);
	}
	
	public void addAssignment(Assignment t) {
		assignments.add(t);
	}
	
	public void deleteExam(Exam e) {
		exams.remove(e);
	}
	
	public void deleteAnnouncement(Announcement a) {
		announcements.remove(a);
	}
	
	public void deleteAssignment(Assignment t) {
		assignments.remove(t);
	}
	
}
