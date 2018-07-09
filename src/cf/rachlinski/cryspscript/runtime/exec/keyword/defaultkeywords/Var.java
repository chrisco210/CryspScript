package cf.rachlinski.cryspscript.runtime.exec.keyword.defaultkeywords;

import cf.rachlinski.cryspscript.control.ScriptEngine;
import cf.rachlinski.cryspscript.control.factories.ExecutionEnvironmentFactory;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Keyword;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Runnable;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

@Runnable("var")
public class Var extends Keyword
{
	private static final TypeStack EXPECTED_TYPES = new TypeStack(new Class<?>[] {String.class, Object.class, });

	public Var(ParameterStack args) throws IllegalMethodTypeException
	{
		super(args);
	}

	@Override
	public void run()
	{
		ExecutionEnvironmentFactory.getProvide().putVariable(((String) args.get(0).getValue()).trim(), args.get(1));
	}
}
