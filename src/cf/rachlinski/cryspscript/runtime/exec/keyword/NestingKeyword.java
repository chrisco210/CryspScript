package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.control.ScriptEngine;
import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

import java.util.HashMap;

public abstract class NestingKeyword extends Keyword
{

	public NestingKeyword(ParameterStack args) throws IllegalMethodTypeException
	{
		super(args);
	}

	/**
	 * Construct a command given arguments
	 * @param args the arguments to supply
	 * @param correctArgs the arguments to
	 * @throws IllegalMethodTypeException if the number of parameters supplied does not match the argument count
	 */
	public NestingKeyword(ParameterStack args, TypeStack correctArgs) throws IllegalMethodTypeException
	{
		super(args, correctArgs);
	}

	/**
	 * To use this method: partially override it, calling super BEFORE your code
	 */
	@Override
	public void run()
	{
		increaseDepth();
	}

	private void increaseDepth()
	{
		//Add nesting variable contents to the variable maps
		ScriptEngine.env.createInstanceVarMap(new HashMap<>());

		//Increment nesting depth
		Registers.r3.inc();
	}
}
