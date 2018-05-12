package cf.rachlinski.cryspScript.runtime.exec.keyword;

import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.exec.method.IllegalMethodTypeException;

public class EndW extends Keyword
{
	public EndW(ParameterStack args) throws IllegalMethodTypeException
	{
		super(args);
	}

	@Override
	public void run()
	{
		return; /*This methods intentional does nothing*/
	}
}
