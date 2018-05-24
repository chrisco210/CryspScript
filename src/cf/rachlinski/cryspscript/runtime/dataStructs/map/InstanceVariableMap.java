package cf.rachlinski.cryspscript.runtime.dataStructs.map;

import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;

import java.util.HashMap;

/**
 * Variable contents for variables that will be removed later
 * Variables stored in this kind of contents would be those used in methods/subroutines
 */
public class InstanceVariableMap extends Map<String>
{
	/*
	public InstanceVariableMap(ParameterStack stack)
	{
		contents = new HashMap<>();

		Integer i = 0;

		for(Variable<?> v : stack)
		{
			contents.put(i, v);
			i++;
		}
	}
	*/

	/**
	 * Construct an empty {@code InstanceVariableMap}
	 */
	public InstanceVariableMap()
	{
		this.contents = new HashMap<>();
	}

	/**
	 * Remove all variables and Garbage collect when the Instance contents has finished
	 */
	public void clear()
	{
		contents.clear();
	}


	@Override
	public Variable<?> get(String key)
	{
		return contents.get(key);
	}

	/**
	 * Check if a variable exists in a contents
	 * @param name the name of the variable to check
	 * @return if a variable exists in a contents
	 */
	@Override
	public boolean contains(String name)
	{
		//Replacement for containsKey, because it doesn't work
		for(String elem : contents.keySet())
		{
			if(name.trim().equals(elem.trim()))
				return true;
		}
		return false;
	}
}
