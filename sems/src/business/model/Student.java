/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package business.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Student Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link business.model.StudentInterface#getFirstName <em>First Name</em>}</li>
 *   <li>{@link business.model.StudentInterface#getLastName <em>Last Name</em>}</li>
 *   <li>{@link business.model.StudentInterface#getUserName <em>User Name</em>}</li>
 *   <li>{@link business.model.StudentInterface#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see business.model.ModelPackage#getStudentInterface()
 * @model
 * @generated
 */
public class Student {
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
	 * @see business.model.ModelPackage#getStudentInterface_FirstName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the value of the '{@link business.model.StudentInterface#getFirstName <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Name</em>' attribute.
	 * @see #getFirstName()
	 * @generated
	 */
	void setFirstName(String value) {
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
	 * @see business.model.ModelPackage#getStudentInterface_LastName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getLastName() {
		return lastName; 
	}

	/**
	 * Sets the value of the '{@link business.model.StudentInterface#getLastName <em>Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Name</em>' attribute.
	 * @see #getLastName()
	 * @generated
	 */
	void setLastName(String value) {
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
	 * @see business.model.ModelPackage#getStudentInterface_UserName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getUserName() {
		return userName;
	}

	/**
	 * Sets the value of the '{@link business.model.StudentInterface#getUserName <em>User Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Name</em>' attribute.
	 * @see #getUserName()
	 * @generated
	 */
	void setUserName(String value) {
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
	 * @see business.model.ModelPackage#getStudentInterface_Password()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the '{@link business.model.StudentInterface#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
	void setPassword(String value) {
		password = value;
	}
} // StudentInterface
