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
	private String name = "";
	private int numberOfCredits = 0;
	private ArrayList<MaterialCurs> materialeDeCurs;
	private List<Professor> profesori;
	private Specialty specializare;
	private String cod = "";
	private String tip = ""; 
	private int semestrul = 0;
	
	/**
	 * Constructorul implicit
	 */
	public Course(){
		exams = new ArrayList<Exam>();
		announcements = new ArrayList<Announcement>();
		assignments = new ArrayList<Assignment>();
		materialeDeCurs = new ArrayList<MaterialCurs>();
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
        cod = c.cod;
        specializare = c.specializare;
        tip = c.tip;
        semestrul = c.semestrul;
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
	 * 
	 * @return codul de identificare a cursului
	 */
	public String getCod() {
		return cod;
	}
	
	/**
	 * 
	 * @param cod ul de identificare
	 * compus din abrevierea cursului si a
	 * specializarii 
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	/**
	 * 
	 * @return tipul cursului
	 */
	public String getTip() {
		return tip;
	}
	
	/**
	 * 
	 * @param tip este tipul cursului:
	 * obligatoriu, facultativ, optional
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	/**
	 * 
	 * @return specializarea asociata cursului
	 */
	public Specialty getSpecializare() {
		return specializare;
	}
	
	/**
	 * 
	 * @param specializare este specializarea asociata cursului
	 */
	public void setSpecializare(Specialty specializare) {
		this.specializare = specializare;
	}
	
	/**
	 * 
	 * @return lista de profesori care predau la acest curs
	 */
	public List<Professor> getProfesori() {
		return profesori;
	}
	
	/**
	 * 
	 * @return semestrul in care se preda cursul.
	 */
	public int getSemestrul() {
		return semestrul;
	}
	
	/**
	 * 
	 * @param semestrul va fi semestrul in care se preda cursul
	 */
	public void setSemestrul(int semestrul) {
		this.semestrul = semestrul;
	}
	
	/**
	 * creaza un String din nume si numar de credite
	 */
    public String toString() {
        return this.name+" "+this.numberOfCredits;
    }
}
