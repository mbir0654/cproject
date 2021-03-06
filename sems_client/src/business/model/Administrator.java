
package business.model;

import java.io.Serializable;
import java.util.List;

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
		super();
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
	
	@Override
	public List<DbObject> toDbObjectList(){
            return super.toDbObjectList();
	}

} 
