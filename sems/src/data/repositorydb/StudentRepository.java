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
	
	private static StudentRepository sr;
	
	private StudentRepository (){
		l = new ArrayList<Student>();
	}
	
	public static StudentRepository getInstance(){
		return sr;
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Student item) {
		l.add(item);		
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Student> getAll() {
		List<Student> r = new ArrayList<Student>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Student findByName(String id) {
		for(Student s : l){
			if(s.getUserName().equalsIgnoreCase(id))
				return s;
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
	public void delete(Student item) {
		l.remove(item);
	}

}
