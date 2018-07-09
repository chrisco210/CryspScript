package cf.rachlinski.cryspscript.runtime.dataStructs.stack;

import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;

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

	/**
	 * Check if a given parameter stack has the correct types
	 * @param stack the stack to compare to
	 * @param type the types to compare to
	 * @return if a given parameter stack has the correct types
	 */
	public static boolean correctType(ParameterStack stack, TypeStack type)
	{
		return type.compareTypes(stack);
	}


}
