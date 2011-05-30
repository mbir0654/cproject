/**
 * 
 */
package business.model;

import java.io.Serializable;
import java.util.List;
import data.dbutil.DbObject;
import java.util.ArrayList;

	/**
	 * 
	 * @author otniel
	 *
	 */
public abstract class User implements Serializable {
	
	protected String firstName = "";
	protected String lastName = "";
	protected String userName = "";
	protected String password = "";
	
	/**
	 * Constructorul implicit
	 * 
	 * <p>Initializeaza <b>firstName, lastName, userName</b> si <b>password</b></p>
	 */
	public User(){
	}
	
	/**
	 * Constructorul de copiere
	 * 
	 * @param u este userul care va fi duplicat
	 */
	public User(User u){
		firstName = u.getFirstName();
		lastName = u.getLastName();
		userName = u.getUserName();
		password = u.getPassword();
	}
	
	/**
	 * Verifica daca doi useri sunt identici
	 * 
	 * @param u
	 * 
	 * @return
	 */
	public boolean equals(User u){
		if(firstName.equals(u.getFirstName()) && 
		   lastName.equalsIgnoreCase(u.getLastName()) &&
		   userName.equalsIgnoreCase(u.getUserName()) &&
		   password.equalsIgnoreCase(u.getPassword()))
			return true;
		return false;
	}
	
	/**
	 * @param firstName va fi prenumele <b>USer</b>ului
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return prenumele <b>USer</b>ului
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param lastName va fi numele <b>USer</b>ului
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return numele <b>USer</b>ului
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param userName va fi identificatorul <b>USer</b>ului
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return identificatorul <b>User</b>ului
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param password va fi parola <b>USer</b>ului
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return parola <b>USer</b>ului
	 */
	public String getPassword() {
		return password;
	}
	
    @Override
	public String toString() {
		return this.firstName+" "+this.lastName;
	}
	
	public List<DbObject> toDbObjectList(){
            DbObject db1 = new DbObject("firstName",firstName);
            DbObject db2 = new DbObject("lastName",lastName);
            DbObject db3 = new DbObject("userName",userName);
            DbObject db4 = new DbObject("password",password);
            List<DbObject> list = new ArrayList<DbObject>();
            list.add(db1); list.add(db2); list.add(db3);list.add(db4);
            return list;
	}
}