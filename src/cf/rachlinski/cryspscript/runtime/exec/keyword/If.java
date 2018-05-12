package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.Control.ScriptEngine;
import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.map.InstanceVariableMap;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

public class If extends Keyword
{

	private static final TypeStack EXPECTED_TYPES = new TypeStack(new Class<?>[] {Integer.class});

	/**
	 * Construct a command given arguments
	 *
	 * @param args        the arguments to supply
	 * @throws IllegalMethodTypeException if the number of parameters supplied does not match the argument count
	 */
	public If(ParameterStack args) throws IllegalMethodTypeException
	{
		super(args, EXPECTED_TYPES);
	}

	@Override
	public void run()
	{
		//Add nesting variable contents to the variable maps
		ScriptEngine.env.createInstanceVarMap(new InstanceVariableMap());

		//Increment nesting depth
		Registers.r3.inc();

		if(!args.get(0).equals(Variable.ONE))
		{
			ScriptEngine.env.executionStack.getNextOccNest("fi").jumpTo();
		}

	}
}
