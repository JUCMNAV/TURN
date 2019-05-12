/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.project.turn.turn.FeatureXORDecomposition;
import org.xtext.project.turn.turn.TurnPackage;
import org.xtext.project.turn.turn.XORDecomposedFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XOR Decomposed Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.impl.XORDecomposedFeatureImpl#getLinksSrc <em>Links Src</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XORDecomposedFeatureImpl extends DecomposedFeatureImpl implements XORDecomposedFeature
{
  /**
   * The cached value of the '{@link #getLinksSrc() <em>Links Src</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLinksSrc()
   * @generated
   * @ordered
   */
  protected EList<FeatureXORDecomposition> linksSrc;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XORDecomposedFeatureImpl()
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
    return TurnPackage.Literals.XOR_DECOMPOSED_FEATURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<FeatureXORDecomposition> getLinksSrc()
  {
    if (linksSrc == null)
    {
      linksSrc = new EObjectContainmentEList<FeatureXORDecomposition>(FeatureXORDecomposition.class, this, TurnPackage.XOR_DECOMPOSED_FEATURE__LINKS_SRC);
    }
    return linksSrc;
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
      case TurnPackage.XOR_DECOMPOSED_FEATURE__LINKS_SRC:
        return ((InternalEList<?>)getLinksSrc()).basicRemove(otherEnd, msgs);
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
      case TurnPackage.XOR_DECOMPOSED_FEATURE__LINKS_SRC:
        return getLinksSrc();
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
      case TurnPackage.XOR_DECOMPOSED_FEATURE__LINKS_SRC:
        getLinksSrc().clear();
        getLinksSrc().addAll((Collection<? extends FeatureXORDecomposition>)newValue);
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
      case TurnPackage.XOR_DECOMPOSED_FEATURE__LINKS_SRC:
        getLinksSrc().clear();
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
      case TurnPackage.XOR_DECOMPOSED_FEATURE__LINKS_SRC:
        return linksSrc != null && !linksSrc.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //XORDecomposedFeatureImpl
