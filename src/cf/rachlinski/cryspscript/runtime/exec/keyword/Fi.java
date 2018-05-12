package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

public class Fi extends Keyword
{
	private static final TypeStack EXPECTED_TYPES = new TypeStack(new Class<?>[] {});
	
	public Fi(ParameterStack args) throws IllegalMethodTypeException 
	{
		super(args);
	}

	@Override
	public void run() 
	{
		Registers.r3.dec();
		/* This method should do nothing */
	}
}

