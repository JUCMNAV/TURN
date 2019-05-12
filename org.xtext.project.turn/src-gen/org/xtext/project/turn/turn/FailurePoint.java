/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Failure Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.FailurePoint#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.FailurePoint#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.FailurePoint#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.FailurePoint#getFailLabel <em>Fail Label</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getFailurePoint()
 * @model
 * @generated
 */
public interface FailurePoint extends URNmodelElement, PathBodyNode, ReferencedEnd
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
   * @see org.xtext.project.turn.turn.TurnPackage#getFailurePoint_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.FailurePoint#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Long Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Long Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Long Name</em>' containment reference.
   * @see #setLongName(LongName)
   * @see org.xtext.project.turn.turn.TurnPackage#getFailurePoint_LongName()
   * @model containment="true"
   * @generated
   */
  LongName getLongName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.FailurePoint#getLongName <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Name</em>' containment reference.
   * @see #getLongName()
   * @generated
   */
  void setLongName(LongName value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see org.xtext.project.turn.turn.TurnPackage#getFailurePoint_Condition()
   * @model containment="true"
   * @generated
   */
  Condition getCondition();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.FailurePoint#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Condition value);

  /**
   * Returns the value of the '<em><b>Fail Label</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail Label</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail Label</em>' containment reference.
   * @see #setFailLabel(FailureLabel)
   * @see org.xtext.project.turn.turn.TurnPackage#getFailurePoint_FailLabel()
   * @model containment="true"
   * @generated
   */
  FailureLabel getFailLabel();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.FailurePoint#getFailLabel <em>Fail Label</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Label</em>' containment reference.
   * @see #getFailLabel()
   * @generated
   */
  void setFailLabel(FailureLabel value);

} // FailurePoint
