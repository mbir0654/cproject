package business.model;

import java.util.ArrayList;

public class Facultate {
	private String universitate;
	private String nume;
	private String adresa;
	private ArrayList<Specializare> specializari;
	
	public Facultate(){
		universitate = "";
		nume = "";
		adresa = "";
		specializari = new ArrayList<Specializare>();
	}
}