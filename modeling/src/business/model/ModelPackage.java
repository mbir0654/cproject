/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package business.model;

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
	 * The number of structural features of the '<em>Administrator Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR_INTERFACE_FEATURE_COUNT = 0;

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
	 * The number of structural features of the '<em>Professor Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFESSOR_INTERFACE_FEATURE_COUNT = 0;

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
	 * The number of structural features of the '<em>Student Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STUDENT_INTERFACE_FEATURE_COUNT = 0;


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
	 * Returns the meta object for class '{@link business.model.ProfessorInterface <em>Professor Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Professor Interface</em>'.
	 * @see business.model.ProfessorInterface
	 * @generated
	 */
	EClass getProfessorInterface();

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
		 * The meta object literal for the '{@link business.model.impl.ProfessorInterfaceImpl <em>Professor Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see business.model.impl.ProfessorInterfaceImpl
		 * @see business.model.impl.ModelPackageImpl#getProfessorInterface()
		 * @generated
		 */
		EClass PROFESSOR_INTERFACE = eINSTANCE.getProfessorInterface();

		/**
		 * The meta object literal for the '{@link business.model.impl.StudentInterfaceImpl <em>Student Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see business.model.impl.StudentInterfaceImpl
		 * @see business.model.impl.ModelPackageImpl#getStudentInterface()
		 * @generated
		 */
		EClass STUDENT_INTERFACE = eINSTANCE.getStudentInterface();

	}

} //ModelPackage
