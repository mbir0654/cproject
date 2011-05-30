
package business.model;

import java.util.List;

import data.dbutil.DbObject;
import java.util.ArrayList;

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
            List<DbObject> l = new ArrayList<DbObject>();
            l.addAll(super.toDbObjectList());
            DbObject db1 = new DbObject("role", "admin");
            l.add(db1);
            return l;
	}

} 
