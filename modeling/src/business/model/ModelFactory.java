/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package business.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see business.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelFactory eINSTANCE = business.model.impl.ModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Administrator Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Administrator Interface</em>'.
	 * @generated
	 */
	AdministratorInterface createAdministratorInterface();

	/**
	 * Returns a new object of class '<em>Professor Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Professor Interface</em>'.
	 * @generated
	 */
	ProfessorInterface createProfessorInterface();

	/**
	 * Returns a new object of class '<em>Student Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Student Interface</em>'.
	 * @generated
	 */
	StudentInterface createStudentInterface();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelPackage getModelPackage();

} //ModelFactory
