package business.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Tema {
	private String tema;
	private Calendar termen;
	private ArrayList<RezolvareTema> rezolvari;
	
	public Tema(){
		tema="";
		rezolvari = new ArrayList<RezolvareTema>();
	}
	public void addRezolvare(RezolvareTema r){
		rezolvari.add(r);
	}
	public void deleteRezolvare(RezolvareTema r){
		rezolvari.remove(r);
	}
}
