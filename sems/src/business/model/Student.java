package business.model;

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
	private Specialty spec;
	
	/**
	 * Constructorul implicit
	 */
	public Student(){
		nrMat = "";
	}
	
	/**
	 * Constructor de copiere
	 * 
	 * @param s studentul pe care il duplicam
	 */
	public Student(Student s){
		super(s);
		nrMat = s.getNrMat();
	}
	
	/**
	 * vreifica daca 2 studenti sunt identici
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
	 * @param nrMat va fi numarul matricol al studentului
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
	 * @param assignments the assignments to set
	 */
	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	/**
	 * @return the assignments
	 */
	public List<Assignment> getAssignments() {
		return assignments;
	}

	/**
	 * @param spec the spec to set
	 */
	public void setSpec(Specialty spec) {
		this.spec = spec;
	}

	/**
	 * @return the spec
	 */
	public Specialty getSpec() {
		return spec;
	}

} 
