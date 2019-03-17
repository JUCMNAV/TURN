/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package org.xtext.project.turn.turn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.project.turn.turn.Condition;
import org.xtext.project.turn.turn.Initialization;
import org.xtext.project.turn.turn.LongName;
import org.xtext.project.turn.turn.ReferenceToScenarioDef;
import org.xtext.project.turn.turn.ScenarioDef;
import org.xtext.project.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getInitializations <em>Initializations</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getStartPoint <em>Start Point</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getStartPoints <em>Start Points</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getEndPoint <em>End Point</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getIncludedScenario <em>Included Scenario</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ScenarioDefImpl#getIncludedScenarios <em>Included Scenarios</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScenarioDefImpl extends MinimalEObjectImpl.Container implements ScenarioDef
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getLongName() <em>Long Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLongName()
   * @generated
   * @ordered
   */
  protected LongName longName;

  /**
   * The cached value of the '{@link #getPreconditions() <em>Preconditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreconditions()
   * @generated
   * @ordered
   */
  protected EList<Condition> preconditions;

  /**
   * The cached value of the '{@link #getPostconditions() <em>Postconditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostconditions()
   * @generated
   * @ordered
   */
  protected EList<Condition> postconditions;

  /**
   * The cached value of the '{@link #getInitializations() <em>Initializations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitializations()
   * @generated
   * @ordered
   */
  protected EList<Initialization> initializations;

  /**
   * The default value of the '{@link #getStartPoint() <em>Start Point</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartPoint()
   * @generated
   * @ordered
   */
  protected static final String START_POINT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStartPoint() <em>Start Point</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartPoint()
   * @generated
   * @ordered
   */
  protected String startPoint = START_POINT_EDEFAULT;

  /**
   * The cached value of the '{@link #getStartPoints() <em>Start Points</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartPoints()
   * @generated
   * @ordered
   */
  protected EList<String> startPoints;

  /**
   * The default value of the '{@link #getEndPoint() <em>End Point</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndPoint()
   * @generated
   * @ordered
   */
  protected static final String END_POINT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEndPoint() <em>End Point</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndPoint()
   * @generated
   * @ordered
   */
  protected String endPoint = END_POINT_EDEFAULT;

  /**
   * The cached value of the '{@link #getEndPoints() <em>End Points</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEndPoints()
   * @generated
   * @ordered
   */
  protected EList<String> endPoints;

  /**
   * The cached value of the '{@link #getIncludedScenario() <em>Included Scenario</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncludedScenario()
   * @generated
   * @ordered
   */
  protected ReferenceToScenarioDef includedScenario;

  /**
   * The cached value of the '{@link #getIncludedScenarios() <em>Included Scenarios</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncludedScenarios()
   * @generated
   * @ordered
   */
  protected EList<ReferenceToScenarioDef> includedScenarios;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ScenarioDefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return TurnPackage.Literals.SCENARIO_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.SCENARIO_DEF__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongName getLongName()
  {
    return longName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLongName(LongName newLongName, NotificationChain msgs)
  {
    LongName oldLongName = longName;
    longName = newLongName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.SCENARIO_DEF__LONG_NAME, oldLongName, newLongName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLongName(LongName newLongName)
  {
    if (newLongName != longName)
    {
      NotificationChain msgs = null;
      if (longName != null)
        msgs = ((InternalEObject)longName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.SCENARIO_DEF__LONG_NAME, null, msgs);
      if (newLongName != null)
        msgs = ((InternalEObject)newLongName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.SCENARIO_DEF__LONG_NAME, null, msgs);
      msgs = basicSetLongName(newLongName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.SCENARIO_DEF__LONG_NAME, newLongName, newLongName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Condition> getPreconditions()
  {
    if (preconditions == null)
    {
      preconditions = new EObjectContainmentEList<Condition>(Condition.class, this, TurnPackage.SCENARIO_DEF__PRECONDITIONS);
    }
    return preconditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Condition> getPostconditions()
  {
    if (postconditions == null)
    {
      postconditions = new EObjectContainmentEList<Condition>(Condition.class, this, TurnPackage.SCENARIO_DEF__POSTCONDITIONS);
    }
    return postconditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Initialization> getInitializations()
  {
    if (initializations == null)
    {
      initializations = new EObjectContainmentEList<Initialization>(Initialization.class, this, TurnPackage.SCENARIO_DEF__INITIALIZATIONS);
    }
    return initializations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStartPoint()
  {
    return startPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartPoint(String newStartPoint)
  {
    String oldStartPoint = startPoint;
    startPoint = newStartPoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.SCENARIO_DEF__START_POINT, oldStartPoint, startPoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getStartPoints()
  {
    if (startPoints == null)
    {
      startPoints = new EDataTypeEList<String>(String.class, this, TurnPackage.SCENARIO_DEF__START_POINTS);
    }
    return startPoints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEndPoint()
  {
    return endPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEndPoint(String newEndPoint)
  {
    String oldEndPoint = endPoint;
    endPoint = newEndPoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.SCENARIO_DEF__END_POINT, oldEndPoint, endPoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getEndPoints()
  {
    if (endPoints == null)
    {
      endPoints = new EDataTypeEList<String>(String.class, this, TurnPackage.SCENARIO_DEF__END_POINTS);
    }
    return endPoints;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceToScenarioDef getIncludedScenario()
  {
    return includedScenario;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIncludedScenario(ReferenceToScenarioDef newIncludedScenario, NotificationChain msgs)
  {
    ReferenceToScenarioDef oldIncludedScenario = includedScenario;
    includedScenario = newIncludedScenario;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO, oldIncludedScenario, newIncludedScenario);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIncludedScenario(ReferenceToScenarioDef newIncludedScenario)
  {
    if (newIncludedScenario != includedScenario)
    {
      NotificationChain msgs = null;
      if (includedScenario != null)
        msgs = ((InternalEObject)includedScenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO, null, msgs);
      if (newIncludedScenario != null)
        msgs = ((InternalEObject)newIncludedScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO, null, msgs);
      msgs = basicSetIncludedScenario(newIncludedScenario, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO, newIncludedScenario, newIncludedScenario));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReferenceToScenarioDef> getIncludedScenarios()
  {
    if (includedScenarios == null)
    {
      includedScenarios = new EObjectContainmentEList<ReferenceToScenarioDef>(ReferenceToScenarioDef.class, this, TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIOS);
    }
    return includedScenarios;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case TurnPackage.SCENARIO_DEF__LONG_NAME:
        return basicSetLongName(null, msgs);
      case TurnPackage.SCENARIO_DEF__PRECONDITIONS:
        return ((InternalEList<?>)getPreconditions()).basicRemove(otherEnd, msgs);
      case TurnPackage.SCENARIO_DEF__POSTCONDITIONS:
        return ((InternalEList<?>)getPostconditions()).basicRemove(otherEnd, msgs);
      case TurnPackage.SCENARIO_DEF__INITIALIZATIONS:
        return ((InternalEList<?>)getInitializations()).basicRemove(otherEnd, msgs);
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO:
        return basicSetIncludedScenario(null, msgs);
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIOS:
        return ((InternalEList<?>)getIncludedScenarios()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case TurnPackage.SCENARIO_DEF__NAME:
        return getName();
      case TurnPackage.SCENARIO_DEF__LONG_NAME:
        return getLongName();
      case TurnPackage.SCENARIO_DEF__PRECONDITIONS:
        return getPreconditions();
      case TurnPackage.SCENARIO_DEF__POSTCONDITIONS:
        return getPostconditions();
      case TurnPackage.SCENARIO_DEF__INITIALIZATIONS:
        return getInitializations();
      case TurnPackage.SCENARIO_DEF__START_POINT:
        return getStartPoint();
      case TurnPackage.SCENARIO_DEF__START_POINTS:
        return getStartPoints();
      case TurnPackage.SCENARIO_DEF__END_POINT:
        return getEndPoint();
      case TurnPackage.SCENARIO_DEF__END_POINTS:
        return getEndPoints();
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO:
        return getIncludedScenario();
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIOS:
        return getIncludedScenarios();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TurnPackage.SCENARIO_DEF__NAME:
        setName((String)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__LONG_NAME:
        setLongName((LongName)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__PRECONDITIONS:
        getPreconditions().clear();
        getPreconditions().addAll((Collection<? extends Condition>)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__POSTCONDITIONS:
        getPostconditions().clear();
        getPostconditions().addAll((Collection<? extends Condition>)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__INITIALIZATIONS:
        getInitializations().clear();
        getInitializations().addAll((Collection<? extends Initialization>)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__START_POINT:
        setStartPoint((String)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__START_POINTS:
        getStartPoints().clear();
        getStartPoints().addAll((Collection<? extends String>)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__END_POINT:
        setEndPoint((String)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__END_POINTS:
        getEndPoints().clear();
        getEndPoints().addAll((Collection<? extends String>)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO:
        setIncludedScenario((ReferenceToScenarioDef)newValue);
        return;
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIOS:
        getIncludedScenarios().clear();
        getIncludedScenarios().addAll((Collection<? extends ReferenceToScenarioDef>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case TurnPackage.SCENARIO_DEF__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TurnPackage.SCENARIO_DEF__LONG_NAME:
        setLongName((LongName)null);
        return;
      case TurnPackage.SCENARIO_DEF__PRECONDITIONS:
        getPreconditions().clear();
        return;
      case TurnPackage.SCENARIO_DEF__POSTCONDITIONS:
        getPostconditions().clear();
        return;
      case TurnPackage.SCENARIO_DEF__INITIALIZATIONS:
        getInitializations().clear();
        return;
      case TurnPackage.SCENARIO_DEF__START_POINT:
        setStartPoint(START_POINT_EDEFAULT);
        return;
      case TurnPackage.SCENARIO_DEF__START_POINTS:
        getStartPoints().clear();
        return;
      case TurnPackage.SCENARIO_DEF__END_POINT:
        setEndPoint(END_POINT_EDEFAULT);
        return;
      case TurnPackage.SCENARIO_DEF__END_POINTS:
        getEndPoints().clear();
        return;
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO:
        setIncludedScenario((ReferenceToScenarioDef)null);
        return;
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIOS:
        getIncludedScenarios().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case TurnPackage.SCENARIO_DEF__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TurnPackage.SCENARIO_DEF__LONG_NAME:
        return longName != null;
      case TurnPackage.SCENARIO_DEF__PRECONDITIONS:
        return preconditions != null && !preconditions.isEmpty();
      case TurnPackage.SCENARIO_DEF__POSTCONDITIONS:
        return postconditions != null && !postconditions.isEmpty();
      case TurnPackage.SCENARIO_DEF__INITIALIZATIONS:
        return initializations != null && !initializations.isEmpty();
      case TurnPackage.SCENARIO_DEF__START_POINT:
        return START_POINT_EDEFAULT == null ? startPoint != null : !START_POINT_EDEFAULT.equals(startPoint);
      case TurnPackage.SCENARIO_DEF__START_POINTS:
        return startPoints != null && !startPoints.isEmpty();
      case TurnPackage.SCENARIO_DEF__END_POINT:
        return END_POINT_EDEFAULT == null ? endPoint != null : !END_POINT_EDEFAULT.equals(endPoint);
      case TurnPackage.SCENARIO_DEF__END_POINTS:
        return endPoints != null && !endPoints.isEmpty();
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIO:
        return includedScenario != null;
      case TurnPackage.SCENARIO_DEF__INCLUDED_SCENARIOS:
        return includedScenarios != null && !includedScenarios.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", startPoint: ");
    result.append(startPoint);
    result.append(", startPoints: ");
    result.append(startPoints);
    result.append(", endPoint: ");
    result.append(endPoint);
    result.append(", endPoints: ");
    result.append(endPoints);
    result.append(')');
    return result.toString();
  }

} //ScenarioDefImpl
