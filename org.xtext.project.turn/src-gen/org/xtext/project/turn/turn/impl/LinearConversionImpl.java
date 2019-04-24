/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.xtext.project.turn.turn.LinearConversion;
import org.xtext.project.turn.turn.LongName;
import org.xtext.project.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linear Conversion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.impl.LinearConversionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.LinearConversionImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.LinearConversionImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.LinearConversionImpl#getTargetValue <em>Target Value</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.LinearConversionImpl#getThresholdValue <em>Threshold Value</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.LinearConversionImpl#getWorstValue <em>Worst Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LinearConversionImpl extends URNmodelElementImpl implements LinearConversion
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
   * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected static final String UNIT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected String unit = UNIT_EDEFAULT;

  /**
   * The default value of the '{@link #getTargetValue() <em>Target Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetValue()
   * @generated
   * @ordered
   */
  protected static final int TARGET_VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getTargetValue() <em>Target Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetValue()
   * @generated
   * @ordered
   */
  protected int targetValue = TARGET_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getThresholdValue() <em>Threshold Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThresholdValue()
   * @generated
   * @ordered
   */
  protected static final int THRESHOLD_VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getThresholdValue() <em>Threshold Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThresholdValue()
   * @generated
   * @ordered
   */
  protected int thresholdValue = THRESHOLD_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getWorstValue() <em>Worst Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorstValue()
   * @generated
   * @ordered
   */
  protected static final int WORST_VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getWorstValue() <em>Worst Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWorstValue()
   * @generated
   * @ordered
   */
  protected int worstValue = WORST_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinearConversionImpl()
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
    return TurnPackage.Literals.LINEAR_CONVERSION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.LINEAR_CONVERSION__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.LINEAR_CONVERSION__LONG_NAME, oldLongName, newLongName);
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
        msgs = ((InternalEObject)longName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.LINEAR_CONVERSION__LONG_NAME, null, msgs);
      if (newLongName != null)
        msgs = ((InternalEObject)newLongName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.LINEAR_CONVERSION__LONG_NAME, null, msgs);
      msgs = basicSetLongName(newLongName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.LINEAR_CONVERSION__LONG_NAME, newLongName, newLongName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUnit()
  {
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnit(String newUnit)
  {
    String oldUnit = unit;
    unit = newUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.LINEAR_CONVERSION__UNIT, oldUnit, unit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getTargetValue()
  {
    return targetValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetValue(int newTargetValue)
  {
    int oldTargetValue = targetValue;
    targetValue = newTargetValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.LINEAR_CONVERSION__TARGET_VALUE, oldTargetValue, targetValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getThresholdValue()
  {
    return thresholdValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThresholdValue(int newThresholdValue)
  {
    int oldThresholdValue = thresholdValue;
    thresholdValue = newThresholdValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.LINEAR_CONVERSION__THRESHOLD_VALUE, oldThresholdValue, thresholdValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getWorstValue()
  {
    return worstValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWorstValue(int newWorstValue)
  {
    int oldWorstValue = worstValue;
    worstValue = newWorstValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.LINEAR_CONVERSION__WORST_VALUE, oldWorstValue, worstValue));
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
      case TurnPackage.LINEAR_CONVERSION__LONG_NAME:
        return basicSetLongName(null, msgs);
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
      case TurnPackage.LINEAR_CONVERSION__NAME:
        return getName();
      case TurnPackage.LINEAR_CONVERSION__LONG_NAME:
        return getLongName();
      case TurnPackage.LINEAR_CONVERSION__UNIT:
        return getUnit();
      case TurnPackage.LINEAR_CONVERSION__TARGET_VALUE:
        return getTargetValue();
      case TurnPackage.LINEAR_CONVERSION__THRESHOLD_VALUE:
        return getThresholdValue();
      case TurnPackage.LINEAR_CONVERSION__WORST_VALUE:
        return getWorstValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case TurnPackage.LINEAR_CONVERSION__NAME:
        setName((String)newValue);
        return;
      case TurnPackage.LINEAR_CONVERSION__LONG_NAME:
        setLongName((LongName)newValue);
        return;
      case TurnPackage.LINEAR_CONVERSION__UNIT:
        setUnit((String)newValue);
        return;
      case TurnPackage.LINEAR_CONVERSION__TARGET_VALUE:
        setTargetValue((Integer)newValue);
        return;
      case TurnPackage.LINEAR_CONVERSION__THRESHOLD_VALUE:
        setThresholdValue((Integer)newValue);
        return;
      case TurnPackage.LINEAR_CONVERSION__WORST_VALUE:
        setWorstValue((Integer)newValue);
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
      case TurnPackage.LINEAR_CONVERSION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TurnPackage.LINEAR_CONVERSION__LONG_NAME:
        setLongName((LongName)null);
        return;
      case TurnPackage.LINEAR_CONVERSION__UNIT:
        setUnit(UNIT_EDEFAULT);
        return;
      case TurnPackage.LINEAR_CONVERSION__TARGET_VALUE:
        setTargetValue(TARGET_VALUE_EDEFAULT);
        return;
      case TurnPackage.LINEAR_CONVERSION__THRESHOLD_VALUE:
        setThresholdValue(THRESHOLD_VALUE_EDEFAULT);
        return;
      case TurnPackage.LINEAR_CONVERSION__WORST_VALUE:
        setWorstValue(WORST_VALUE_EDEFAULT);
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
      case TurnPackage.LINEAR_CONVERSION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TurnPackage.LINEAR_CONVERSION__LONG_NAME:
        return longName != null;
      case TurnPackage.LINEAR_CONVERSION__UNIT:
        return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT.equals(unit);
      case TurnPackage.LINEAR_CONVERSION__TARGET_VALUE:
        return targetValue != TARGET_VALUE_EDEFAULT;
      case TurnPackage.LINEAR_CONVERSION__THRESHOLD_VALUE:
        return thresholdValue != THRESHOLD_VALUE_EDEFAULT;
      case TurnPackage.LINEAR_CONVERSION__WORST_VALUE:
        return worstValue != WORST_VALUE_EDEFAULT;
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", unit: ");
    result.append(unit);
    result.append(", targetValue: ");
    result.append(targetValue);
    result.append(", thresholdValue: ");
    result.append(thresholdValue);
    result.append(", worstValue: ");
    result.append(worstValue);
    result.append(')');
    return result.toString();
  }

} //LinearConversionImpl
