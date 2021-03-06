package cf.rachlinski.cryspscript.control;

import cf.rachlinski.cryspscript.control.factories.ExecutionEnvironmentFactory;
import cf.rachlinski.cryspscript.runtime.dataStructs.map.Map;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Class that handles loading of scripts and input from a console stream, as well as output
 *
 */
public final class ScriptEngine
{

	static ExecutionEnvironment env;
	static
	{
		try
		{
			env = ExecutionEnvironmentFactory.newInstance(new File("C:\\Users\\chris\\Programming\\Java\\CryspScript\\test\\cf\\rachlinski\\cryspScriptTest\\ScriptTest"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	/*
	Do not instantiate
	 */
	private ScriptEngine()
	{

	}

	/**
	 * Parses a string and executes a command based on that string.  Useful for implementing a REPL command interpreter
	 * @param text the text to parse
	 */
	public void parse(String text)
	{
		//TODO
	}
}
