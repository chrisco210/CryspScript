package cf.rachlinski.cryspscript.runtime.exec.keyword.defaultkeywords;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Keyword;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Runnable;

@Runnable("nop")
public class NoOp extends Keyword
{

	public NoOp(ParameterStack args)
	{
		super(args);
	}

	@Override
	public void run()
	{
		return;
	}
}
