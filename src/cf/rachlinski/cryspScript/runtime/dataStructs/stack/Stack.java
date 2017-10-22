package cf.rachlinski.cryspScript.runtime.dataStructs.stack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Superclass for all stack data structures
 *
 */
public class Stack<E>	implements Iterable<E>
{
	/**
	 * Stack of E to store
	 */
	protected E[] contents;

	/**
	 * Construct a new Stack object given contents
	 * @param contents
	 */
	public Stack(E[] contents)
	{
		this.contents = contents;
	}

	/**
	 * Return the size of the stack
	 * @return the size of the stack
	 */
	public int size()
	{
		return contents.length;
	}

	/**
	 * Return the size of the stack
	 * Alias of the size method
	 * @return the size of the stack
	 */
	public int length()
	{
		return contents.length;
	}

	/**
	 * Return the entire stack of E
	 * @return the entire stack of E
	 */
	public E[] getContents()
	{
		return contents;
	}

	/**
	 * Return the E at the specified index
	 * @param index the index of the E
	 * @return the variable at specified index
	 */
	public E get(int index)
	{
		return contents[index];
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for(E c : contents)
		{
			sb.append(c.toString() + ", ");
		}
		return "Stack [" + sb.toString() + "]";
	}

	/**
	 * Return the types of all of the contents of the stack as a string
	 * @return the types of the contents of teh stack as a string
	 */
	public String typesToString()
	{
		StringBuilder sb = new StringBuilder();

		for(E c : contents)
		{
			sb.append(c.getClass().toString() + ", ");
		}

		return "StackTypes [" + sb.toString() + "]";
	}

	public Iterator<E> iterator()
	{
		return Arrays.asList(contents).iterator();
	}
}
