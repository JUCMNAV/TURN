package org.xtext.project.turn.validation;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.xtext.project.turn.turn.EnumerationType;
import org.xtext.project.turn.turn.Initialization;
import org.xtext.project.turn.turn.ScenarioDef;
import org.xtext.project.turn.turn.ScenarioGroup;
import org.xtext.project.turn.turn.TurnPackage;
import org.xtext.project.turn.turn.UCMmap;
import org.xtext.project.turn.turn.URNspec;
import org.xtext.project.turn.turn.Variable;
import org.xtext.project.turn.validation.AbstractTurnValidator;

@SuppressWarnings("all")
public class UCMSpecValidator extends AbstractTurnValidator {
  @Check
  public void checkMapHasUniqueName(final UCMmap obj) {
    final URNspec spec = EcoreUtil2.<URNspec>getContainerOfType(obj, URNspec.class);
    List<? extends UCMmap> _allContentsOfType = EcoreUtil2.getAllContentsOfType(spec, obj.getClass());
    for (final UCMmap map : _allContentsOfType) {
      {
        if ((((!map.getName().isEmpty()) && Objects.equal(map.getName(), obj.getName())) && (!Objects.equal(map, obj)))) {
          this.error("Map name must be unique", TurnPackage.Literals.UC_MMAP__NAME);
        }
        if ((((!map.getLongName().getLongname().isEmpty()) && map.getLongName().getLongname().equals(obj.getLongName().getLongname())) && (!Objects.equal(map, obj)))) {
          this.error("Map longname must be unique", TurnPackage.Literals.UC_MMAP__LONG_NAME);
        }
      }
    }
  }
  
  @Check
  public void checkScenarioGroupHasUniqueName(final ScenarioGroup obj) {
    final URNspec spec = EcoreUtil2.<URNspec>getContainerOfType(obj, URNspec.class);
    List<? extends ScenarioGroup> _allContentsOfType = EcoreUtil2.getAllContentsOfType(spec, obj.getClass());
    for (final ScenarioGroup group : _allContentsOfType) {
      {
        if ((((!group.getName().isEmpty()) && Objects.equal(group.getName(), obj.getName())) && (!Objects.equal(group, obj)))) {
          this.error("Scenario group name must be unique", TurnPackage.Literals.SCENARIO_GROUP__NAME);
        }
        if ((((!group.getLongName().getLongname().isEmpty()) && group.getLongName().getLongname().equals(obj.getLongName().getLongname())) && (!Objects.equal(group, obj)))) {
          this.error("Scenario group longname must be unique", TurnPackage.Literals.SCENARIO_GROUP__LONG_NAME);
        }
      }
    }
  }
  
  @Check
  public void checkScenarioDefHasUniqueName(final ScenarioDef obj) {
    final URNspec spec = EcoreUtil2.<URNspec>getContainerOfType(obj, URNspec.class);
    List<? extends ScenarioDef> _allContentsOfType = EcoreUtil2.getAllContentsOfType(spec, obj.getClass());
    for (final ScenarioDef definition : _allContentsOfType) {
      {
        if ((((!definition.getName().isEmpty()) && Objects.equal(definition.getName(), obj.getName())) && (!Objects.equal(definition, obj)))) {
          this.error("Scenario definition name must be unique", TurnPackage.Literals.SCENARIO_DEF__NAME);
        }
        if ((((!definition.getLongName().getLongname().isEmpty()) && definition.getLongName().getLongname().equals(obj.getLongName().getLongname())) && (!Objects.equal(definition, obj)))) {
          this.error("Scenario definition longname must be unique", TurnPackage.Literals.SCENARIO_DEF__LONG_NAME);
        }
      }
    }
  }
  
  @Check
  public void checkVariableHasUniqueName(final Variable obj) {
    final URNspec spec = EcoreUtil2.<URNspec>getContainerOfType(obj, URNspec.class);
    List<? extends Variable> _allContentsOfType = EcoreUtil2.getAllContentsOfType(spec, obj.getClass());
    for (final Variable variable : _allContentsOfType) {
      if ((((!variable.getName().isEmpty()) && Objects.equal(variable.getName(), obj.getName())) && (!variable.equals(obj)))) {
        this.error("Variable name must be unique", TurnPackage.Literals.VARIABLE__NAME);
      }
    }
  }
  
  @Check
  public void checkVariableHasUniqueInitialization(final Initialization obj) {
    final ScenarioDef scenariodef = EcoreUtil2.<ScenarioDef>getContainerOfType(obj, ScenarioDef.class);
    EList<Initialization> _initializations = scenariodef.getInitializations();
    for (final Initialization init : _initializations) {
      if ((((!init.getVariable().equals(null)) && init.getVariable().equals(obj.getVariable())) && (!init.equals(obj)))) {
        this.error("Variable already initialized in scenario definition", TurnPackage.Literals.INITIALIZATION__VARIABLE);
      }
    }
  }
  
  @Check
  public void checkEnumLiteralInitializationValue(final Initialization obj) {
    final String literal = obj.getValue();
    final EnumerationType enumType = obj.getVariable().getEnumerationType();
    boolean _contains = enumType.getValues().contains(literal);
    boolean _not = (!_contains);
    if (_not) {
      this.error("Enum literal does not exist in variable\'s enumeration type", TurnPackage.Literals.INITIALIZATION__VALUE);
    }
  }
}
