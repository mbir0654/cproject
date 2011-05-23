
package business.model;

/**
 * 
 * @author otniel
 *
 */
public class Administrator extends User {
	
	/**
	 * Constructorul implicit 
	 */
	public Administrator(){
		//atributele ne-continute in User ar trebui inititalizate aici
	}
        public Administrator(Administrator adm) {
            super(adm);
        }
	
	/**
	 * 
	 * @param a este Administratorul cu care comparam
	 * 
	 * @return true daca administratorul curent este identic cu 
	 *  	   cel dat ca parametru
	 */
	public boolean equals(Administrator a){
		if(super.equals(a))
			return true;
		return false;
	}

} 
