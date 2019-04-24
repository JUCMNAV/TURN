/**
 * generated by Xtext 2.14.0
 */
package org.xtext.project.turn.turn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Body Nodes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.project.turn.turn.PathBodyNodes#getPathNodes <em>Path Nodes</em>}</li>
 * </ul>
 *
 * @see org.xtext.project.turn.turn.TurnPackage#getPathBodyNodes()
 * @model
 * @generated
 */
public interface PathBodyNodes extends PathBody
{
  /**
   * Returns the value of the '<em><b>Path Nodes</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.project.turn.turn.PathBodyNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path Nodes</em>' containment reference list.
   * @see org.xtext.project.turn.turn.TurnPackage#getPathBodyNodes_PathNodes()
   * @model containment="true"
   * @generated
   */
  EList<PathBodyNode> getPathNodes();

} // PathBodyNodes
