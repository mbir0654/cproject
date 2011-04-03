/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package business.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Administrator Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link business.model.AdministratorInterface#getFirstName <em>First Name</em>}</li>
 *   <li>{@link business.model.AdministratorInterface#getLastName <em>Last Name</em>}</li>
 *   <li>{@link business.model.AdministratorInterface#getUserName <em>User Name</em>}</li>
 *   <li>{@link business.model.AdministratorInterface#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see business.model.ModelPackage#getAdministratorInterface()
 * @model
 * @generated
 */
public class Administrator {
	String firstName = "";
	String lastName = "";
	String userName = "";
	String password = "";

	/**
	 * Returns the value of the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Name</em>' attribute.
	 * @see #setFirstName(String)
	 * @see business.model.ModelPackage#getAdministratorInterface_FirstName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the value of the '{@link business.model.AdministratorInterface#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	public void setFirstName(String value) {
		firstName = value;
	}

	/**
	 * Returns the value of the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Name</em>' attribute.
	 * @see #setLastName(String)
	 * @see business.model.ModelPackage#getAdministratorInterface_LastName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	public String getLastName() {
		return lastName; 
	}

	/**
	 * Sets the value of the '{@link business.model.AdministratorInterface#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	public void setLastName(String value) {
		lastName = value;
	}

	/**
	 * Returns the value of the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Name</em>' attribute.
	 * @see #setUserName(String)
	 * @see business.model.ModelPackage#getAdministratorInterface_UserName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the value of the '{@link business.model.AdministratorInterface#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	public void setUserName(String value) {
		userName = value;
	}

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see business.model.ModelPackage#getAdministratorInterface_Password()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the '{@link business.model.AdministratorInterface#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	public void setPassword(String value) {
		password = value;
	}
} // AdministratorInterface
