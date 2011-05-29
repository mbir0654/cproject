/**
 * 
 */
package data.repositorydb;

import java.util.ArrayList;
import java.util.List;

import business.model.Faculty;
import business.model.Specialty;

import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class SpecialityRepository implements Repository<Specialty>{
	
    private List<Specialty> l;
    private FacultyRepository facultys = FacultyRepository.getInstance();

    private static final SpecialityRepository specialitys = new SpecialityRepository();

    public static SpecialityRepository getInstance(){
        return  specialitys;
    }
	private SpecialityRepository(){
		l = new ArrayList<Specialty>();
        for(Faculty faculty:facultys.getAll()){
            for(Specialty specialty:faculty.getSpecialties()){
                l.add(specialty);
            }
        }
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Specialty item) {
		l.add(item);
		
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Specialty> getAll() {
		List<Specialty> r = new ArrayList<Specialty>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#findNyName(java.lang.String)
	 */
	@Override
	public Specialty findByName(String id) {
		for(Specialty s : l){
			if(s.getName().equalsIgnoreCase(id))
				return s;
		}
		return null;
	}

	/**
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Specialty item) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Specialty item) {
		l.remove(item);		
	}
	
}