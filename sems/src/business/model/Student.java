package business.model;

/**
 * 
 * @author otniel
 *
 */

public class Student extends User {
	
	private String nrMat;
	/**
	 * Constructorul implicit
	 */
	public Student(){
		nrMat = "";
	}
	
	/**
	 * Constructor de copiere
	 * 
	 * @param s studentul pe care il duplicam
	 */
	public Student(Student s){
		super(s);
		nrMat = s.getNrMat();
	}
	
	/**
	 * vreifica daca 2 studenti sunt identici
	 * 
	 * @param s Studentul cu care comparam
	 * 
	 * @return true daca studentul curent este identic 
	 * 		   cu cel dat ca parametru
	 */
	public boolean equals(Student s){
		if(super.equals(s) && nrMat.equalsIgnoreCase(s.getNrMat()))
			return true;
		return false;
	}
	
	/**
	 * @param nrMat va fi numarul matricol al studentului
	 */
	public void setNrMat(String nrMat) {
		this.nrMat = nrMat;
	}
	
	/**
	 * @return numarul matricol al studentului
	 */
	public String getNrMat() {
		return nrMat;
	}
	
	

} 
