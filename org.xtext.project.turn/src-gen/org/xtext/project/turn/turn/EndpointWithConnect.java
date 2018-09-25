/**
 * generated by Xtext 2.12.0
 */
package org.xtext.project.turn.turn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Endpoint With Connect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.EndpointWithConnect#getRegularEnd <em>Regular End</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.EndpointWithConnect#getConnect <em>Connect</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getEndpointWithConnect()
 * @model
 * @generated
 */
public interface EndpointWithConnect extends RegularEnd
{
  /**
   * Returns the value of the '<em><b>Regular End</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Regular End</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Regular End</em>' containment reference.
   * @see #setRegularEnd(EndPoint)
   * @see org.xtext.project.turn.turn.TurnPackage#getEndpointWithConnect_RegularEnd()
   * @model containment="true"
   * @generated
   */
  EndPoint getRegularEnd();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.EndpointWithConnect#getRegularEnd <em>Regular End</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Regular End</em>' containment reference.
   * @see #getRegularEnd()
   * @generated
   */
  void setRegularEnd(EndPoint value);

  /**
   * Returns the value of the '<em><b>Connect</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connect</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connect</em>' containment reference.
   * @see #setConnect(Connect)
   * @see org.xtext.project.turn.turn.TurnPackage#getEndpointWithConnect_Connect()
   * @model containment="true"
   * @generated
   */
  Connect getConnect();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.EndpointWithConnect#getConnect <em>Connect</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connect</em>' containment reference.
   * @see #getConnect()
   * @generated
   */
  void setConnect(Connect value);

} // EndpointWithConnect