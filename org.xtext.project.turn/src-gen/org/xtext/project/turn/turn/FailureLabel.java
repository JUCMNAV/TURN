/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.FailureLabel#getFailure <em>Failure</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getFailureLabel()
 * @model
 * @generated
 */
public interface FailureLabel extends EObject
{
  /**
   * Returns the value of the '<em><b>Failure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failure</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failure</em>' attribute.
   * @see #setFailure(String)
   * @see org.xtext.project.turn.turn.TurnPackage#getFailureLabel_Failure()
   * @model
   * @generated
   */
  String getFailure();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.FailureLabel#getFailure <em>Failure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failure</em>' attribute.
   * @see #getFailure()
   * @generated
   */
  void setFailure(String value);

} // FailureLabel
