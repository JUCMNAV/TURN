/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metadata</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.Metadata#getElem <em>Elem</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.Metadata#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.Metadata#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getMetadata()
 * @model
 * @generated
 */
public interface Metadata extends EObject
{
  /**
   * Returns the value of the '<em><b>Elem</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elem</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elem</em>' reference.
   * @see #setElem(URNmodelElement)
   * @see org.xtext.project.turn.turn.TurnPackage#getMetadata_Elem()
   * @model
   * @generated
   */
  URNmodelElement getElem();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.Metadata#getElem <em>Elem</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elem</em>' reference.
   * @see #getElem()
   * @generated
   */
  void setElem(URNmodelElement value);

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
   * @see org.xtext.project.turn.turn.TurnPackage#getMetadata_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.Metadata#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Text)
   * @see org.xtext.project.turn.turn.TurnPackage#getMetadata_Value()
   * @model containment="true"
   * @generated
   */
  Text getValue();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.Metadata#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Text value);

} // Metadata
