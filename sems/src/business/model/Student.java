package business.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author otniel
 *
 */

public class Student extends User {
	
	private String nrMat;
	private Contract contract;
	private List<AssignmentSolution> solutions;
	private List<Assignment> assignments;
	private Specialty specialty;
	
	/**
	 * Constructorul implicit
	 */
	public Student(){
		nrMat = "";
		contract = new Contract();
		solutions = new ArrayList<AssignmentSolution>();
		assignments = new ArrayList<Assignment>();
		specialty = new Specialty();
	}
	
	/**
	 * Constructor de copiere
	 * 
	 * @param s este studentul pe care il duplicam
	 */
	public Student(Student s){
		super(s);
		nrMat = s.getNrMat();
		contract = s.getContract();
		solutions = s.getSolutions();
		assignments = s.getAssignments();
		specialty = s.getSpecialty();
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
	 * @param solutions the solutions to set
	 */
	public void setSolutions(List<AssignmentSolution> solutions) {
		this.solutions = solutions;
	}

	/**
	 * @return the solutions
	 */
	public List<AssignmentSolution> getSolutions() {
		return solutions;
	}

	/**
	 * @param assignment este noua tema atribuita studentului
	 */
	public void addAssignment(Assignment assignment) {
		this.assignments.add(assignment);
	}

	/**
	 * @return lista cu teme pentru studentul curent
	 */
	public List<Assignment> getAssignments() {
		return assignments;
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

} 
