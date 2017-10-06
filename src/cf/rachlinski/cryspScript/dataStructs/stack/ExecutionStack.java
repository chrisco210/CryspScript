package cf.rachlinski.cryspScript.dataStructs.stack;

import cf.rachlinski.cryspScript.dataStructs.variable.Variable;
import cf.rachlinski.cryspScript.exec.Executable;

public class ExecutionStack extends Stack<Executable>
{

	/**
	 * Construct a new Stack object given contents
	 *
	 * @param contents the array of {@code Variable<?>}s to initialize
	 */
	public ExecutionStack(Executable[] contents)
	{
		super(contents);
	}


}
