package cf.rachlinski.cryspscript.runtime.exec.keyword.defaultkeywords;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Keyword;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Runnable;
import cf.rachlinski.cryspscript.runtime.exec.method.IllegalMethodTypeException;

@Runnable("EndW")
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
