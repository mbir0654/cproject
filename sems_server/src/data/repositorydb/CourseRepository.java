package data.repositorydb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import business.model.*;
import data.dbutil.DbObject;
import data.dbutil.DbUtil;
import data.dbutil.SqlFunctions;
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
		List<DbObject> data1 = item.toDbObjectList();
		try {
                    DbUtil dbu = new DbUtil();
                    List<DbObject> data2 = item.toDbObjectListCS();
                    SqlFunctions.insert("courses", data1,dbu);
                    SqlFunctions.insert("specializations_courses", data2,dbu);
                    for(Professor p : item.getProfessors()){
                        List<DbObject> data3 = item.toDbObjectListTC(p);
                        SqlFunctions.insert("teachers_spec", data3,dbu);
                    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			if(c.getCod().equalsIgnoreCase(name))
				return c;
		}
		return null;
	}

	/**
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update(Course item) {
		List<DbObject> data1 = item.toDbObjectList();
		try {
			List<DbObject> data2 = item.toDbObjectListCS();
			SqlFunctions.update("courses", data1, "courseCode = '"+
					item.getCod()+"'");
			Integer csid = 0;
			ResultSet rs;
			while((rs = new DbUtil().getDate("select csId from " +
					"specializations_courses where courseId in (select " +
					"courseId from courses where courseName ='"+item.getName()+
					"') limit 1")).next());
				csid = rs.getInt(1);
			SqlFunctions.update("specializations_courses", data2, "csId = "+
					csid.toString());
			for(Professor p : item.getProfessors()){
				Integer tsid = 0;
				ResultSet rs1 = null;
				while((rs = new DbUtil().getDate("select tsId from teachers_" +
					   "spec where teacherId in(select teacherId from teachers"
						+" where userName = '"+p.getUserName()+"')limit 1")
						).next())
					tsid = rs1.getInt(1);
				List<DbObject> data3 = item.toDbObjectListTC(p);
				SqlFunctions.update("teachers_spec", data3,"where tsId="+tsid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Course item) {
		l.remove(item);
		try {
			SqlFunctions.delete("specializations_courses", "courseCode = '"+
					item.getCod()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
