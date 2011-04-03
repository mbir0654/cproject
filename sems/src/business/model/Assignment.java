package business.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Assignment {
	private String name = "";
	private Calendar deadline;
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
}
