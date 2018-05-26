package cf.rachlinski.cryspscript.runtime.dataStructs.map;

import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;

import java.util.HashMap;

/**
 * Superclass for all Map data structures
 */
public abstract class Map<E>
{
	/**
	 * Map to put variables on
	 */
	protected HashMap<String, Variable<?>> contents;

	public Map()
	{
		contents = new HashMap<>();
	}


	/**
	 * Retrieve a variable from the contents given a key
	 * @param key the key of the desired variable
	 * @return the Variable object corresponding to the given key
	 */
	public abstract Variable<?> get(E key);

	/**
	 * Put a variable on the contents with key key, and value value
	 * @param key the key to use
	 * @param value the value to put on the contents
	 */
	public void put(String key, Variable<?> value)
	{
		contents.put(key, value);
	}

	/**
	 * Check if a variable exists in a contents
	 * @param name the name of the variable to check
	 * @return if a variable exists in a contents
	 */
	public abstract boolean contains(E name);

	@Override
	public String toString()
	{
		return contents.toString();
	}
}
