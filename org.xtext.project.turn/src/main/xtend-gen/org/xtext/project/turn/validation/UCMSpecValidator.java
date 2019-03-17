package org.xtext.project.turn.validation;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.xtext.project.turn.turn.ScenarioDef;
import org.xtext.project.turn.turn.ScenarioGroup;
import org.xtext.project.turn.turn.TurnPackage;
import org.xtext.project.turn.turn.UCMmap;
import org.xtext.project.turn.turn.URNspec;
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
    for (final ScenarioDef group : _allContentsOfType) {
      {
        if ((((!group.getName().isEmpty()) && Objects.equal(group.getName(), obj.getName())) && (!Objects.equal(group, obj)))) {
          this.error("Scenario definition name must be unique", TurnPackage.Literals.SCENARIO_DEF__NAME);
        }
        if ((((!group.getLongName().getLongname().isEmpty()) && group.getLongName().getLongname().equals(obj.getLongName().getLongname())) && (!Objects.equal(group, obj)))) {
          this.error("Scenario definition longname must be unique", TurnPackage.Literals.SCENARIO_DEF__LONG_NAME);
        }
      }
    }
  }
}
