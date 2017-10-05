package cf.rachlinski.cryspScript.dataStructs.variable;

/**
 * Variable object
 * @param <E> the type of the variable
 */
public class Variable<E>
{
	/**
	 * The value of the variable
	 */
	private E value;

	/**
	 * Construct a new variable of given type
	 * @param val the value of the new variable
	 */
	public Variable(E val)
	{
		this.value = val;
	}

	/**
	 * Return the value of the variable
	 * @return
	 */
	public E getValue()
	{
		return value;
	}
}
