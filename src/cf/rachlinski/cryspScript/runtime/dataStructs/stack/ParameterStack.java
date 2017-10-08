package cf.rachlinski.cryspScript.runtime.dataStructs.stack;

import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;

/**
 * Subclass for stacks of parameters to pass to functions
 */
public class ParameterStack extends Stack<Variable<?>>
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
