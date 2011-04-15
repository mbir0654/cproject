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

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Course item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Course find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Course item) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Course item) {
		// TODO Auto-generated method stub
		
	}

}
