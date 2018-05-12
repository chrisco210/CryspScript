package cf.rachlinski.cryspScriptTest;

import cf.rachlinski.cryspscript.runtime.dataStructs.stack.ParameterStack;
import cf.rachlinski.cryspscript.runtime.dataStructs.variable.Variable;
import cf.rachlinski.cryspscript.runtime.exec.Executable;
import cf.rachlinski.cryspscript.runtime.exec.keyword.Print;

public class ExecutionTester
{
	public static void main(String[] args)
	{
		Executable[] com = new Executable[]
				{
						new Print(
								new ParameterStack(
										new Variable<?>[]
												{
														new Variable<String>("Yahta Yahta Yahta"),
														new Variable<Integer>(5)
												}
								)
						),
						new Print(
								new ParameterStack(
									new Variable<?>[]
											{
												new Variable<String>("Yahta to")
											}
								)
						)
				};

		for(Executable e : com)
			e.run();
	}
}
