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
	
	private static final ProfessorRepository theTeachers =
		new ProfessorRepository();
	
	private ProfessorRepository(){
		l = new ArrayList<Professor>();
	}
	
	public static ProfessorRepository getInstance(){
		return theTeachers;
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Professor item) {
		l.add(item);
		
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Professor> getAll() {
		List<Professor> r = new ArrayList<Professor>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Professor findByName(String name) {
		for(Professor p : l){
			if(p.getUserName().equalsIgnoreCase(name))
				return p;
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
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Professor item) {
		l.remove(item);		
	}

}
