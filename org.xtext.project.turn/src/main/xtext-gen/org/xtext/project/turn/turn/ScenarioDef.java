/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package org.xtext.project.turn.turn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.ScenarioDef#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.ScenarioDef#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.ScenarioDef#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.ScenarioDef#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.ScenarioDef#getInitializations <em>Initializations</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.ScenarioDef#getStartPoints <em>Start Points</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.ScenarioDef#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.ScenarioDef#getIncludedScenarios <em>Included Scenarios</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef()
 * @model
 * @generated
 */
public interface ScenarioDef extends URNmodelElement
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
   * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.ScenarioDef#getName <em>Name</em>}' attribute.
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
   * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef_LongName()
   * @model containment="true"
   * @generated
   */
  LongName getLongName();

  /**
   * Sets the value of the '{@link org.xtext.project.turn.turn.ScenarioDef#getLongName <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Long Name</em>' containment reference.
   * @see #getLongName()
   * @generated
   */
  void setLongName(LongName value);

  /**
   * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.Condition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preconditions</em>' containment reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef_Preconditions()
   * @model containment="true"
   * @generated
   */
  EList<Condition> getPreconditions();

  /**
   * Returns the value of the '<em><b>Postconditions</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.Condition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postconditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postconditions</em>' containment reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef_Postconditions()
   * @model containment="true"
   * @generated
   */
  EList<Condition> getPostconditions();

  /**
   * Returns the value of the '<em><b>Initializations</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.Initialization}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initializations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initializations</em>' containment reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef_Initializations()
   * @model containment="true"
   * @generated
   */
  EList<Initialization> getInitializations();

  /**
   * Returns the value of the '<em><b>Start Points</b></em>' reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.StartPoint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Points</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Points</em>' reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef_StartPoints()
   * @model
   * @generated
   */
  EList<StartPoint> getStartPoints();

  /**
   * Returns the value of the '<em><b>End Points</b></em>' reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.EndPoint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Points</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Points</em>' reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef_EndPoints()
   * @model
   * @generated
   */
  EList<EndPoint> getEndPoints();

  /**
   * Returns the value of the '<em><b>Included Scenarios</b></em>' reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.ScenarioDef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Included Scenarios</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Included Scenarios</em>' reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getScenarioDef_IncludedScenarios()
   * @model
   * @generated
   */
  EList<ScenarioDef> getIncludedScenarios();

} // ScenarioDef