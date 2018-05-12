package cf.rachlinski.cryspscript.runtime.dataStructs.map;

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

}
