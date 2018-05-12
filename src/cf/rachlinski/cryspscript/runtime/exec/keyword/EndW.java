package cf.rachlinski.cryspscript.runtime.exec.keyword;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

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
