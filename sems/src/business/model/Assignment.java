package business.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Assignment {
	private String name = "";
	private Date deadline;
	private ArrayList<AssignmentSolution> solutions;
	
	/**
	 * Constructorul implicit
	 */
	public Assignment() {
		solutions = new ArrayList<AssignmentSolution>();
	}
	
	/**
	 * Constructorul de copiere
	 * 
	 * @param a este tema care trebuie duplicata
	 */
	public Assignment(Assignment a){
		solutions = new ArrayList<AssignmentSolution>();
		solutions.addAll(a.getSolutions());
		name = a.getName();
		deadline = a.getDeadline();
	}
	
	/**
	 * 
	 * @param r este rezolvarea care se adauga
	 */
	public void addSolution(AssignmentSolution r) {
		solutions.add(r);
	}
	
	/**
	 * 
	 * @param r este rezolvarea care trebuie stearsa
	 */
	public void deleteSolution(AssignmentSolution r) {
		solutions.remove(r);
	}
	
	public List<AssignmentSolution> getSolutions(){
		return solutions;
	}

	/**
	 * @param deadline va fi data limita la care se poate preda tema
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return data limita la care se poate preda tema
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * @param name va fi denumirea temei
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return denumirea temei
	 */
	public String getName() {
		return name;
	}
}
