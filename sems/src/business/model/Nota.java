package business.model;

public class Nota {
	private int nota;
	private String data;
	
	public Nota(Nota n){
		nota=n.nota;
		data=n.data;
	}
	public Nota(int n, String d){
		nota=n;
		data=d;
	}
	public Nota(int n){
		nota=n;
		data="0000-00-00";
	}
	public void setNota(int n){
		nota=n;
	}
	public void setData(String d){
		data=d;
	}
	public int getNota(){
		return nota;
	}
	public String getData(){
		return data;
	}
}
