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
	 * Stack of Variables to store
	 */
	protected E[] contents;

	/**
	 * Construct a new Stack object given contents
	 * @param contents the array of {@code Variable<?>}s to initialize
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
	 * Return the entire stack of Variables
	 * @return the entire stack of variables
	 */
	public E[] getContents()
	{
		return contents;
	}

	/**
	 * Return the Variable at the specified index
	 * @param index the index of the variable
	 * @return the variable at specified index
	 */
	public E get(int index)
	{
		return contents[index];
	}

	public Iterator<E> iterator()
	{
		return Arrays.asList(contents).iterator();
	}
}
