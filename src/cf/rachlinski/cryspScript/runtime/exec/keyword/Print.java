
package cf.rachlinski.cryspScript.runtime.exec.keyword;

import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;

/**
 * Print output to standard output
 */
public class Print extends Keyword
{
	public Print(ParameterStack args)
	{
		super(args);
	}

	@Override
	public void run()
	{
		StringBuffer buff = new StringBuffer();

		for(Variable<?> v : args)
			buff.append(v.toString());

		System.out.println(buff.toString());
	}
}
