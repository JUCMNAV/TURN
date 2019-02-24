/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package org.xtext.project.turn.turn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>And Fork</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.AndFork#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.AndFork#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.AndFork#getPathbody <em>Pathbody</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.AndFork#getConnectingAndBody <em>Connecting And Body</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getAndFork()
 * @model
 * @generated
 */
public interface AndFork extends URNmodelElement, RegularEnd
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
   * @see org.xtext.project.turn.turn.TurnPackage#getAndFork_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.AndFork#getName <em>Name</em>}' attribute.
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
   * @see org.xtext.project.turn.turn.TurnPackage#getAndFork_LongName()
   * @model containment="true"
   * @generated
   */
  LongName getLongName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.AndFork#getLongName <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Name</em>' containment reference.
   * @see #getLongName()
   * @generated
   */
  void setLongName(LongName value);

  /**
   * Returns the value of the '<em><b>Pathbody</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.PathBody}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pathbody</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pathbody</em>' containment reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getAndFork_Pathbody()
   * @model containment="true"
   * @generated
   */
  EList<PathBody> getPathbody();

  /**
   * Returns the value of the '<em><b>Connecting And Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connecting And Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connecting And Body</em>' containment reference.
   * @see #setConnectingAndBody(PathBody)
   * @see org.xtext.project.turn.turn.TurnPackage#getAndFork_ConnectingAndBody()
   * @model containment="true"
   * @generated
   */
  PathBody getConnectingAndBody();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.AndFork#getConnectingAndBody <em>Connecting And Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connecting And Body</em>' containment reference.
   * @see #getConnectingAndBody()
   * @generated
   */
  void setConnectingAndBody(PathBody value);

} // AndFork
