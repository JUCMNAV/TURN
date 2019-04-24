/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.project.turn.turn.QualToQMapping;
import org.xtext.project.turn.turn.QualitativeLabel;
import org.xtext.project.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qual To QMapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.impl.QualToQMappingImpl#isExceeds <em>Exceeds</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.QualToQMappingImpl#getRealWorldLabel <em>Real World Label</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.QualToQMappingImpl#getQualitativeEvaluation <em>Qualitative Evaluation</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.QualToQMappingImpl#getEvaluation <em>Evaluation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QualToQMappingImpl extends MinimalEObjectImpl.Container implements QualToQMapping
{
  /**
   * The default value of the '{@link #isExceeds() <em>Exceeds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExceeds()
   * @generated
   * @ordered
   */
  protected static final boolean EXCEEDS_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExceeds() <em>Exceeds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExceeds()
   * @generated
   * @ordered
   */
  protected boolean exceeds = EXCEEDS_EDEFAULT;

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
   * The default value of the '{@link #getQualitativeEvaluation() <em>Qualitative Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualitativeEvaluation()
   * @generated
   * @ordered
   */
  protected static final QualitativeLabel QUALITATIVE_EVALUATION_EDEFAULT = QualitativeLabel.DENIED;

  /**
   * The cached value of the '{@link #getQualitativeEvaluation() <em>Qualitative Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualitativeEvaluation()
   * @generated
   * @ordered
   */
  protected QualitativeLabel qualitativeEvaluation = QUALITATIVE_EVALUATION_EDEFAULT;

  /**
   * The default value of the '{@link #getEvaluation() <em>Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluation()
   * @generated
   * @ordered
   */
  protected static final int EVALUATION_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getEvaluation() <em>Evaluation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvaluation()
   * @generated
   * @ordered
   */
  protected int evaluation = EVALUATION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QualToQMappingImpl()
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
    return TurnPackage.Literals.QUAL_TO_QMAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExceeds()
  {
    return exceeds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExceeds(boolean newExceeds)
  {
    boolean oldExceeds = exceeds;
    exceeds = newExceeds;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.QUAL_TO_QMAPPING__EXCEEDS, oldExceeds, exceeds));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.QUAL_TO_QMAPPING__REAL_WORLD_LABEL, oldRealWorldLabel, realWorldLabel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualitativeLabel getQualitativeEvaluation()
  {
    return qualitativeEvaluation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualitativeEvaluation(QualitativeLabel newQualitativeEvaluation)
  {
    QualitativeLabel oldQualitativeEvaluation = qualitativeEvaluation;
    qualitativeEvaluation = newQualitativeEvaluation == null ? QUALITATIVE_EVALUATION_EDEFAULT : newQualitativeEvaluation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.QUAL_TO_QMAPPING__QUALITATIVE_EVALUATION, oldQualitativeEvaluation, qualitativeEvaluation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getEvaluation()
  {
    return evaluation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEvaluation(int newEvaluation)
  {
    int oldEvaluation = evaluation;
    evaluation = newEvaluation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.QUAL_TO_QMAPPING__EVALUATION, oldEvaluation, evaluation));
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
      case TurnPackage.QUAL_TO_QMAPPING__EXCEEDS:
        return isExceeds();
      case TurnPackage.QUAL_TO_QMAPPING__REAL_WORLD_LABEL:
        return getRealWorldLabel();
      case TurnPackage.QUAL_TO_QMAPPING__QUALITATIVE_EVALUATION:
        return getQualitativeEvaluation();
      case TurnPackage.QUAL_TO_QMAPPING__EVALUATION:
        return getEvaluation();
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
      case TurnPackage.QUAL_TO_QMAPPING__EXCEEDS:
        setExceeds((Boolean)newValue);
        return;
      case TurnPackage.QUAL_TO_QMAPPING__REAL_WORLD_LABEL:
        setRealWorldLabel((String)newValue);
        return;
      case TurnPackage.QUAL_TO_QMAPPING__QUALITATIVE_EVALUATION:
        setQualitativeEvaluation((QualitativeLabel)newValue);
        return;
      case TurnPackage.QUAL_TO_QMAPPING__EVALUATION:
        setEvaluation((Integer)newValue);
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
      case TurnPackage.QUAL_TO_QMAPPING__EXCEEDS:
        setExceeds(EXCEEDS_EDEFAULT);
        return;
      case TurnPackage.QUAL_TO_QMAPPING__REAL_WORLD_LABEL:
        setRealWorldLabel(REAL_WORLD_LABEL_EDEFAULT);
        return;
      case TurnPackage.QUAL_TO_QMAPPING__QUALITATIVE_EVALUATION:
        setQualitativeEvaluation(QUALITATIVE_EVALUATION_EDEFAULT);
        return;
      case TurnPackage.QUAL_TO_QMAPPING__EVALUATION:
        setEvaluation(EVALUATION_EDEFAULT);
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
      case TurnPackage.QUAL_TO_QMAPPING__EXCEEDS:
        return exceeds != EXCEEDS_EDEFAULT;
      case TurnPackage.QUAL_TO_QMAPPING__REAL_WORLD_LABEL:
        return REAL_WORLD_LABEL_EDEFAULT == null ? realWorldLabel != null : !REAL_WORLD_LABEL_EDEFAULT.equals(realWorldLabel);
      case TurnPackage.QUAL_TO_QMAPPING__QUALITATIVE_EVALUATION:
        return qualitativeEvaluation != QUALITATIVE_EVALUATION_EDEFAULT;
      case TurnPackage.QUAL_TO_QMAPPING__EVALUATION:
        return evaluation != EVALUATION_EDEFAULT;
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
    result.append(" (exceeds: ");
    result.append(exceeds);
    result.append(", realWorldLabel: ");
    result.append(realWorldLabel);
    result.append(", qualitativeEvaluation: ");
    result.append(qualitativeEvaluation);
    result.append(", evaluation: ");
    result.append(evaluation);
    result.append(')');
    return result.toString();
  }

} //QualToQMappingImpl
