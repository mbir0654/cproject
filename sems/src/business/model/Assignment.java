package business.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Assignment {
	private String name = "";
	private Calendar deadline;
	private ArrayList<AssignmentSolution> rezolvari;
	
	public Assignment(){
		rezolvari = new ArrayList<AssignmentSolution>();
	}
	public void addRezolvare(AssignmentSolution r){
		rezolvari.add(r);
	}
	public void deleteRezolvare(AssignmentSolution r){
		rezolvari.remove(r);
	}
}
