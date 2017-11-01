package cf.rachlinski.cryspScript.Control;

import cf.rachlinski.cryspScript.runtime.dataStructs.map.GlobalVariableMap;
import cf.rachlinski.cryspScript.runtime.dataStructs.map.InstanceVariableMap;
import cf.rachlinski.cryspScript.runtime.dataStructs.map.Map;
import cf.rachlinski.cryspScript.runtime.dataStructs.stack.ExecutionStack;
import cf.rachlinski.cryspScript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspScript.runtime.exec.method.IllegalMethodTypeException;

import java.io.File;
import java.util.LinkedList;

/**
 * Environment for execution of scripts
 * Contains variable maps to store parameter and global variables, and an execution stack containing all instructions
 */
public class ExecutionEnvironment
{
	/**
	 * First link is always the global variable map
	 * Instance (method) variable maps are added after the global variable map
	 */
	private LinkedList<Map> varMaps;
	private ExecutionStack stack;

	/**
	 *
	 * @param globalVariableMap
	 * @param scriptPath
	 */
	public ExecutionEnvironment(GlobalVariableMap globalVariableMap, File scriptPath)
	{

	}

	/**
	 * Development constructor
	 * @param stack
	 */
	public ExecutionEnvironment(ExecutionStack stack)
	{
		varMaps = new LinkedList<Map>();
		varMaps.add(new GlobalVariableMap());
		this.stack = stack;
	}

	/**
	 * Put a variable on the global variable map
	 * @param name the name of the variable
	 * @param value the variable to put
	 */
	public void putGlobalVariable(String name, Variable<?> value)
	{
		varMaps.getFirst().put(name, value);
	}

	/**
	 * Attempt to retrieve a global variable from the variable map
	 * @param name
	 * @return
	 */
	public Variable<?> getGlobalVariable(String name)
	{
		return varMaps.getFirst().get(name);
	}

	/**
	 * Remove a global variable from the global variable map
	 * @param name
	 */
	public void freeGlobalVariable(String name)
	{
		((GlobalVariableMap) varMaps.getFirst()).free(name);
	}

	/**
	 * Create an instance variable map
	 * @param variableMap
	 */
	public void createInstanceVarMap(InstanceVariableMap variableMap)
	{
		varMaps.add(1, variableMap);
	}

	/**
	 * Removes the topmost variable map, or the one at index 1
	 * @throws IllegalArgumentException if there are no instance variable maps
	 */
	public void freeInstanceMap()
	{
		if(varMaps.size() == 1)
		{
			throw new IllegalArgumentException("No instance variable map found");
		}

		varMaps.remove(1);
	}

	/**
	 * Get a variable from the topmost instance variable map, in other words, the Map at index 1
	 * @param name the name of the variable
	 * @return the variable specified
	 */
	public Variable<?> getInstanceVariable(String name)
	{
		return varMaps.get(1).get(name);
	}


	/**
	 * Return the variable with the corresponding name.
	 * The method searches instance variables first, before searching for
	 * @param name the name of the variable to get the value of
	 * @return the variable specified by the name
	 */
	public Variable<?> getVaraible(String name)
	{
		if(varMaps.get(1).contains(name))
		{
			return varMaps.get(1).get(name);
		}

		return varMaps.getFirst().get(name);
	}
}
