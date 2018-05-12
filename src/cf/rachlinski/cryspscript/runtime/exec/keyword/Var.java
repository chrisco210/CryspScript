package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.Control.ScriptEngine;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

public class Var extends Keyword
{
	private static final TypeStack EXPECTED_TYPES = new TypeStack(new Class<?>[] {String.class, Object.class, });

	public Var(ParameterStack args) throws IllegalMethodTypeException
	{
		super(args, EXPECTED_TYPES);
	}

	@Override
	public void run()
	{
		ScriptEngine.env.putVariable((String) args.get(0).getValue(), args.get(1));
	}
}
