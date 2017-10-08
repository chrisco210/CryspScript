package cf.rachlinski.cryspScript.runtime.dataStructs.map;

import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;

import java.util.HashMap;

/**
 * Variable map for variables that will be removed later
 * Variables stored in this kind of map would be those used in methods/subroutines
 */
public class InstanceVariableMap extends Map<Integer>
{
	public InstanceVariableMap(ParameterStack stack)
	{
		map = new HashMap<Integer, Variable<?>>();

		Integer i = 0;

		for(Variable<?> v : stack)
		{
			map.put(i, v);
			i++;
		}
	}

	/**
	 * Remove all variables and Garbage collect when the Instance map has finished
	 */
	public void clear()
	{
		map.clear();
		System.gc();
	}

}
