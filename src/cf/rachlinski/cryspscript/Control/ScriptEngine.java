package cf.rachlinski.cryspscript.Control;

import cf.rachlinski.cryspscript.runtime.dataStructs.map.GlobalVariableMap;

import java.io.File;
import java.io.IOException;

/**
 * Class that handles loading of scripts and input from a console stream, as well as output
 *
 */
public final class ScriptEngine
{

	public static ExecutionEnvironment env;
	static
	{
		try
		{
			env = new ExecutionEnvironment(new GlobalVariableMap(),		//TODO more robust system, and NO STATIC SHIT EDVERYHWERE
				new File("C:\\Users\\Christopher\\Programming\\Java\\CryspScript\\test\\cf\\rachlinski\\cryspScriptTest\\ScriptTest")
			);
		} catch (IOException e)
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
