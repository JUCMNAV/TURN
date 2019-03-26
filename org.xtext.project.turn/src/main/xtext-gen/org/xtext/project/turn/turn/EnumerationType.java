/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package org.xtext.project.turn.turn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.EnumerationType#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.EnumerationType#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getEnumerationType()
 * @model
 * @generated
 */
public interface EnumerationType extends URNmodelElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.project.turn.turn.TurnPackage#getEnumerationType_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.EnumerationType#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' attribute list.
   * @see org.xtext.project.turn.turn.TurnPackage#getEnumerationType_Values()
   * @model unique="false"
   * @generated
   */
  EList<String> getValues();

} // EnumerationType
