package business.model;


public class Professor extends User{
	
	/**
	 * Constructorul implicit
	 */
	public Professor(){
		//atributele ne-continute in User ar trebui inititalizate aici
	}
	
	/**
	 * 
	 * @param p este Profesorul care se va duplica
	 */
	public Professor(Professor p){
		super(p);
	}
	
	/**
	 * verifica daca 2 profesori sunt identici
	 * 
	 * @param p este profesorul cu care comparam
	 * 
	 * @return true daca profesorul curent este identic
	 *         cu cel dat ca parametru
	 */
	public boolean equals(Professor p){
		if(super.equals(p))
			return true;
		return false;
	}
} 

