/**
 * 
 */
package data.repositorydb;

import java.util.ArrayList;
import java.util.List;

import business.model.Specialty;

import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class SpecialityRepository implements Repository<Specialty>{
	
	private List<Specialty> l;
	
	public SpecialityRepository(){
		l = new ArrayList<Specialty>();
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Specialty item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Specialty> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Specialty find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Specialty item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Specialty item) {
		// TODO Auto-generated method stub
		
	}
	
}