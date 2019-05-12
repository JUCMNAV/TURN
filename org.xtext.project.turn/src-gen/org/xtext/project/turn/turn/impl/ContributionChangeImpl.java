/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.project.turn.turn.Contribution;
import org.xtext.project.turn.turn.ContributionChange;
import org.xtext.project.turn.turn.ContributionType;
import org.xtext.project.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contribution Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.impl.ContributionChangeImpl#getContribution <em>Contribution</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ContributionChangeImpl#getNewContribution <em>New Contribution</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.ContributionChangeImpl#getNewQuantitativeContribution <em>New Quantitative Contribution</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContributionChangeImpl extends MinimalEObjectImpl.Container implements ContributionChange
{
  /**
   * The cached value of the '{@link #getContribution() <em>Contribution</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContribution()
   * @generated
   * @ordered
   */
  protected Contribution contribution;

  /**
   * The default value of the '{@link #getNewContribution() <em>New Contribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewContribution()
   * @generated
   * @ordered
   */
  protected static final ContributionType NEW_CONTRIBUTION_EDEFAULT = ContributionType.MAKE;

  /**
   * The cached value of the '{@link #getNewContribution() <em>New Contribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewContribution()
   * @generated
   * @ordered
   */
  protected ContributionType newContribution = NEW_CONTRIBUTION_EDEFAULT;

  /**
   * The default value of the '{@link #getNewQuantitativeContribution() <em>New Quantitative Contribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewQuantitativeContribution()
   * @generated
   * @ordered
   */
  protected static final int NEW_QUANTITATIVE_CONTRIBUTION_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getNewQuantitativeContribution() <em>New Quantitative Contribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNewQuantitativeContribution()
   * @generated
   * @ordered
   */
  protected int newQuantitativeContribution = NEW_QUANTITATIVE_CONTRIBUTION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContributionChangeImpl()
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
    return TurnPackage.Literals.CONTRIBUTION_CHANGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contribution getContribution()
  {
    if (contribution != null && contribution.eIsProxy())
    {
      InternalEObject oldContribution = (InternalEObject)contribution;
      contribution = (Contribution)eResolveProxy(oldContribution);
      if (contribution != oldContribution)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TurnPackage.CONTRIBUTION_CHANGE__CONTRIBUTION, oldContribution, contribution));
      }
    }
    return contribution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contribution basicGetContribution()
  {
    return contribution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContribution(Contribution newContribution)
  {
    Contribution oldContribution = contribution;
    contribution = newContribution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.CONTRIBUTION_CHANGE__CONTRIBUTION, oldContribution, contribution));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContributionType getNewContribution()
  {
    return newContribution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewContribution(ContributionType newNewContribution)
  {
    ContributionType oldNewContribution = newContribution;
    newContribution = newNewContribution == null ? NEW_CONTRIBUTION_EDEFAULT : newNewContribution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.CONTRIBUTION_CHANGE__NEW_CONTRIBUTION, oldNewContribution, newContribution));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getNewQuantitativeContribution()
  {
    return newQuantitativeContribution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNewQuantitativeContribution(int newNewQuantitativeContribution)
  {
    int oldNewQuantitativeContribution = newQuantitativeContribution;
    newQuantitativeContribution = newNewQuantitativeContribution;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.CONTRIBUTION_CHANGE__NEW_QUANTITATIVE_CONTRIBUTION, oldNewQuantitativeContribution, newQuantitativeContribution));
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
      case TurnPackage.CONTRIBUTION_CHANGE__CONTRIBUTION:
        if (resolve) return getContribution();
        return basicGetContribution();
      case TurnPackage.CONTRIBUTION_CHANGE__NEW_CONTRIBUTION:
        return getNewContribution();
      case TurnPackage.CONTRIBUTION_CHANGE__NEW_QUANTITATIVE_CONTRIBUTION:
        return getNewQuantitativeContribution();
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
      case TurnPackage.CONTRIBUTION_CHANGE__CONTRIBUTION:
        setContribution((Contribution)newValue);
        return;
      case TurnPackage.CONTRIBUTION_CHANGE__NEW_CONTRIBUTION:
        setNewContribution((ContributionType)newValue);
        return;
      case TurnPackage.CONTRIBUTION_CHANGE__NEW_QUANTITATIVE_CONTRIBUTION:
        setNewQuantitativeContribution((Integer)newValue);
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
      case TurnPackage.CONTRIBUTION_CHANGE__CONTRIBUTION:
        setContribution((Contribution)null);
        return;
      case TurnPackage.CONTRIBUTION_CHANGE__NEW_CONTRIBUTION:
        setNewContribution(NEW_CONTRIBUTION_EDEFAULT);
        return;
      case TurnPackage.CONTRIBUTION_CHANGE__NEW_QUANTITATIVE_CONTRIBUTION:
        setNewQuantitativeContribution(NEW_QUANTITATIVE_CONTRIBUTION_EDEFAULT);
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
      case TurnPackage.CONTRIBUTION_CHANGE__CONTRIBUTION:
        return contribution != null;
      case TurnPackage.CONTRIBUTION_CHANGE__NEW_CONTRIBUTION:
        return newContribution != NEW_CONTRIBUTION_EDEFAULT;
      case TurnPackage.CONTRIBUTION_CHANGE__NEW_QUANTITATIVE_CONTRIBUTION:
        return newQuantitativeContribution != NEW_QUANTITATIVE_CONTRIBUTION_EDEFAULT;
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
    result.append(" (newContribution: ");
    result.append(newContribution);
    result.append(", newQuantitativeContribution: ");
    result.append(newQuantitativeContribution);
    result.append(')');
    return result.toString();
  }

} //ContributionChangeImpl
