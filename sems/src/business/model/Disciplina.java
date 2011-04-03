package business.model;

import java.util.ArrayList;

/*
 * 
 * facut de yo_biskis :))
 */
public class Disciplina {
	private ArrayList<Examen> examene;
	private ArrayList<Announcement> anunturi;
	private ArrayList<Assignment> teme;
	private String syllabus;
	private String denumire;
	private int nrCredite;
	
	public Disciplina(){
		examene = new ArrayList<Examen>();
		anunturi = new ArrayList<Announcement>();
		teme = new ArrayList<Assignment>();
		denumire = "";
		nrCredite = 0;
	}
	public Disciplina(String d, int nC){
		examene = new ArrayList<Examen>();
		anunturi = new ArrayList<Announcement>();
		teme = new ArrayList<Assignment>();
		denumire = d;
		nrCredite = nC;
	}
	public void setDenumire(String d){
		denumire = d;
	}
	public void setNrCredite(int nc){
		nrCredite = nc;
	}
	public String getDenumire(){
		return denumire;
	}
	public int getNrCredite(){
		return nrCredite;
	}
	public void addExamen(Examen e){
		examene.add(e);
	}
	public void addAnunt(Announcement a){
		anunturi.add(a);
	}
	public void addTema(Assignment t){
		teme.add(t);
	}
	public void deleteExamen(Examen e){
		examene.remove(e);
	}
	public void deleteAnunt(Announcement a){
		anunturi.remove(a);
	}
	public void deleteTema(Assignment t){
		teme.remove(t);
	}
	
}
