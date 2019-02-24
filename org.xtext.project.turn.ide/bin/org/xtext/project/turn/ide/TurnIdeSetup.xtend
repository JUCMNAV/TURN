/*
 * generated by Xtext 2.12.0
 */
package org.xtext.project.turn.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.xtext.project.turn.TurnRuntimeModule
import org.xtext.project.turn.TurnStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class TurnIdeSetup extends TurnStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new TurnRuntimeModule, new TurnIdeModule))
	}
	
}
