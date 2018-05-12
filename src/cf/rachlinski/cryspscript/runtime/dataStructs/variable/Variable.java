package cf.rachlinski.cryspscript.runtime.dataStructs.variable;

/**
 * Variable object
 * @param <E> the type of the variable
 */
public class Variable<E>
{
	public static final Variable<Integer> NULL = new Variable<>(null);
	public static final Variable<Integer> ONE = new Variable<>(1);
	/**
	 * The value of the variable
	 */
	protected E value;

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
	 * @return the value of the variable
	 */
	public E getValue()
	{
		return value;
	}

	/**
	 * Return the type of the variable
	 * @return the type of the variable
	 */
	public Class<?> getType()
	{
		return value.getClass();
	}

	/**
	 * Check if the variable is of a certain type
	 * @param clazz the type to compare to
	 * @return if the variable is of type class
	 */
	public boolean typeof(Class<?> clazz)
	{
		return value.getClass().equals(clazz);
	}

	/**
	 * Check if the variable is of a certain type, given an instance of a type
	 * @param instance the instance of a class to compare to
	 * @param <T> the type of the instance
	 * @return if the variable is of type instance
	 */
	public <T> boolean typeof(T instance)
	{
		return value.getClass().equals(instance.getClass());
	}

	@Override
	public String toString()
	{
		return value + "";
	}

	@Override
	public boolean equals(Object obj)
	{
		if(getClass() != obj.getClass())
			return false;

		return this.value == ((Variable<?>) obj).value;
	}
}
