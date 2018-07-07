package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.control.ScriptEngine;
import cf.rachlinski.cryspscript.control.factories.ExecutionEnvironmentFactory;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

public class If extends NestingKeyword
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
		super.run();

		if(!args.get(0).equals(Variable.ONE))
		{
			ExecutionEnvironmentFactory.getProvide().getExecutionStack().getNextOccNest("fi").jumpTo();
		}

	}
}
