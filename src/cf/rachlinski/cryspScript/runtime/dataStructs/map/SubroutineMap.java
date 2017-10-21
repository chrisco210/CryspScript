package cf.rachlinski.cryspScript.runtime.dataStructs.map;

import cf.rachlinski.cryspScript.runtime.exec.method.Subroutine;
import cf.rachlinski.cryspScript.runtime.exec.method.funcEval.Function;
import cf.rachlinski.cryspScript.runtime.exec.method.routine.Routine;

import java.util.HashMap;

/**
 * Class to map a string name of a subroutine to a function
 */
public class SubroutineMap
{
	private HashMap<String, Subroutine> map;

	/**
	 * Construct a new FunctionMap
	 */
	public SubroutineMap()
	{
		this.map  = new HashMap<String, Subroutine>();
	}

	/**
	 * Return the routine specified by it's name
	 * @param key the name of the subroutine
	 * @return the subroutine (routine/function) object of the subroutine with the given nam,e
	 */
	public Subroutine getRoutine(String key)
	{
		return map.get(key);
	}
}
