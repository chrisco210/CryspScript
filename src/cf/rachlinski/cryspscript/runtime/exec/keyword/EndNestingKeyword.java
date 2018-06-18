package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.Control.ScriptEngine;
import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

public abstract class EndNestingKeyword extends Keyword
{
	public EndNestingKeyword(ParameterStack args) throws IllegalMethodTypeException
	{
		super(args);
	}

	/**
	 * Construct a command given arguments
	 * @param args the arguments to supply
	 * @param correctArgs the arguments to
	 * @throws IllegalMethodTypeException if the number of parameters supplied does not match the argument count
	 */
	public EndNestingKeyword(ParameterStack args, TypeStack correctArgs) throws IllegalMethodTypeException
	{
		super(args, correctArgs);
	}

	@Override
	/**
	 * To use: partially override this method, calling super it AFTER your own code
	 */
	public void run()
	{
		decreaseDepth();
	}

	private void decreaseDepth()
	{
		ScriptEngine.env.freeInstanceMap();
		Registers.r3.dec();
	}
}
