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

	public Variable<?> get(E key)
	{
		return map.get(key);
	}
}
