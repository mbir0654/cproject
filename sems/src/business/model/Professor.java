package business.model;

import java.util.List;


public class Professor extends User{
	private List<Group> groups;
	/**
	 * Constructorul implicit
	 * 
	 * @see User#User()
	 */
	public Professor(){
		//atributele ne-continute in User ar trebui inititalizate aici
	}
	
	/**
	 * Constructorul de copiere
	 * 
	 * @param p este Profesorul care se va duplica
	 * 
	 * @see User#User(User)
	 */
	public Professor(Professor p){
		super(p);
		// TODO restul atributelor se copiaza
	}
	
	/**
	 * verifica daca 2 profesori sunt identici
	 * 
	 * @param p este profesorul cu care comparam
	 * 
	 * @return true daca profesorul curent este identic
	 *         cu cel dat ca parametru
	 *         
	 * @see User#equals(User)
	 */
	public boolean equals(Professor p){
		if(super.equals(p))
			return true;
		return false;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	/**
	 * @return the groups
	 */
	public List<Group> getGroups() {
		return groups;
	}
} 

