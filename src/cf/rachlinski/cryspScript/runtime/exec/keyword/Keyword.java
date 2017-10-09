package cf.rachlinski.cryspScript.runtime.exec.keyword;

import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.exec.Executable;

/**
 * Represents an executable command
 */
public abstract class Keyword implements Executable
{
	protected ParameterStack args;

	/**
	 * Construct a command given arguments
	 * @param args the arguments to supply
	 * @throws IllegalArgumentException if the number of parameters supplied does not match the argument count
	 */
	public Keyword(ParameterStack args)
	{
		this.args = args;
	}
}
