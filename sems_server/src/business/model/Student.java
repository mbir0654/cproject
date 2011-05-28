package business.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author otniel
 *
 */

public class Student extends User {
	
	private String cnp; 
	private String nrMat;
	private Contract contract;
	private List<AssignmentSolution> solutions;
	//private List<Assignment> assignments;
	private Specialty specialty;
	private Group group;
	private int year = 1;
	
	/**
	 * Constructorul implicit
	 */
	public Student(){
		nrMat = "";
		contract = new Contract();
		solutions = new ArrayList<AssignmentSolution>();
		//assignments = new ArrayList<Assignment>();
		specialty = new Specialty();
	}
	
	/**
	 * Constructor de copiere
	 * 
	 * @param s este studentul pe care il duplicam
	 */
	public Student(Student s){
		super(s);
		nrMat = s.nrMat;
		contract = s.contract;
		solutions = s.solutions;
		//assignments = s.getAssignments();
		specialty = s.specialty;
		year = s.year;
	}
	
	/**
	 * verifica daca 2 studenti sunt identici
	 * 
	 * @param s Studentul cu care comparam
	 * 
	 * @return true daca studentul curent este identic 
	 * 		   cu cel dat ca parametru
	 */
	public boolean equals(Student s){
		if(super.equals(s) && nrMat.equalsIgnoreCase(s.getNrMat()))
			return true;
		return false;
	}
	
	/**
	 * seteaza Numarul matricol al Studentului
	 * @param nrMat va fi noul numar matricol al studentului
	 */
	public void setNrMat(String nrMat) {
		this.nrMat = nrMat;
	}
	
	/**
	 * @return numarul matricol al studentului
	 */
	public String getNrMat() {
		return nrMat;
	}

	/**
	 * @param contract va fi contractul studentului
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}

	/**
	 * @return contractul studentului
	 */
	public Contract getContract() {
		return contract;
	}

	/**
	 * @param solution este rezolvarea adaugata
	 */
	public void addSolution(AssignmentSolution solution) {
		this.solutions.add(solution);
	}

	/**
	 * @return lista cu solutiile studentului
	 */
	public List<AssignmentSolution> getSolutions() {
		return solutions;
	}

	/**
	 * @param specialty va fi noua specialitate a studentului
	 */
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	/**
	 * @return specialitatea studentului
	 */
	public Specialty getSpecialty() {
		return specialty;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}
	
	/**
	 * 
	 * @return anul in care este inmatriculat studentul
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 *
	 * @param year este anul in care va fi inmatriculat studentul
	 */
  public void  setYear(int year){
      this.year = year;
  }
	
	/**
	 * 
	 * @return cnp-ul studentului
	 */
	public String getCnp() {
		return cnp;
	}
	
	/**
	 * 
	 * @param cnp actualizaeaza cnp-ul studentului
	 */
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	
	
	/**
	 * 
	 * @param e este examenul la care se acorda nota
	 * 
	 * @param g este nota acordata
	 */
	public void addGrade(Exam e, Grade g){
		g.setStud(this);
		for(Course c : contract.getCourses()){
			if(c.getExams().contains(e)){
				e.addGrade(g);
			}
		}
	}
	
	/**
	 * genereaza un string cu numele si specializarea studentului
	 */
	@Override
	public String toString() {
		return getFirstName()+" "+getLastName()+" - "+ specialty.toString();
	}

	public ArrayList<DbObject> toDbObjectStud(){
      DbObject db1 = new DbObject("personalCode",cnp);
      DbObject db2 = new DbObject("userName",userName);
      ArrayList<DbObject> list = new ArrayList<DbObject>();
      list.add(db1); list.add(db2);
      return list;

	}

} 
