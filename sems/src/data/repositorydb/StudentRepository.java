/**
 * 
 */
package data.repositorydb;

import java.util.ArrayList;
import java.util.List;
import business.model.Student;
import data.repositoryinterface.*;

/**
 * @author otniel
 *
 */
public class StudentRepository implements Repository<Student>{
	
	private List<Student> l;
	
	public StudentRepository (){
		l = new ArrayList<Student>();
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Student item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Student find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Student item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Student item) {
		// TODO Auto-generated method stub
		
	}

}
