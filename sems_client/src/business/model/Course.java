package business.model;

import java.io.Serializable;
import java.sql.*;
import java.util.*;

	/**
	 * 
	 * @author byskis
	 *
	 */
public class Course implements Serializable {

	private ArrayList<Exam> exams = new ArrayList<Exam>();
	private ArrayList<Announcement> announcements = new ArrayList<Announcement>();
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private ArrayList<CourseMaterial> materialeDeCurs = new ArrayList<CourseMaterial>();
	private List<Professor> profesori = new ArrayList<Professor>();
	private String name = "";
	private Integer numberOfCredits = 0;
	private Specialty specializare;
	private Integer semestrul = 0;
	private String cod = "";
	/**
	 * tipul cursului, care poate fi <B>OBLIGATORIU</B>,<B>FACULTATIV</B> sau
	 * <B>OPTIONAL</B>
	 */
	private String tip = "";

	/**
	 * Constructorul implicit
	 */
	public Course(){
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
	public Course(String n, int nC, Specialty s) {
            name = n;
            exams = new ArrayList<Exam>();
            announcements = new ArrayList<Announcement>();
            assignments = new ArrayList<Assignment>();
            numberOfCredits = nC;
            specializare = s;
	}



	/**
	 * verifica daca 2 cursuri sunt identice
	 *
	 * @param c este cursul cu care comparam
	 *
	 * @return true daca cele 2 cursuri sunt identice
	 */
	public boolean equals(Course c){
		if(cod.equalsIgnoreCase(c.cod))
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

    public void setAnnouncements(ArrayList<Announcement> announcements) {
        this.announcements = announcements;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public void setExams(ArrayList<Exam> exams) {
        this.exams = exams;
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
	public void setMaterialeDeCurs(ArrayList<CourseMaterial> materialeDeCurs) {
		this.materialeDeCurs = materialeDeCurs;
	}

	/**
	 * Adauga materiale de curs.
	 *
	 * @param mc este materialul de adaugat in lista
	 */
	public void addMaterialCurs(CourseMaterial mc){
		materialeDeCurs.add(mc);
	}

	/**
	 * @return lista cu materialele aferente cursului
	 */
	public ArrayList<CourseMaterial> getMaterialeDeCurs() {
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
	public List<Professor> getProfessors(){
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
        public void setCod(String cod){
            this.cod = cod;
        }

        /**
         * genereaza un cod pentru curs
         */
	public void generateCod() {
		cod = name.substring(0, 3).toUpperCase()+"-"
                        +specializare.getName().substring(0, 4).toUpperCase() +
                        "-" + new Random(name.length()).nextInt(20);
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
		this.tip = tip.toUpperCase();
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
	 * creaza un String din nume specializare si numar de credite
	 */
    @Override
    public String toString() {
        return name+" "+numberOfCredits+" "+exams;
    }

    public List<DbObject> toDbObjectList(){
    	return null;
    }


    public List<DbObject> toDbObjectListCS() {
    	return null;
    }

    public List<DbObject> toDbObjectListTC(Professor p) {
    	return null;
    }

    public List<DbObject> toDbObjectListExams(Exam e) {
        return null;
    }

     public List<DbObject> toDbObjectListAssignments(Assignment a) {
        return null;
    }
      public List<DbObject> toDbObjectListAnnouncements(Announcement a) {
        return null;
    }
       public List<DbObject> toDbObjectListMaterials(CourseMaterial cm) {
        return null;
    }
}
