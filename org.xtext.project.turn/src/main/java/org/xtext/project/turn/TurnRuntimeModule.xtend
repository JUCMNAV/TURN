/*
 * generated by Xtext 2.10.0
 */
package org.xtext.project.turn


/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class TurnRuntimeModule extends AbstractTurnRuntimeModule {
	
	override bindIQualifiedNameProvider() {
		MyQNP
	}
	override bindIValueConverterService() {
		CommonValueConverter
	}
}
