package cf.rachlinski.cryspScript.runtime.exec.keyword;

import cf.rachlinski.cryspScript.Control.ScriptEngine;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;

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
		if(!args.get(0).equals(Variable.ONE));
		{
			ScriptEngine.env.executionStack.getNextOccNest("endw").jumpTo();	//TODO
		}
	}
}
