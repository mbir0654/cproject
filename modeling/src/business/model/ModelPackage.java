/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package business.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see business.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///business/model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "business.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = business.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link business.model.impl.AdministratorInterfaceImpl <em>Administrator Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see business.model.impl.AdministratorInterfaceImpl
	 * @see business.model.impl.ModelPackageImpl#getAdministratorInterface()
	 * @generated
	 */
	int ADMINISTRATOR_INTERFACE = 0;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR_INTERFACE__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR_INTERFACE__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR_INTERFACE__USER_NAME = 2;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR_INTERFACE__PASSWORD = 3;

	/**
	 * The number of structural features of the '<em>Administrator Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR_INTERFACE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link business.model.impl.ProfessorInterfaceImpl <em>Professor Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see business.model.impl.ProfessorInterfaceImpl
	 * @see business.model.impl.ModelPackageImpl#getProfessorInterface()
	 * @generated
	 */
	int PROFESSOR_INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_INTERFACE__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_INTERFACE__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_INTERFACE__USER_NAME = 2;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_INTERFACE__PASSWORD = 3;

	/**
	 * The number of structural features of the '<em>Professor Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_INTERFACE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link business.model.impl.StudentInterfaceImpl <em>Student Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see business.model.impl.StudentInterfaceImpl
	 * @see business.model.impl.ModelPackageImpl#getStudentInterface()
	 * @generated
	 */
	int STUDENT_INTERFACE = 2;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_INTERFACE__FIRST_NAME = 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_INTERFACE__LAST_NAME = 1;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_INTERFACE__USER_NAME = 2;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_INTERFACE__PASSWORD = 3;

	/**
	 * The number of structural features of the '<em>Student Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_INTERFACE_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link business.model.AdministratorInterface <em>Administrator Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Administrator Interface</em>'.
	 * @see business.model.AdministratorInterface
	 * @generated
	 */
	EClass getAdministratorInterface();

	/**
	 * Returns the meta object for the attribute '{@link business.model.AdministratorInterface#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see business.model.AdministratorInterface#getFirstName()
	 * @see #getAdministratorInterface()
	 * @generated
	 */
	EAttribute getAdministratorInterface_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.AdministratorInterface#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see business.model.AdministratorInterface#getLastName()
	 * @see #getAdministratorInterface()
	 * @generated
	 */
	EAttribute getAdministratorInterface_LastName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.AdministratorInterface#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see business.model.AdministratorInterface#getUserName()
	 * @see #getAdministratorInterface()
	 * @generated
	 */
	EAttribute getAdministratorInterface_UserName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.AdministratorInterface#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see business.model.AdministratorInterface#getPassword()
	 * @see #getAdministratorInterface()
	 * @generated
	 */
	EAttribute getAdministratorInterface_Password();

	/**
	 * Returns the meta object for class '{@link business.model.ProfessorInterface <em>Professor Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Professor Interface</em>'.
	 * @see business.model.ProfessorInterface
	 * @generated
	 */
	EClass getProfessorInterface();

	/**
	 * Returns the meta object for the attribute '{@link business.model.ProfessorInterface#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see business.model.ProfessorInterface#getFirstName()
	 * @see #getProfessorInterface()
	 * @generated
	 */
	EAttribute getProfessorInterface_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.ProfessorInterface#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see business.model.ProfessorInterface#getLastName()
	 * @see #getProfessorInterface()
	 * @generated
	 */
	EAttribute getProfessorInterface_LastName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.ProfessorInterface#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see business.model.ProfessorInterface#getUserName()
	 * @see #getProfessorInterface()
	 * @generated
	 */
	EAttribute getProfessorInterface_UserName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.ProfessorInterface#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see business.model.ProfessorInterface#getPassword()
	 * @see #getProfessorInterface()
	 * @generated
	 */
	EAttribute getProfessorInterface_Password();

	/**
	 * Returns the meta object for class '{@link business.model.StudentInterface <em>Student Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Student Interface</em>'.
	 * @see business.model.StudentInterface
	 * @generated
	 */
	EClass getStudentInterface();

	/**
	 * Returns the meta object for the attribute '{@link business.model.StudentInterface#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see business.model.StudentInterface#getFirstName()
	 * @see #getStudentInterface()
	 * @generated
	 */
	EAttribute getStudentInterface_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.StudentInterface#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see business.model.StudentInterface#getLastName()
	 * @see #getStudentInterface()
	 * @generated
	 */
	EAttribute getStudentInterface_LastName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.StudentInterface#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see business.model.StudentInterface#getUserName()
	 * @see #getStudentInterface()
	 * @generated
	 */
	EAttribute getStudentInterface_UserName();

	/**
	 * Returns the meta object for the attribute '{@link business.model.StudentInterface#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see business.model.StudentInterface#getPassword()
	 * @see #getStudentInterface()
	 * @generated
	 */
	EAttribute getStudentInterface_Password();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link business.model.impl.AdministratorInterfaceImpl <em>Administrator Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see business.model.impl.AdministratorInterfaceImpl
		 * @see business.model.impl.ModelPackageImpl#getAdministratorInterface()
		 * @generated
		 */
		EClass ADMINISTRATOR_INTERFACE = eINSTANCE.getAdministratorInterface();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADMINISTRATOR_INTERFACE__FIRST_NAME = eINSTANCE.getAdministratorInterface_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADMINISTRATOR_INTERFACE__LAST_NAME = eINSTANCE.getAdministratorInterface_LastName();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADMINISTRATOR_INTERFACE__USER_NAME = eINSTANCE.getAdministratorInterface_UserName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADMINISTRATOR_INTERFACE__PASSWORD = eINSTANCE.getAdministratorInterface_Password();

		/**
		 * The meta object literal for the '{@link business.model.impl.ProfessorInterfaceImpl <em>Professor Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see business.model.impl.ProfessorInterfaceImpl
		 * @see business.model.impl.ModelPackageImpl#getProfessorInterface()
		 * @generated
		 */
		EClass PROFESSOR_INTERFACE = eINSTANCE.getProfessorInterface();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFESSOR_INTERFACE__FIRST_NAME = eINSTANCE.getProfessorInterface_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFESSOR_INTERFACE__LAST_NAME = eINSTANCE.getProfessorInterface_LastName();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFESSOR_INTERFACE__USER_NAME = eINSTANCE.getProfessorInterface_UserName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFESSOR_INTERFACE__PASSWORD = eINSTANCE.getProfessorInterface_Password();

		/**
		 * The meta object literal for the '{@link business.model.impl.StudentInterfaceImpl <em>Student Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see business.model.impl.StudentInterfaceImpl
		 * @see business.model.impl.ModelPackageImpl#getStudentInterface()
		 * @generated
		 */
		EClass STUDENT_INTERFACE = eINSTANCE.getStudentInterface();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STUDENT_INTERFACE__FIRST_NAME = eINSTANCE.getStudentInterface_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STUDENT_INTERFACE__LAST_NAME = eINSTANCE.getStudentInterface_LastName();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STUDENT_INTERFACE__USER_NAME = eINSTANCE.getStudentInterface_UserName();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STUDENT_INTERFACE__PASSWORD = eINSTANCE.getStudentInterface_Password();

	}

} //ModelPackage
