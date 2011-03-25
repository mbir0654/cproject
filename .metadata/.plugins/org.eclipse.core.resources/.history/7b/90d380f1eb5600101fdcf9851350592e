package business.model;

import java.util.ArrayList;

/*
 * 
 * facut de yo_biskis :))
 */
public class Disciplina {
	private ArrayList<Examen> examene;
	private ArrayList<Anunt> anunturi;
	private ArrayList<Tema> teme;
	private String denumire;
	private int nrCredite;
	
	public Disciplina(){
		examene = new ArrayList<Examen>();
		anunturi = new ArrayList<Anunt>();
		teme = new ArrayList<Tema>();
		denumire = "";
		nrCredite = 0;
	}
	public Disciplina(String d, int nC){
		examene = new ArrayList<Examen>();
		anunturi = new ArrayList<Anunt>();
		teme = new ArrayList<Tema>();
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
	public void addAnunt(Anunt a){
		anunturi.add(a);
	}
	public void addTema(Tema t){
		teme.add(t);
	}
	public void deleteExamen(Examen e){
		examene.remove(e);
	}
	public void deleteAnunt(Anunt a){
		anunturi.remove(a);
	}
	public void deleteTema(Tema t){
		teme.remove(t);
	}
	
}
