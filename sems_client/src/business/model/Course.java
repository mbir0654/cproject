package business.model;

import java.util.*;

	/**
	 * 
	 * @author byskis
	 *
	 */
public class Course {
	private ArrayList<Exam> exams;
	private ArrayList<Announcement> announcements;
	private ArrayList<Assignment> assignments;
	private String name;
	private int numberOfCredits;
	private ArrayList<MaterialCurs> materialeDeCurs;
	private List<Professor> profesori;
	private Specialty specializare;
	
	/**
	 * Constructorul implicit
	 */
	public Course(){
		exams = new ArrayList<Exam>();
		announcements = new ArrayList<Announcement>();
		assignments = new ArrayList<Assignment>();
		materialeDeCurs = new ArrayList<MaterialCurs>();
		name = "";
		numberOfCredits = 0;
		profesori = new ArrayList<Professor>();
		specializare = new Specialty();
	}
	/**
	 * Constructorul de copiere
	 * 
	 * @param c este cursul de duplicat
	 */
    public Course(Course c) {
        exams=c.exams;
        announcements=c.announcements;
        assignments=c.assignments;
        materialeDeCurs = c.materialeDeCurs;
        name=c.name;
        numberOfCredits=c.numberOfCredits;
    }
	
	/**
	 * Constructorul parametrizat
	 * 
	 * @param n este numele cursului
	 * @param nC este numarul de credite
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
		   c.specializare.equals(c.specializare))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param n va fi noua denumire a cursului
	 */
	public void setName(String n) {
		name = n;
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
	 * @return denumirea cursului
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
	 * @param e va fi examenul de adaugat
	 */
	public void addExam(Exam e) {
		exams.add(e);
	}
	
	/**
	 * 
	 * @param a este anuntul de adaugat
	 */
	public void addAnnouncement(Announcement a) {
		announcements.add(a);
	}

        public ArrayList<Announcement> getAnnouncements() {
            return announcements;
        }

	
	/**
	 * 
	 * @param t este tema de adaugat 
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
     * 
     * @return lista de examene aferenta cursului
     */
	public ArrayList<Exam> getExams() {
        return exams;
    }

    /**
     *     
     *  @return lista de teme asociata cursului
     */
    public ArrayList<Assignment> getAssignments() {
        return this.assignments;
    }
    
	/**
	 * @param materialeDeCurs este noua lista cu materiale de curs
	 */
	public void setMaterialeDeCurs(ArrayList<MaterialCurs> materialeDeCurs) {
		this.materialeDeCurs = materialeDeCurs;
	}
	
	/**
	 * Adauga materiale de curs.
	 * 
	 * @param mc este materialul de adaugat in lista
	 */
	public void addMaterialCurs(MaterialCurs mc){
		materialeDeCurs.add(mc);
	}
	
	/**
	 * @return lista cu materialele aferente cursului
	 */
	public ArrayList<MaterialCurs> getMaterialeDeCurs() {
		return materialeDeCurs;
	}
	
	/**
	 * 
	 * @param p este profesorul adaugat
	 */
	public void addProfessor(Professor p){
		profesori.add(p);
	}
	
	/**
	 * 
	 * @return lista de profesori care predau la acest curs
	 */
	public List<Professor> getProfesors(){
		return profesori;
	}
	
	/**
	 * creaza un String din nume si numar de credite
	 */
    public String toString() {
        return this.name+" "+this.numberOfCredits;
    }
}
