
package cf.rachlinski.cryspScript.runtime.exec.keyword;

import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspScript.runtime.exec.Executable;

/**
 * Print output to standard output
 * Syntax <br>
 * print {to_print}
 */
public final class Print extends Keyword
{
	static
	{
		EXPECTED_TYPES = new TypeStack(new Class<?>[] {String.class});
	}

	public Print(ParameterStack args)
	{
		super(args, EXPECTED_TYPES);
	}

	@Override
	public void run()
	{

		System.out.println(args.get(0));
	}
}
