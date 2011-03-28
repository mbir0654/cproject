package business.model;

import java.util.ArrayList;

public class Examen {
	private String data;
	private String tip;
	private ArrayList<Nota> note;
	
	public Examen(Examen e){
		data=e.data;
		tip=e.tip;		
		note=e.note;
	}
	public Examen(String d, String t, Nota n){
		data=d;
		tip=t;
		note.add(n);
	}
	public Examen(String d, String t){
		data=d;
		tip=t;
		note=null;
	}
	public void setData(String d){
		data=d;
	}

	public void setTip(String t){
		tip=t;
	}
	public String getData(){
		return data;
	}
	public String getTip(){
		return tip;
	}
	public void addNota(Nota n){
		note.add(n);
	}
	public ArrayList<Nota> getNote(){
		return note;
	}
	
}
