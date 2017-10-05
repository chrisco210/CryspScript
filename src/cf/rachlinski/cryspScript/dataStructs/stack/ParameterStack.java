package cf.rachlinski.cryspScript.dataStructs.stack;

import cf.rachlinski.cryspScript.dataStructs.variable.Variable;

/**
 * Subclass for stacks of parameters to pass to functions
 */
public class ParameterStack extends Stack
{
	/**
	 * Construct a new Stack object given contents
	 *
	 * @param contents the array of {@code Variable<?>}s to initialize
	 */
	public ParameterStack(Variable<?>[] contents)
	{
		super(contents);
	}
}
