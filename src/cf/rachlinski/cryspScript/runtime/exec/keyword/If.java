package cf.rachlinski.cryspScript.runtime.exec.keyword;

import cf.rachlinski.cryspScript.Control.ScriptEngine;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspScript.runtime.exec.method.IllegalMethodTypeException;

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
		if(!args.get(0).equals(Variable.ONE))
		{
			ScriptEngine.env.executionStack.getNextOccNest("fi").jumpTo();
		}

	}
}
