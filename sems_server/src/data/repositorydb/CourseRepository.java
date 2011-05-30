package data.repositorydb;

import java.util.ArrayList;
import java.util.List;
import business.model.Course;
import business.model.Faculty;
import business.model.Professor;
import business.model.Specialty;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class CourseRepository implements Repository<Course>{

    private List<Course> l;
    private SpecialityRepository specialitys = SpecialityRepository.getInstance();
    private static ProfessorRepository pr = ProfessorRepository.getInstance();

    private static final CourseRepository courses = new CourseRepository();

    public static  CourseRepository getInstance(){
        return  courses;
    }
	private CourseRepository(){
            l = new ArrayList<Course>();
            for(Specialty specialty:specialitys.getAll()){
                l.addAll(specialty.getCourses());
                for(Professor p : pr.getAll())
                    for(Course pCourse : p.getCourses()){
                        for(Course sCourse : specialty.getCourses())
                            if(pCourse.getCod().equals(sCourse.getCod())){
                                pCourse.setName(sCourse.getName());
                                pCourse.setMaterialeDeCurs(sCourse.getMaterialeDeCurs());
                                pCourse.setNumberOfCredits(sCourse.getNumberOfCredits());
                                pCourse.setSemestrul(sCourse.getSemestrul());
                                pCourse.setSpecializare(sCourse.getSpecializare());
                                pCourse.setAnnouncements(sCourse.getAnnouncements());
                                pCourse.setAssignments(sCourse.getAssignments());
                                pCourse.setExams(sCourse.getExams());
                            }
                    }
            }
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
