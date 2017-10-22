package cf.rachlinski.cryspScript.runtime.dataStructs.stack;

import cf.rachlinski.cryspScript.runtime.exec.method.IllegalMethodTypeException;

public class TypeStack extends Stack<Class<?>>
{
	/**
	 * Construct a new Stack object given contents
	 *
	 * @param contents the array of {@code Variable<?>}s to initialize
	 */
	public TypeStack(Class<?>[] contents)
	{
		super(contents);
	}

	public boolean compareTypes(ParameterStack stack)
	{
		boolean correctTypes = true;

		if(stack.size() != this.size())
			throw new IllegalMethodTypeException(this, stack);

		for(int i = 0; i < stack.size(); i++)
		{
			correctTypes = stack.get(i).typeof(contents[i]);
		}


		return correctTypes;
	}

}
