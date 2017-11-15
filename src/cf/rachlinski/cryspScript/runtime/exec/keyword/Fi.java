package cf.rachlinski.cryspScript.runtime.exec.keyword;

import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspScript.runtime.exec.method.IllegalMethodTypeException;

import java.lang.reflect.Type;

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
		/* This method should do nothing */
	}
}

