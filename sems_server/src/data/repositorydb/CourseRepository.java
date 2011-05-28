package data.repositorydb;

import java.util.ArrayList;
import java.util.List;
import business.model.Course;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class CourseRepository implements Repository<Course>{
	
	private List<Course> l;
	
	public CourseRepository(){
		l = new ArrayList<Course>();
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Course item) {
		l.add(item);
		
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Course> getAll() {
		List<Course> r = new ArrayList<Course>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#findByName(java.lang.String)
	 */
	@Override
	public Course findByName(String name) {
		for(Course c:l){
			if(c.getName().equalsIgnoreCase(name))
				return c;
		}
		return null;
	}

	/**
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Course item) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Course item) {
		l.remove(item);
	}

}
