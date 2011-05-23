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
	private ArrayList<String> materialeDeCurs;
	
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
        public Course(Course c) {
            exams=c.exams;
            announcements=c.announcements;
            assignments=c.assignments;
            syllabus=c.syllabus;
            name=c.name;
            numberOfCredits=c.numberOfCredits;
        }
	
	/**
	 * Constructorul parametrizat
	 * 
	 * @param n este...
	 * @param nC este...
	 */
	public Course(String n, int nC) {
		name = n;
                exams = new ArrayList<Exam>();
		announcements = new ArrayList<Announcement>();
                assignments = new ArrayList<Assignment>();
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

        public ArrayList<Announcement> getAnnouncements() {
            return announcements;
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

    public ArrayList<Exam> getExams() {
        return exams;
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

        public ArrayList<Assignment> getAssignments() {
            return this.assignments;
        }

    @Override
    public String toString() {
        return this.name+" "+this.numberOfCredits;
    }
	/**
	 * @param materialeDeCurs the materialeDeCurs to set
	 */
	public void setMaterialeDeCurs(ArrayList<String> materialeDeCurs) {
		this.materialeDeCurs = materialeDeCurs;
	}
	/**
	 * @return the materialeDeCurs
	 */
	public ArrayList<String> getMaterialeDeCurs() {
		return materialeDeCurs;
	}
	
	/**
	 * Adauga materiale de curs.
	 * @param mat
	 */
	public void addMaterialeDeCurs(String mat){
		this.materialeDeCurs.add(mat);
	}
}
