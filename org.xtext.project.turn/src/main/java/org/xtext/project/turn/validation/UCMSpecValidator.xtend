package org.xtext.project.turn.validation

import org.eclipse.xtext.validation.Check
import org.xtext.project.turn.turn.UCMmap
import org.xtext.project.turn.turn.URNspec
import org.xtext.project.turn.turn.ScenarioGroup
import org.eclipse.xtext.EcoreUtil2
import org.xtext.project.turn.turn.TurnPackage
import org.xtext.project.turn.turn.ScenarioDef
import org.xtext.project.turn.turn.Initialization
import org.xtext.project.turn.turn.Variable

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
		for (ScenarioDef definition : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) { 
				if(!definition.name.empty && definition.name == obj.name && definition != obj )	
					error("Scenario definition name must be unique",TurnPackage.Literals.SCENARIO_DEF__NAME)
				if(!definition.longName.longname.empty && definition.longName.longname.equals(obj.longName.longname) && definition != obj )	
					error("Scenario definition longname must be unique",TurnPackage.Literals.SCENARIO_DEF__LONG_NAME);
		}
	}
	
	@Check
	def checkVariableHasUniqueName(Variable obj) {
		val spec=EcoreUtil2.getContainerOfType(obj,URNspec)
		for (Variable variable : EcoreUtil2.getAllContentsOfType(spec, obj.getClass())) { 
				if(!variable.name.empty && variable.name == obj.name && !variable.equals(obj) )	
					error("Variable name must be unique",TurnPackage.Literals.VARIABLE__NAME)
		}
	}
	
	@Check
	def checkVariableHasUniqueInitialization(Initialization obj) {
		val scenariodef = EcoreUtil2.getContainerOfType(obj, ScenarioDef)
		for (Initialization init : scenariodef.initializations) { 
				if(!init.variable.equals(null) && init.variable.equals(obj.variable) && !init.equals(obj) )	
					error("Variable already initialized in scenario definition",TurnPackage.Literals.INITIALIZATION__VARIABLE)
		}
	}
	
	@Check
	def checkEnumLiteralInitializationValue(Initialization obj) {
		val literal = obj.value
		val enumType = obj.variable.enumerationType
		if(!enumType.values.contains(literal))
			error("Enum literal does not exist in variable's enumeration type",TurnPackage.Literals.INITIALIZATION__VALUE)
	}
	
}