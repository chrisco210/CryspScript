package cf.rachlinski.cryspScriptTest;

import cf.rachlinski.cryspScript.Control.ExecutionEnvironment;
import cf.rachlinski.cryspScript.runtime.dataStructs.map.GlobalVariableMap;

import java.io.File;
import java.io.IOException;

public class ExecutionEnvironmentTester
{
	public static void main(String[] args) throws IOException
	{
		ExecutionEnvironment env = new ExecutionEnvironment(new GlobalVariableMap(),
				new File("C:\\Users\\Christopher\\Programming\\Java\\CryspScript\\test\\cf\\rachlinski\\cryspScriptTest\\ScriptTest")
		);

		env.EXECUTE_PROGRAM();
	}
}
