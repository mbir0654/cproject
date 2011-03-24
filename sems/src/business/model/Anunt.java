package business.model;

public class Anunt {
	private String anunt;
	
	public Anunt(String a){
		anunt = a;
	}
	public Anunt(){
		anunt = "";
	}
	public void setAnunt(String a){
		anunt = a;
	}
	public String getAnunt(){
		return anunt;
	}
}
