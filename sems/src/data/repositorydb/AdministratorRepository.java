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

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Administrator item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Administrator> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Administrator find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Administrator item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Administrator item) {
		// TODO Auto-generated method stub
		
	}

}
