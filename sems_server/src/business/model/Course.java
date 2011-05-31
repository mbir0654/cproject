package business.model;

import data.dbutil.DbObject;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import data.dbutil.*;

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
    	List<DbObject> l = new ArrayList<DbObject>();
    	DbObject db1 = new DbObject("courseName", name);
    	l.add(db1);
    	return l;
    }
    
    
    public List<DbObject> toDbObjectListCS() throws SQLException {
    	List<DbObject> l = new ArrayList<DbObject>();
    	Integer spid = 0;
    	ResultSet rs;
        DbUtil dbu = new DbUtil();
    	DbObject db1 = new DbObject("courseCode", cod);
    	DbObject db2 = new DbObject("courseType", tip);
    	DbObject db3 = new DbObject("courseCredits", 
    			numberOfCredits.toString());
    	DbObject db4 = new DbObject("semester", semestrul.toString());
        rs = dbu.getDate("select spId from specializations" +
    			" where spName='"+specializare.getName()+"' limit 1");
    	if(rs.next()){
            spid = rs.getInt(1);
            DbObject db5 = new DbObject("spId", spid.toString());
            rs = dbu.getDate("select courseId from courses where courseName='"+
                    name+"'");
            if(rs.next()){
                Integer cid = rs.getInt(1);
                DbObject db6 = new DbObject("courseId", cid.toString());
                l.add(db1); l.add(db2); l.add(db3);
                l.add(db4); l.add(db5); l.add(db6);
            }
        }
        System.out.println(l);
    	return l;
    }
    
    public List<DbObject> toDbObjectListTC(Professor p) throws SQLException{
        List<DbObject> l = new ArrayList<DbObject>();
        Integer tcid = 0,csid = 0;
        ResultSet rs;
        DbUtil dbu = new DbUtil();
        rs = dbu.getDate("select teacherId from teachers where userName = '"
                +p.getUserName()+"' limit 1");
        if(rs.next()){
            tcid = rs.getInt(1);
            DbObject db1 = new DbObject("teacherId", tcid.toString());
            rs = dbu.getDate("select csId from specializations_" +
                        "courses where courseCode = '"+cod+"' limit 1");
            if(rs.next()){
                csid = rs.getInt(1);
                DbObject db2 = new DbObject("csId", csid.toString());
                l.add(db1); l.add(db2);
            }
        }
        dbu.close();
    	return l;
    }
}
