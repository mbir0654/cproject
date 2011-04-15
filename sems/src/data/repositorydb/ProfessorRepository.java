package data.repositorydb;

import java.util.ArrayList;
import java.util.List;
import business.model.Professor;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class ProfessorRepository implements Repository<Professor> {
	
	private List<Professor> l;
	
	public ProfessorRepository(){
		l = new ArrayList<Professor>();
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Professor item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Professor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Professor find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Professor item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Professor item) {
		// TODO Auto-generated method stub
		
	}

}
