package business.model;

import java.util.ArrayList;
import java.util.Date;

public class Assignment {
	private String name = "";
	private Date deadline;
	private ArrayList<AssignmentSolution> solutions;
	
	public Assignment() {
		solutions = new ArrayList<AssignmentSolution>();
	}
	
	public void addSolution(AssignmentSolution r) {
		solutions.add(r);
	}
	
	public void deleteSolution(AssignmentSolution r) {
		solutions.remove(r);
	}

	/**
	 * @param deadline este c
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
	 * @param name este denumirea temei
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
