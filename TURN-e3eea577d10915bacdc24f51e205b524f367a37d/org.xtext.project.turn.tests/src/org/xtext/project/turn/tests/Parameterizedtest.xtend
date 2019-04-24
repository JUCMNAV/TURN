package org.xtext.project.turn.tests

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.util.EmfFormatter
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.model.InitializationError
import org.junit.runners.parameterized.ParametersRunnerFactory
import org.junit.runners.parameterized.TestWithParameters
import org.xtext.project.turn.turn.URNspec
import org.junit.runners.Parameterized



@RunWith(typeof(Parameterized))
@InjectWith(TurnInjectorProvider)
@Parameterized.UseParametersRunnerFactory(XtextParametersRunnerFactory)
class Parameterizedtest {

	@Parameterized.Parameters
	def static Iterable<Integer> data() {
		return #[1, 2, 3]
	}

	val int i=0;

	@Inject
	ParseHelper<URNspec> parseHelper

	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext_«i»!
		''')
		println(EmfFormatter.objToStr(result))
	}

}

class XtextParametersRunnerFactory implements ParametersRunnerFactory {

	override createRunnerForTestWithParameters(TestWithParameters test) throws InitializationError {
		new ParameterizedXtextRunner(test)
	}

}

class ParameterizedXtextRunner extends XtextRunner {

	val Object[] parameters

	new(TestWithParameters test) throws InitializationError {
		super(test.testClass.javaClass)
		parameters = test.parameters
	}

	override protected createTest() throws Exception {
		val object = testClass.onlyConstructor.newInstance(parameters)
		val injectorProvider = getOrCreateInjectorProvider
		if (injectorProvider != null) {
			val injector = injectorProvider.injector
			if (injector != null)
				injector.injectMembers(object)
		}
		return object
	}

	override protected void validateConstructor(List<Throwable> errors) {
		validateOnlyOneConstructor(errors)
	}

}
	
