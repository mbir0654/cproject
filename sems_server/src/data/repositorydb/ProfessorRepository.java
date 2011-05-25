package data.repositorydb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import business.model.*;
import data.dbutil.DbUtil;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class ProfessorRepository implements Repository<Professor> {
	
	private List<Professor> l;
	
	/**
	 * retine singura instanta a repositoryului
	 */
	private static final ProfessorRepository theTeachers =
		new ProfessorRepository();
	
	/**
	 * Metoda folosita pt accesarea repositoryului
	 * 
	 * @return referinta la singura instanta a repositoryului
	 */
	public static ProfessorRepository getInstance(){
		return theTeachers;
	}
	
	/**
	 * Constructor implicit privat, impiedica creara de instante din afara
	 */
	private ProfessorRepository(){
		l = new ArrayList<Professor>();
		Professor p;
		try {
			DbUtil dbu = new DbUtil();
			String str = "select * from users where role = 'prof'";
			ResultSet rs = dbu.getDate(str);
			while (rs.next()){
				p = new Professor();
				p.setFirstName(rs.getString("firstName"));
				p.setLastName(rs.getString("lastName"));
				p.setUserName(rs.getString("userName"));
				p.setPassword(rs.getString("password"));
				String gft = "call groups_for_teacher('"+p.getUserName()+"')";
				ResultSet rs1 = dbu.getDate(gft);
				while(rs1.next()){
					Group g = new Group(rs1.getString(1));
					g.setSpecialty(null);
					g.addStudent(null);
					p.addGroup(g);
				}
				l.add(p);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Professor item) {
		l.add(item);
		DbUtil dbu;
		try {
			dbu = new DbUtil();
			String str = "insert into users values('"+item.getFirstName()+"','"+
			item.getLastName()+"','"+item.getUserName()+"','"+item.getPassword()+
			"','prof')";
			dbu.makeUpdate(str);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see data.repositoryinterface.Repository#getAll()
	 */
	@Override
	public List<Professor> getAll() {
		return l;
	}

	/**
	 * @see data.repositoryinterface.Repository#findByName(java.lang.String)
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
	public void update(Professor item) {
		String updater = "UPDATE users SET fisrtName="+item.getFirstName()+
		", lastName="+item.getLastName()+", password = '"+item.getPassword()+
		"' WHERE userName='"+item.getUserName()+"'";
		DbUtil dbu;
		try {
			dbu = new DbUtil();
			dbu.makeUpdate(updater);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Professor item) {
		l.remove(item);
		DbUtil dbu;
		try {
			dbu = new DbUtil();
			String str  = "delete from users where userName = '"+item.getUserName()+"'";
			dbu.makeUpdate(str);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
