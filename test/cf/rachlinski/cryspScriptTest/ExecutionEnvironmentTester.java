package cf.rachlinski.cryspScriptTest;

import cf.rachlinski.cryspScript.Control.ExecutionEnvironment;
import cf.rachlinski.cryspScript.Control.ScriptEngine;
import cf.rachlinski.cryspScript.runtime.dataStructs.map.GlobalVariableMap;
import sun.font.Script;

import java.io.File;
import java.io.IOException;

public class ExecutionEnvironmentTester
{
	public static void main(String[] args) throws IOException
	{
		ScriptEngine.env.EXECUTE_PROGRAM();
	}
}
