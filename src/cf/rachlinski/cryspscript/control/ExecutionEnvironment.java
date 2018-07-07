package cf.rachlinski.cryspscript.control;

import cf.rachlinski.cryspscript.prerun.parsing.line.Line;
import cf.rachlinski.cryspscript.runtime.codeAccessors.Registers;
import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ExecutionStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;

import java.io.*;
import java.util.*;

/**
 * Environment for execution of scripts
 * Contains variable maps to store parameter and global variables, and an execution stack containing all instructions
 */
public class ExecutionEnvironment
{
	/**
	 * Top of the list (size - 1) is the instance map corresponding to the current depth
	 * Instance (method) variable maps are added after the global variable contents
	 */
	private LinkedList<HashMap<String, Variable<?>>> varMaps;
	private ExecutionStack executionStack;

	/**
	 *
	 * @param scriptPath
	 * @throws IOException
	 */
	public ExecutionEnvironment(File scriptPath) throws IOException
	{
		FileReader fos = new FileReader(scriptPath);
		BufferedReader buff = new BufferedReader(fos);

		Object[] lines = buff.lines()
				.filter(n -> !n.trim().equals(""))
				.filter(n -> n.trim().charAt(0) != '#')
				.toArray();

		Line[] parsed = new Line[lines.length];

		for(int i = 0; i < lines.length; i++)
		{
			parsed[i] = new Line((String) lines[i]);
		}

		this.executionStack = new ExecutionStack(parsed);
		this.varMaps = new LinkedList<>();

		varMaps.add(new HashMap<>());

		buff.close();
	}

	/**
	 * Development constructor
	 * @param executionStack executionstack to use
	 */
	public ExecutionEnvironment(ExecutionStack executionStack)
	{
		varMaps = new LinkedList<>();
		varMaps.add(new HashMap<>());
		this.executionStack = executionStack;
	}

	public ExecutionStack getExecutionStack()
	{
		return executionStack;
	}

	/**
	 * Mixing naming conventions is fun
	 */
	public void EXECUTE_PROGRAM()
	{
		while(!executionStack.finished())
		{
			executionStack.exec();
		}
	}

	/* VARIABLE STUFF */
	/**
	 * Put a variable on the correct variable map
	 * @param name the name of the variable to use as the key
	 * @param value the {@code Variable} to put
	 */
	public void putVariable(String name, Variable<?> value)
	{
		varMaps.get(Registers.r3.getValue()).put(name, value);
	}

	/**
	 * Return the variable with the corresponding name.
	 * The method searches instance variables first, before searching for
	 * @param name the name of the variable to get the value of
	 * @return the variable specified by the name
	 */
	public Variable<?> getVariable(String name)
	{


		for(int i = varMaps.size() - 1; i >= 0; i--)
		{
			if(varMaps.get(i).containsKey(name.trim()))
			{
				return varMaps.get(i).get(name.trim());
			}
		}
		return Variable.NULL;

	}

	/**
	 * Create an instance variable contents
	 * @param variableMap Add an instance variable contents to the variable maps
	 */
	public void createInstanceVarMap(HashMap<String, Variable<?>> variableMap)
	{
		varMaps.add(variableMap);
	}

	/**
	 * Removes the topmost variable contents, or the one at index 1
	 * @throws IllegalArgumentException if there are no instance variable maps
	 */
	public void freeInstanceMap()
	{
		if(varMaps.size() == 1)
		{
			throw new IllegalArgumentException("No instance variable contents found");
		}

		varMaps.remove(varMaps.size() - 1);
	}


	@Override
	public String toString()
	{
		return varMaps.get(0).toString();
	}
}
