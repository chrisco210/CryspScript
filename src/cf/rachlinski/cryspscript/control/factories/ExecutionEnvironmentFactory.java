package cf.rachlinski.cryspscript.control.factories;

import cf.rachlinski.cryspscript.control.ExecutionEnvironment;

import java.io.File;
import java.io.IOException;

public class ExecutionEnvironmentFactory
{
	private static ExecutionEnvironment provide;

	public static ExecutionEnvironment newInstance(File file) throws IOException
	{
		provide = new ExecutionEnvironment(file);
		return getProvide();
	}

	public static ExecutionEnvironment getProvide()
	{
		return provide;
	}
}
