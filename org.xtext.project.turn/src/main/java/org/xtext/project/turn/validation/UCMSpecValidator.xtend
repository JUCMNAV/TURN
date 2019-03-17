package org.xtext.project.turn.validation

import org.eclipse.xtext.validation.Check
import org.xtext.project.turn.turn.UCMmap
import org.xtext.project.turn.turn.URNspec
import org.xtext.project.turn.turn.ScenarioGroup
import org.eclipse.xtext.EcoreUtil2
import org.xtext.project.turn.turn.TurnPackage
import org.xtext.project.turn.turn.ScenarioDef

class UCMSpecValidator extends AbstractTurnValidator {
	
	@Check
	def checkMapHasUniqueName(UCMmap obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (UCMmap map : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) {
			//for now checking only for name 
				if(!map.name.empty && map.name == obj.name && map != obj )	
					error("Map name must be unique",TurnPackage.Literals.UC_MMAP__NAME)
				if(!map.longName.longname.empty && map.longName.longname.equals(obj.longName.longname) && map != obj )	
					error("Map longname must be unique",TurnPackage.Literals.UC_MMAP__LONG_NAME);
		}
	}
	
	@Check
	def checkScenarioGroupHasUniqueName(ScenarioGroup obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (ScenarioGroup group : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) { 
				if(!group.name.empty && group.name == obj.name && group != obj )	
					error("Scenario group name must be unique",TurnPackage.Literals.SCENARIO_GROUP__NAME)
				if(!group.longName.longname.empty && group.longName.longname.equals(obj.longName.longname) && group != obj )	
					error("Scenario group longname must be unique",TurnPackage.Literals.SCENARIO_GROUP__LONG_NAME);
		}
	}
	
	@Check
	def checkScenarioDefHasUniqueName(ScenarioDef obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (ScenarioDef group : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) { 
				if(!group.name.empty && group.name == obj.name && group != obj )	
					error("Scenario definition name must be unique",TurnPackage.Literals.SCENARIO_DEF__NAME)
				if(!group.longName.longname.empty && group.longName.longname.equals(obj.longName.longname) && group != obj )	
					error("Scenario definition longname must be unique",TurnPackage.Literals.SCENARIO_DEF__LONG_NAME);
		}
	}
	
}