package cf.rachlinski.cryspScript.runtime.dataStructs.map;

import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;

import java.util.HashMap;

/**
 * Superclass for all Map data structures
 */
public class Map<E>
{
	/**
	 * Map to put variables on
	 */
	protected HashMap<E, Variable<?>> map;

	/**
	 * Retrieve a variable from the map given a key
	 * @param key the key of the desired variable
	 * @return the Variable object corresponding to the given key
	 */
	public Variable<?> get(E key)
	{
		return map.get(key);
	}

	/**
	 * Put a variable on the map with key key, and value value
	 * @param key the key to use
	 * @param value the value to put on the map
	 */
	public void put(E key, Variable<?> value)
	{
		map.put(key, value);
	}

	/**
	 * Check if a variable exists in a map
	 * @param name the name of the variable to check
	 * @return if a variable exists in a map
	 */
	public boolean contains(String name)
	{
		return map.containsKey(name);
	}
}
