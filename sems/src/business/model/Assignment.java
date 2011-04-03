package business.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Assignment {
	private String name = "";
	private Calendar deadline;
	private ArrayList<RezolvareTema> rezolvari;
	
	public Assignment(){
		rezolvari = new ArrayList<RezolvareTema>();
	}
	public void addRezolvare(RezolvareTema r){
		rezolvari.add(r);
	}
	public void deleteRezolvare(RezolvareTema r){
		rezolvari.remove(r);
	}
}
