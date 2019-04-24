/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.project.turn.turn.Path;
import org.xtext.project.turn.turn.PathBody;
import org.xtext.project.turn.turn.StartPoint;
import org.xtext.project.turn.turn.TurnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.impl.PathImpl#getStartPoint <em>Start Point</em>}</li>
 *   <li>{@link org.xtext.project.turn.turn.impl.PathImpl#getPathBody <em>Path Body</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PathImpl extends MinimalEObjectImpl.Container implements Path
{
  /**
   * The cached value of the '{@link #getStartPoint() <em>Start Point</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartPoint()
   * @generated
   * @ordered
   */
  protected StartPoint startPoint;

  /**
   * The cached value of the '{@link #getPathBody() <em>Path Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPathBody()
   * @generated
   * @ordered
   */
  protected PathBody pathBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PathImpl()
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
    return TurnPackage.Literals.PATH;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StartPoint getStartPoint()
  {
    return startPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStartPoint(StartPoint newStartPoint, NotificationChain msgs)
  {
    StartPoint oldStartPoint = startPoint;
    startPoint = newStartPoint;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.PATH__START_POINT, oldStartPoint, newStartPoint);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStartPoint(StartPoint newStartPoint)
  {
    if (newStartPoint != startPoint)
    {
      NotificationChain msgs = null;
      if (startPoint != null)
        msgs = ((InternalEObject)startPoint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.PATH__START_POINT, null, msgs);
      if (newStartPoint != null)
        msgs = ((InternalEObject)newStartPoint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.PATH__START_POINT, null, msgs);
      msgs = basicSetStartPoint(newStartPoint, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.PATH__START_POINT, newStartPoint, newStartPoint));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathBody getPathBody()
  {
    return pathBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPathBody(PathBody newPathBody, NotificationChain msgs)
  {
    PathBody oldPathBody = pathBody;
    pathBody = newPathBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TurnPackage.PATH__PATH_BODY, oldPathBody, newPathBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPathBody(PathBody newPathBody)
  {
    if (newPathBody != pathBody)
    {
      NotificationChain msgs = null;
      if (pathBody != null)
        msgs = ((InternalEObject)pathBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TurnPackage.PATH__PATH_BODY, null, msgs);
      if (newPathBody != null)
        msgs = ((InternalEObject)newPathBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TurnPackage.PATH__PATH_BODY, null, msgs);
      msgs = basicSetPathBody(newPathBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TurnPackage.PATH__PATH_BODY, newPathBody, newPathBody));
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
      case TurnPackage.PATH__START_POINT:
        return basicSetStartPoint(null, msgs);
      case TurnPackage.PATH__PATH_BODY:
        return basicSetPathBody(null, msgs);
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
      case TurnPackage.PATH__START_POINT:
        return getStartPoint();
      case TurnPackage.PATH__PATH_BODY:
        return getPathBody();
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
      case TurnPackage.PATH__START_POINT:
        setStartPoint((StartPoint)newValue);
        return;
      case TurnPackage.PATH__PATH_BODY:
        setPathBody((PathBody)newValue);
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
      case TurnPackage.PATH__START_POINT:
        setStartPoint((StartPoint)null);
        return;
      case TurnPackage.PATH__PATH_BODY:
        setPathBody((PathBody)null);
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
      case TurnPackage.PATH__START_POINT:
        return startPoint != null;
      case TurnPackage.PATH__PATH_BODY:
        return pathBody != null;
    }
    return super.eIsSet(featureID);
  }

} //PathImpl
