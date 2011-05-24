/**
 * 
 */
package data.repositorydb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.model.Administrator;
import business.model.Course;
import business.model.Faculty;
import business.model.Specialty;
import data.dbutil.DbUtil;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class FacultyRepository implements Repository<Faculty>{
	
	private List<Faculty> l;
	
	public FacultyRepository(){
		l = new ArrayList<Faculty>();
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Faculty item) {
		l.add(item);
		Faculty f;
		try {
			DbUtil dbu = new DbUtil();
			String str = "select * from faculties";
			ResultSet rs = dbu.getDate(str);
			while (rs.next()){
				f = new Faculty();
				f.setName(rs.getString("facultyName"));
				f.setAddress(rs.getString("address"));
				int fid = rs.getInt(1);
				ResultSet rs2 = dbu.getDate("select * from specializations" +
						"where spId in (select spId from faculties_" +
						"specializations where facultyId = "+fid);
				while(rs2.next()){
					Specialty sp = new Specialty();
					sp.setFaculty(f);
					sp.setName(rs.getString(2));
					sp.setNumberOfYears(rs.getInt(3));
					int spId = rs.getInt(1);
					ResultSet rs3 = dbu.getDate("select ");
					while(rs3.next()){
						ResultSet rss = dbu.getDate("select ");
						Course c = new Course();
						
					}
				}
				l.add(f);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Faculty> getAll() {
		List<Faculty> r = new ArrayList<Faculty>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Faculty findByName(String name) {
		for(Faculty f:l){
			if(f.getName().equalsIgnoreCase(name))
				return f;
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
	 * 
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Faculty item) {
		l.remove(item);		
	}

}