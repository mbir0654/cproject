/**
 * 
 */
package data.repositorydb;

import java.util.ArrayList;
import java.util.List;
import business.model.Faculty;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class FacultyRepository implements Repository<Faculty>{
	
	private List<Faculty> l;
	
	public FacultyRepository(){
		l = new ArrayList<Faculty>();
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Faculty item) {
		l.add(item);
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Faculty> getAll() {
		List<Faculty> r = new ArrayList<Faculty>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Faculty findByName(String name) {
		for(Faculty f:l){
			if(f.getName().equalsIgnoreCase(name))
				return f;
		}
		return null;
	}

	/**
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Faculty item) {
		l.remove(item);		
	}

}