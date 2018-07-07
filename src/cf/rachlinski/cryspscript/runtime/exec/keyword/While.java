package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.control.ScriptEngine;
import cf.rachlinski.cryspscript.control.factories.ExecutionEnvironmentFactory;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;

public class While extends Keyword
{
	private static final TypeStack EXPECTED_TYPES = new TypeStack(new Class<?>[] {Integer.class});


	public While(ParameterStack args)
	{
		super(args, EXPECTED_TYPES);
	}

	@Override
	public void run()
	{
		if(!args.get(0).equals(Variable.ONE))
		{
			ExecutionEnvironmentFactory.getProvide().getExecutionStack().getNextOccNest("endw").jumpTo();
		}
	}
}
