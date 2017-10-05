package cf.rachlinski.cryspScript.dataStructs.stack;

import cf.rachlinski.cryspScript.dataStructs.variable.Variable;

/**
 * Superclass for all stack data structures
 *
 */
public class Stack
{
	/**
	 * Stack of Variables to store
	 */
	protected Variable<?>[] contents;

	/**
	 * Construct a new Stack object given contents
	 * @param contents the array of {@code Variable<?>}s to initialize
	 */
	public Stack(Variable<?>[] contents)
	{
		this.contents = contents;
	}

	/**
	 * Return the entire stack of Variables
	 * @return the entire stack of variables
	 */
	public Variable<?>[] getContents()
	{
		return contents;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public Variable<?> get(int index)
	{
		return contents[index];
	}
}
