/**
 * generated by Xtext 2.12.0
 */
package org.xtext.project.turn.turn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.OrBody#getElseBody <em>Else Body</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.OrBody#getRegularBody <em>Regular Body</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getOrBody()
 * @model
 * @generated
 */
public interface OrBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Else Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Body</em>' containment reference.
   * @see #setElseBody(PathBody)
   * @see org.xtext.project.turn.turn.TurnPackage#getOrBody_ElseBody()
   * @model containment="true"
   * @generated
   */
  PathBody getElseBody();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.OrBody#getElseBody <em>Else Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Body</em>' containment reference.
   * @see #getElseBody()
   * @generated
   */
  void setElseBody(PathBody value);

  /**
   * Returns the value of the '<em><b>Regular Body</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.RegularOrFork}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Regular Body</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Regular Body</em>' containment reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getOrBody_RegularBody()
   * @model containment="true"
   * @generated
   */
  EList<RegularOrFork> getRegularBody();

} // OrBody
