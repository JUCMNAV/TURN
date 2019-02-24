/**
 * generated by Xtext 2.16.0-SNAPSHOT
 */
package org.xtext.project.turn.turn.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.project.turn.turn.IndicatorEvaluation;
import org.xtext.project.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indicator Evaluation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.impl.IndicatorEvaluationImpl#getRealWorldLabel <em>Real World Label</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.IndicatorEvaluationImpl#getRealWorldValue <em>Real World Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndicatorEvaluationImpl extends MinimalEObjectImpl.Container implements IndicatorEvaluation
{
  /**
   * The default value of the '{@link #getRealWorldLabel() <em>Real World Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealWorldLabel()
   * @generated
   * @ordered
   */
  protected static final String REAL_WORLD_LABEL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRealWorldLabel() <em>Real World Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealWorldLabel()
   * @generated
   * @ordered
   */
  protected String realWorldLabel = REAL_WORLD_LABEL_EDEFAULT;

  /**
   * The default value of the '{@link #getRealWorldValue() <em>Real World Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealWorldValue()
   * @generated
   * @ordered
   */
  protected static final int REAL_WORLD_VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getRealWorldValue() <em>Real World Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealWorldValue()
   * @generated
   * @ordered
   */
  protected int realWorldValue = REAL_WORLD_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndicatorEvaluationImpl()
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
    return TurnPackage.Literals.INDICATOR_EVALUATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRealWorldLabel()
  {
    return realWorldLabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRealWorldLabel(String newRealWorldLabel)
  {
    String oldRealWorldLabel = realWorldLabel;
    realWorldLabel = newRealWorldLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_LABEL, oldRealWorldLabel, realWorldLabel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getRealWorldValue()
  {
    return realWorldValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRealWorldValue(int newRealWorldValue)
  {
    int oldRealWorldValue = realWorldValue;
    realWorldValue = newRealWorldValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_VALUE, oldRealWorldValue, realWorldValue));
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
      case TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_LABEL:
        return getRealWorldLabel();
      case TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_VALUE:
        return getRealWorldValue();
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
      case TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_LABEL:
        setRealWorldLabel((String)newValue);
        return;
      case TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_VALUE:
        setRealWorldValue((Integer)newValue);
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
      case TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_LABEL:
        setRealWorldLabel(REAL_WORLD_LABEL_EDEFAULT);
        return;
      case TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_VALUE:
        setRealWorldValue(REAL_WORLD_VALUE_EDEFAULT);
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
      case TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_LABEL:
        return REAL_WORLD_LABEL_EDEFAULT == null ? realWorldLabel != null : !REAL_WORLD_LABEL_EDEFAULT.equals(realWorldLabel);
      case TurnPackage.INDICATOR_EVALUATION__REAL_WORLD_VALUE:
        return realWorldValue != REAL_WORLD_VALUE_EDEFAULT;
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
    result.append(" (realWorldLabel: ");
    result.append(realWorldLabel);
    result.append(", realWorldValue: ");
    result.append(realWorldValue);
    result.append(')');
    return result.toString();
  }

} //IndicatorEvaluationImpl
