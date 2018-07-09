
package cf.rachlinski.cryspscript.runtime.exec.keyword.defaultkeywords;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.TypeStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspscript.runtime.exec.Executable;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Keyword;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Runnable;

import java.lang.reflect.Type;

/**
 * Print output to standard output
 * Syntax <br>
 * print {to_print}
 */
@Runnable("print")
public final class Print extends Keyword
{
	private static final TypeStack EXPECTED_TYPES = new TypeStack(new Class<?>[] {String.class});


	public Print(ParameterStack args)
	{
		super(args);
	}

	@Override
	public void run()
	{
		System.out.println(args.get(0));
	}
}
