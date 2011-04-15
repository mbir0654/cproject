package business.model;

import java.util.ArrayList;
import java.util.Date;

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
