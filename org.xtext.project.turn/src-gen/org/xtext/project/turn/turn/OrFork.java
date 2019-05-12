/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Fork</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.OrFork#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.OrFork#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.OrFork#getBody <em>Body</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.OrFork#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.OrFork#getConnectingOrBody <em>Connecting Or Body</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getOrFork()
 * @model
 * @generated
 */
public interface OrFork extends URNmodelElement, RegularEnd
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
   * @see org.xtext.project.turn.turn.TurnPackage#getOrFork_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.OrFork#getName <em>Name</em>}' attribute.
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
   * @see org.xtext.project.turn.turn.TurnPackage#getOrFork_LongName()
   * @model containment="true"
   * @generated
   */
  LongName getLongName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.OrFork#getLongName <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Name</em>' containment reference.
   * @see #getLongName()
   * @generated
   */
  void setLongName(LongName value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(OrBody)
   * @see org.xtext.project.turn.turn.TurnPackage#getOrFork_Body()
   * @model containment="true"
   * @generated
   */
  OrBody getBody();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.OrFork#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(OrBody value);

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
   * @see org.xtext.project.turn.turn.TurnPackage#getOrFork_Condition()
   * @model containment="true"
   * @generated
   */
  Condition getCondition();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.OrFork#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Condition value);

  /**
   * Returns the value of the '<em><b>Connecting Or Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connecting Or Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connecting Or Body</em>' containment reference.
   * @see #setConnectingOrBody(PathBody)
   * @see org.xtext.project.turn.turn.TurnPackage#getOrFork_ConnectingOrBody()
   * @model containment="true"
   * @generated
   */
  PathBody getConnectingOrBody();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.OrFork#getConnectingOrBody <em>Connecting Or Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connecting Or Body</em>' containment reference.
   * @see #getConnectingOrBody()
   * @generated
   */
  void setConnectingOrBody(PathBody value);

} // OrFork
