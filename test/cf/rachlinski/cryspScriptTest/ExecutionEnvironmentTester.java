package cf.rachlinski.cryspScriptTest;

import cf.rachlinski.cryspscript.control.ScriptEngine;
import cf.rachlinski.cryspscript.control.factories.ExecutionEnvironmentFactory;

import java.io.File;
import java.io.IOException;

public class ExecutionEnvironmentTester
{
	public static void main(String[] args) throws IOException
	{
		ExecutionEnvironmentFactory.newInstance(new File("C:\\Users\\chris\\Programming\\Java\\CryspScript\\test\\cf\\rachlinski\\cryspScriptTest\\ScriptTest")).EXECUTE_PROGRAM();
	}
}
