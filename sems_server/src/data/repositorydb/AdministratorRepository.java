package data.repositorydb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import business.model.*;
import data.dbutil.DbObject;
import data.dbutil.DbUtil;
import data.dbutil.SqlFunctions;
import data.repositoryinterface.Repository;

/**
 * @author otniel
 *
 */
public class AdministratorRepository implements Repository<Administrator>{
	
	private List<Administrator> l;
	
	private static final AdministratorRepository theAdmins = new AdministratorRepository();
	
	/**
	 * Metoda asigura acces la singura instanta a repositoryului 
	 * 
	 * @return o referinta la repository
	 */
	public static AdministratorRepository getInstance(){
		return theAdmins;
	}
	
	/**
	 * Constructorul implicit privat impiedica crearea mai multor instante de 
	 *  repository din afara
	 */
	private AdministratorRepository(){
		l = new ArrayList<Administrator>();
		Administrator a;
		try {
			DbUtil dbu = new DbUtil();
			String str = "select * from users where role = 'admin'";
			ResultSet rs = dbu.getDate(str);
			while (rs.next()){
				a = new Administrator();
				a.setFirstName(rs.getString("firstName"));
				a.setLastName(rs.getString("lastName"));
				a.setUserName(rs.getString("userName"));
				a.setPassword(rs.getString("password"));
				l.add(a);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public void add(Administrator item) {
		l.add(item);
		List<DbObject> data = item.toDbObjectList();
		try {
			SqlFunctions.insert("users", data);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public List<Administrator> getAll() {
		return l;
	}

	/**
	 * 
	 */
	@Override
	public Administrator findByName(String name) {
		for (Administrator a : l){
			if(a.getUserName().equals(name))
			    return a;
		}
		return null;
	}

	/**
	 * 
	 */
	@Override
	public void update(Administrator item) {
		List<DbObject> data = item.toDbObjectList();
		try {
			SqlFunctions.update("users", data, "userName = '"
					+item.getUserName()+"'");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public void delete(Administrator item) {
		l.remove(item);
		try {
			SqlFunctions.delete("users", "userName = '"+item.getUserName()+"'");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
		
}
