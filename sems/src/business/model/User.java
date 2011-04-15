/**
 * 
 */
package business.model;

	/**
	 * 
	 * @author otniel
	 *
	 */
public abstract class User {
	
	private String firstName = "";
	private String lastName = "";
	private String userName = "";
	private String password = "";
	
	public User(){
	}
	
	/**
	 * @param firstName este prenumele <b>USer</b>ului
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
	 * @param lastName este numele <b>USer</b>ului
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
	 * @param userName este identificatorul <b>USer</b>ului
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return identificatorul <b>USer</b>ului
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param password este parola <b>USer</b>ului
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
}
