/**
 * generated by Xtext 2.12.0
 */
package org.xtext.project.turn.turn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.project.turn.turn.AndFork;
import org.xtext.project.turn.turn.LongName;
import org.xtext.project.turn.turn.PathBody;
import org.xtext.project.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Fork</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.impl.AndForkImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.AndForkImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.AndForkImpl#getPathbody <em>Pathbody</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.AndForkImpl#getConnectingAndBody <em>Connecting And Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AndForkImpl extends URNmodelElementImpl implements AndFork
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
   * The cached value of the '{@link #getPathbody() <em>Pathbody</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPathbody()
   * @generated
   * @ordered
   */
  protected EList<PathBody> pathbody;

  /**
   * The cached value of the '{@link #getConnectingAndBody() <em>Connecting And Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectingAndBody()
   * @generated
   * @ordered
   */
  protected PathBody connectingAndBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AndForkImpl()
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
    return TurnPackage.Literals.AND_FORK;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.AND_FORK__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.AND_FORK__LONG_NAME, oldLongName, newLongName);
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
        msgs = ((InternalEObject)longName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.AND_FORK__LONG_NAME, null, msgs);
      if (newLongName != null)
        msgs = ((InternalEObject)newLongName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.AND_FORK__LONG_NAME, null, msgs);
      msgs = basicSetLongName(newLongName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.AND_FORK__LONG_NAME, newLongName, newLongName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PathBody> getPathbody()
  {
    if (pathbody == null)
    {
      pathbody = new EObjectContainmentEList<PathBody>(PathBody.class, this, TurnPackage.AND_FORK__PATHBODY);
    }
    return pathbody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathBody getConnectingAndBody()
  {
    return connectingAndBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConnectingAndBody(PathBody newConnectingAndBody, NotificationChain msgs)
  {
    PathBody oldConnectingAndBody = connectingAndBody;
    connectingAndBody = newConnectingAndBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.AND_FORK__CONNECTING_AND_BODY, oldConnectingAndBody, newConnectingAndBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConnectingAndBody(PathBody newConnectingAndBody)
  {
    if (newConnectingAndBody != connectingAndBody)
    {
      NotificationChain msgs = null;
      if (connectingAndBody != null)
        msgs = ((InternalEObject)connectingAndBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.AND_FORK__CONNECTING_AND_BODY, null, msgs);
      if (newConnectingAndBody != null)
        msgs = ((InternalEObject)newConnectingAndBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.AND_FORK__CONNECTING_AND_BODY, null, msgs);
      msgs = basicSetConnectingAndBody(newConnectingAndBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.AND_FORK__CONNECTING_AND_BODY, newConnectingAndBody, newConnectingAndBody));
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
      case TurnPackage.AND_FORK__LONG_NAME:
        return basicSetLongName(null, msgs);
      case TurnPackage.AND_FORK__PATHBODY:
        return ((InternalEList<?>)getPathbody()).basicRemove(otherEnd, msgs);
      case TurnPackage.AND_FORK__CONNECTING_AND_BODY:
        return basicSetConnectingAndBody(null, msgs);
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
      case TurnPackage.AND_FORK__NAME:
        return getName();
      case TurnPackage.AND_FORK__LONG_NAME:
        return getLongName();
      case TurnPackage.AND_FORK__PATHBODY:
        return getPathbody();
      case TurnPackage.AND_FORK__CONNECTING_AND_BODY:
        return getConnectingAndBody();
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
      case TurnPackage.AND_FORK__NAME:
        setName((String)newValue);
        return;
      case TurnPackage.AND_FORK__LONG_NAME:
        setLongName((LongName)newValue);
        return;
      case TurnPackage.AND_FORK__PATHBODY:
        getPathbody().clear();
        getPathbody().addAll((Collection<? extends PathBody>)newValue);
        return;
      case TurnPackage.AND_FORK__CONNECTING_AND_BODY:
        setConnectingAndBody((PathBody)newValue);
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
      case TurnPackage.AND_FORK__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TurnPackage.AND_FORK__LONG_NAME:
        setLongName((LongName)null);
        return;
      case TurnPackage.AND_FORK__PATHBODY:
        getPathbody().clear();
        return;
      case TurnPackage.AND_FORK__CONNECTING_AND_BODY:
        setConnectingAndBody((PathBody)null);
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
      case TurnPackage.AND_FORK__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TurnPackage.AND_FORK__LONG_NAME:
        return longName != null;
      case TurnPackage.AND_FORK__PATHBODY:
        return pathbody != null && !pathbody.isEmpty();
      case TurnPackage.AND_FORK__CONNECTING_AND_BODY:
        return connectingAndBody != null;
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
    result.append(')');
    return result.toString();
  }

} //AndForkImpl