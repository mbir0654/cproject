package data.repositorydb;

import java.util.ArrayList;
import java.util.List;
import business.model.Administrator;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class AdministratorRepository implements Repository<Administrator>{
	
	private List<Administrator> l;
	
	public AdministratorRepository(){
		l = new ArrayList<Administrator>();
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Administrator item) {
		l.add(item);
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Administrator> getAll() {
		List<Administrator> r = new ArrayList<Administrator>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Administrator findByName(String name) {
		for (Administrator a : l){
			if(a.getUserName().equalsIgnoreCase(name));
			return a;
		}
		return null;
	}

	/**
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update() {
		/* TODO 
		 */
		
	}

	/**
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	
	
	@Override
	public void delete(Administrator item) {
		l.remove(item);		
	}
		
}
