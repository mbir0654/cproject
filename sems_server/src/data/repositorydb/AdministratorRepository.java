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
public class AdministratorRepository implements Repository<Administrator>{
	
	private List<Administrator> l;
	
	private static final AdministratorRepository theAdmins = new AdministratorRepository();
	
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
	
	public static AdministratorRepository getInstance(){
		return theAdmins;
	}

	/**
	 * @see data.repositoryinterface.Repository#add(java.lang.Object)
	 */
	@Override
	public void add(Administrator item) {
		l.add(item);
		DbUtil dbu;
		try {
			dbu = new DbUtil();
			String str = "insert into users values('"+item.getFirstName()+"','"+
			item.getLastName()+"','"+item.getUserName()+"','"+item.getPassword()+
			"','admin')";
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
	public List<Administrator> getAll() {
		List<Administrator> r = new ArrayList<Administrator>();
		r.addAll(l);
		return r;
	}

	/**
	 * @see data.repositoryinterface.Repository#find(java.lang.String)
	 */
	@Override
	public Administrator findByName(String name) {
		for (Administrator a : l){
			if(a.getUserName().equalsIgnoreCase(name));
			return a;
		}
		return null;
	}

	/**
	 * @see data.repositoryinterface.Repository#update(java.lang.Object)
	 */
	@Override
	public void update() {
		/* TODO 
		 */
		
	}

	/**
	 * @see data.repositoryinterface.Repository#delete(java.lang.Object)
	 */
	
	
	@Override
	public void delete(Administrator item) {
		l.remove(item);
		DbUtil dbu;
		try {
			dbu = new DbUtil();
			String str  = "delete from users where userName = "+item.getUserName();
			dbu.makeUpdate(str);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
		
}
